package mx.edu.itlapiedad.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import mx.edu.itlapiedad.models.Tickets;
import mx.edu.itlapiedad.services.TicketsServices;
//import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/devops/tickets")

public class TicketsWS {
	

	@Autowired
	TicketsServices servicio;

	@GetMapping()
	public ResponseEntity<?> consultarTickets(){
		List<Tickets> resultado;
		try {
			resultado = servicio.consultarTickets();
		}catch (DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Tickets>>(resultado,HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> buscar(@PathVariable int id){
		Tickets resultado;
		try {
			resultado=servicio.buscar(id);
		} catch (DataAccessException e) {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Tickets>(resultado,HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<?>insertar(@RequestBody Tickets Tickets){
		Tickets resultado;
	try {
		resultado=servicio.insertar(Tickets);
		
	} catch (DataAccessException e) {
	return new ResponseEntity<>(HttpStatus.CONFLICT);
	}	
		return new ResponseEntity<Tickets>(resultado,HttpStatus.CREATED);
	
	}
	
	@PutMapping()
	public ResponseEntity<?> actualizar(@RequestBody Tickets Tickets){
		try {
			servicio.actualizar(Tickets);
		} catch (DataAccessException e) {
			System.out.println(e);
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?>eliminarTickets(@PathVariable int id){
		

		try {
			servicio.eliminar(id);
		}catch(DataAccessException e) {
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		}
		
		return new ResponseEntity<Tickets>(HttpStatus.OK);
		
	}
}
