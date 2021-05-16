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


import mx.edu.itlapiedad.models.Cajeros;


@Repository


public class CajerosJdbc implements CajerosDao {
	
	@Autowired
	JdbcTemplate conexion;
	
	
	@Override
	public List<Cajeros> consultarCajeros() {
		String sql_query = "SELECT * FROM cajeros";
		return conexion.query(sql_query, new RowMapper<Cajeros>() {
			public Cajeros mapRow(ResultSet rs,int rowNum) throws SQLException {
				Cajeros Cajeros = new Cajeros();
				Cajeros.setId(rs.getInt("id"));
				Cajeros.setNombre(rs.getString("Nombre"));
				return Cajeros;
				
			}

			
		});
	}


	@Override
	public Cajeros buscar(int id) {
		String sql_query = "SELECT * FROM cajeros WHERE id=?";
		return conexion.queryForObject(sql_query, new RowMapper<Cajeros>() {
			public Cajeros mapRow(ResultSet rs, int rowNum) throws SQLException {
				Cajeros Cajeros = new Cajeros();
				Cajeros.setId(rs.getInt("id"));
				Cajeros.setNombre(rs.getString("Nombre"));
				return Cajeros;
			}
			
		},id);
	}
	
	@Override
	public Cajeros insertar(Cajeros Cajeros) {
		
		SimpleJdbcInsert insert=new SimpleJdbcInsert(conexion).withTableName("Cajeros")
				.usingColumns("Nombre")
				.usingGeneratedKeyColumns("id");
		Map<String,Object> datos = new HashMap<>();
		datos.put("Nombre", Cajeros.getNombre());
	         
		
		Number id=insert.executeAndReturnKey(datos);
		Cajeros.setId(id.intValue());
		return Cajeros;
	}

}
