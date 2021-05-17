package mx.edu.itlapiedad.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import mx.edu.itlapiedad.models.TicketReng;

@Repository
public class TicketRengJdbc implements TicketRengDao {
	@Autowired
	JdbcTemplate conexion;

	@Override
	public TicketReng buscar(int id) {
		String sql_query = "SELECT * FROM ticket_renglones WHERE id=?";
		return conexion.queryForObject(sql_query, new RowMapper<TicketReng>() {
			public TicketReng mapRow(ResultSet rs, int rowNum) throws SQLException {
				TicketReng ticketReng = new TicketReng();
				ticketReng.setId(rs.getInt("id"));
				ticketReng.setTICKET_id(rs.getInt("TICKET_id"));
				ticketReng.setPRODUCTO_id(rs.getInt("PRODUCTO_id"));
				ticketReng.setCantidad(rs.getInt("cantidad"));
				ticketReng.setPrecio(rs.getFloat("precio"));
				ticketReng.setImporte(rs.getFloat("importe"));
				ticketReng.setActivo(rs.getInt("activo"));
				return ticketReng;
			}

		}, id);
	}

	@Override
	public TicketReng insertar(TicketReng ticketReng) {

		SimpleJdbcInsert insert = new SimpleJdbcInsert(conexion).withTableName("ticketReng")
				.usingColumns("cantidad", "precio", "TICKET_id","PRODUCTO_id").usingGeneratedKeyColumns("id");
		Map<String, Object> datos = new HashMap<>();
		datos.put("cantidad", ticketReng.getCantidad());
		datos.put("precio", ticketReng.getPrecio());
		datos.put("TICKET_id", ticketReng.getTICKET_id());
		datos.put("PRODUCTO_id", ticketReng.getPRODUCTO_id());
		
		Number id = insert.executeAndReturnKey(datos);
		ticketReng.setId(id.intValue());
		ticketReng.setActivo(1);
		return ticketReng;
	}

	@Override
	public List<TicketReng> consultarTicketReng() {
		// TODO Auto-generated method stub
		String sql_query = "SELECT * FROM ticket_renglones where activo=1";
		return conexion.query(sql_query, new RowMapper<TicketReng>() {
			public TicketReng mapRow(ResultSet rs, int rowNum) throws SQLException {
				TicketReng ticketReng = new TicketReng();
				ticketReng.setId(rs.getInt("id"));
				ticketReng.setTICKET_id(rs.getInt("TICKET_id"));
				ticketReng.setPRODUCTO_id(rs.getInt("PRODUCTO_id"));
				ticketReng.setCantidad(rs.getInt("cantidad"));
				ticketReng.setPrecio(rs.getFloat("precio"));
				ticketReng.setImporte(rs.getFloat("importe"));
				ticketReng.setActivo(rs.getInt("activo"));
				return ticketReng;

			}

		});
	}

	@Override
	public void actualizar(TicketReng ticketReng) {
		String sql_update = "UPDATE ticket_renglones SET cantidad = ?, precio = ?, TICKET_id=?, PRODUCTO_id=? " + " WHERE id = ?";
		conexion.update(sql_update,
				ticketReng.getCantidad(), 
				ticketReng.getPrecio(),
			//	ticket_renglones.getImporte(), 
				ticketReng.getTICKET_id(), 
				ticketReng.getPRODUCTO_id(), 
				ticketReng.getId());
		
		

	}

	@Override
	public void eliminar(int id) {
		String sql_update="UPDATE ticket_renglones SET activo=0 WHERE id=?";
		conexion.update(sql_update,id);
	}

	
}
