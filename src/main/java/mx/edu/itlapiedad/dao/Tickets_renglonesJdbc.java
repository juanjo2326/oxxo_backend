package mx.edu.itlapiedad.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;


import mx.edu.itlapiedad.models.Tickets_renglones;

public class Tickets_renglonesJDBC implements Tickets_renglonesDAO{
	@Autowired
	JdbcTemplate conexion;
	
	
	public List<Tickets_renglones> consultarTickets_renglones() {
		String sql_query = "SELECT * FROM tickets_renglones";
		return conexion.query(sql_query, new RowMapper<Tickets_renglones>() {
			public Tickets_renglones mapRow(ResultSet rs,int rowNum) throws SQLException {
				Tickets_renglones TR = new Tickets_renglones();
				TR.setId(rs.getInt("id"));
				TR.setTicket_id(rs.getInt("ticket_id"));
				TR.setProducto_id(rs.getInt("producto_id"));
				TR.setCantidad(rs.getInt("cantidad"));
				TR.setPrecio(rs.getFloat("precio"));
				TR.setImporte(rs.getFloat("importe"));
				return TR;
				
			}

			
		});
	}
	
	public Tickets_renglones buscarTickets_renglones(int id) {
		String sql_query = "SELECT * FROM Tickets_renglones WHERE id=?";
		return conexion.queryForObject(sql_query, new RowMapper<Tickets_renglones>() {
			public Tickets_renglones mapRow(ResultSet rs, int rowNum) throws SQLException {
				Tickets_renglones TR = new Tickets_renglones();
				TR.setId(rs.getInt("id"));
				TR.setTicket_id(rs.getInt("ticket_id"));
				TR.setProducto_id(rs.getInt("producto_id"));
				TR.setCantidad(rs.getInt("cantidad"));
				TR.setPrecio(rs.getFloat("precio"));
				TR.setImporte(rs.getFloat("importe"));
				return TR;
			}
			
		},id);
	}
	
	
	public Tickets_renglones insertarTickets_renglones(Tickets_renglones TR) {
		
		SimpleJdbcInsert insert=new SimpleJdbcInsert(conexion).withTableName("Tickets_renglones")
				.usingColumns("cantidad","precio","importe")
				.usingGeneratedKeyColumns("id");
		Map<String,Object> datos = new HashMap<>();
	datos.put("cantidad", TR.getCantidad());
	datos.put("precio", TR.getPrecio());
	datos.put("importe", TR.getImporte());
	
		
		Number id=insert.executeAndReturnKey(datos);
		TR.setId(id.intValue());
		return TR;
	}
	
	
	public void actualizarTickets_renglones(Tickets_renglones TR) {
		String sql_update = "UPDATE productos SET cantidad=?,"
				+ "precio=?, importe=?"
				+ "WHERE id=?";
		conexion.update(sql_update,TR.getCantidad(),
				TR.getPrecio(),
				TR.getImporte());
				
	
	}
	
	

}
