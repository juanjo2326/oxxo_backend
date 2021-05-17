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


import mx.edu.itlapiedad.models.Tickets;
@Repository

public class TicketsJdbc implements TicketsDao{
	
	@Autowired
	JdbcTemplate conexion;

	@Override
	public List<Tickets> consultarTickets() {
		String sql_query = "SELECT * FROM Tickets WHERE activo=1";
		return conexion.query(sql_query, new RowMapper<Tickets>() {
			public Tickets mapRow(ResultSet rs,int rowNum) throws SQLException {
				Tickets Tickets = new Tickets();
				Tickets.setId(rs.getInt("id"));
				Tickets.setFecha_hora(rs.getTimestamp("fecha_hora"));
				Tickets.setTotal(rs.getFloat("total"));
				Tickets.setCAJERO_id(rs.getInt("CAJERO_id"));
				Tickets.setActivo(rs.getInt("activo"));
				return Tickets;
				
			}

			
		});
	}
	
	
	@Override
	public Tickets buscar(int id) {
		String sql_query = "SELECT * FROM Tickets WHERE id=?";
		return conexion.queryForObject(sql_query, new RowMapper<Tickets>() {
			public Tickets mapRow(ResultSet rs, int rowNum) throws SQLException {
				Tickets Tickets = new Tickets();
				Tickets.setId(rs.getInt("id"));
				Tickets.setFecha_hora(rs.getTimestamp("fecha_hora"));
				Tickets.setTotal(rs.getFloat("total"));
				Tickets.setCAJERO_id(rs.getInt("CAJERO_id"));
				Tickets.setActivo(rs.getInt("activo"));
				return Tickets;
			}
			
		},id);
	}
	
	
	@Override
	public Tickets insertar(Tickets Tickets) {

		SimpleJdbcInsert insert = new SimpleJdbcInsert(conexion).withTableName("Tickets")
				.usingColumns("total","CAJERO_id").usingGeneratedKeyColumns("id");
		Map<String, Object> datos = new HashMap<>();
		datos.put("total", Tickets.getTotal());
		datos.put("CAJERO_id", Tickets.getCAJERO_id());
		Number id = insert.executeAndReturnKey(datos);
		Tickets.setId(id.intValue());
		Tickets.setActivo(1);
	//	tickets.setFecha_hora("CURRENT_TIMESTAMP");
		return Tickets;
	}
	
	
	@Override
	public void actualizar(Tickets Tickets) {
		String sql_update = "UPDATE Tickets SET total = ?, CAJERO_id =?  WHERE id = ?";
		conexion.update(sql_update, 
				Tickets.getTotal(),
				Tickets.getCAJERO_id(),
		    //    tickets.getFecha_hora(),
				Tickets.getId());
		        
			}
	
	
	@Override
	public void eliminar(int id) {
		String sql_update="UPDATE Tickets SET activo=0 WHERE id=?";
		conexion.update(sql_update,id);
		
	}

}
