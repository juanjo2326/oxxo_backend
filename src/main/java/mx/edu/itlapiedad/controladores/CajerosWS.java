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

import mx.edu.itlapiedad.models.Cajeros;
import mx.edu.itlapiedad.services.CajerosService;


@RestController
@RequestMapping("/devops/cajeros")
public class CajerosWS {

	@Autowired
	CajerosService servicio;
	
	@GetMapping()
	public ResponseEntity<?> consultarCajeros(){
		List<Cajeros> resultado;
		try {
			resultado = servicio.consultarCajeros();
		}catch (DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Cajeros>>(resultado,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	
	public ResponseEntity<?> buscar(@PathVariable int id){
		Cajeros resultado;
		try {
			resultado=servicio.buscar(id);
		} catch (DataAccessException e) {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Cajeros>(resultado,HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<?>insertar(@RequestBody Cajeros cajeros){
		Cajeros resultado;
	try {
		resultado=servicio.insertar(cajeros);
		
	} catch (DataAccessException e) {
		System.out.println(e);
	return new ResponseEntity<>(HttpStatus.CONFLICT);
	}	
		return new ResponseEntity<Cajeros>(resultado,HttpStatus.CREATED);
		
	}
	
	@PutMapping()
	public ResponseEntity<?> actualizar(@RequestBody Cajeros cajeros){
		try {
			servicio.actualizar(cajeros);
		} catch (DataAccessException e) {
			System.out.println(e);
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?>eliminarCajero(@PathVariable int id){
		

		try {
			servicio.eliminar(id);
		}catch(DataAccessException e) {
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		}
		
		return new ResponseEntity<Cajeros>(HttpStatus.OK);
		
	}
	
	
}
