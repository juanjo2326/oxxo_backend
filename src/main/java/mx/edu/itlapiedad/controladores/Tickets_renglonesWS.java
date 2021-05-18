package mx.edu.itlapiedad.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import mx.edu.itlapiedad.models.Tickets_renglones;

import mx.edu.itlapiedad.services.Tickets_renglonesService;

public class Tickets_renglonesWS {
	@Autowired
	Tickets_renglonesService servicio;

	@GetMapping()
	public ResponseEntity<?> consultarTickets_renglones(){
		List<Tickets_renglones> resultado;
		try {
			resultado = servicio.consultarTickets_renglones();
		}catch (DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Tickets_renglones>>(resultado,HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarTickets_renglones(@PathVariable int id){
		Tickets_renglones resultado;
		try {
			resultado=servicio.buscarTickets_renglones(id);
		} catch (DataAccessException e) {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Tickets_renglones>(resultado,HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<?>insertarTickets_renglones(@RequestBody Tickets_renglones TR){
		Tickets_renglones resultado;
	try {
		resultado=servicio.insertarTickets_renglones(TR);
		
	} catch (DataAccessException e) {
		System.out.println(e);
	return new ResponseEntity<>(HttpStatus.CONFLICT);
	}	
		return new ResponseEntity<Tickets_renglones>(resultado,HttpStatus.CREATED);
	
	}
			@PutMapping()
			public ResponseEntity<?> actualizarTickets_renglones(@RequestBody Tickets_renglones TR){
			try {
					servicio.actualizarTickets_renglones(TR);
				} catch (DataAccessException e) {
					System.out.println(e);
				return new ResponseEntity<>(HttpStatus.CONFLICT);
				}
			
				return new ResponseEntity<>(HttpStatus.CREATED);
				}
}