package mx.edu.itlapiedad.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	public ResponseEntity<?>insertar(@RequestBody Cajeros Cajeros){
		Cajeros resultado;
	try {
		resultado=servicio.insertar(Cajeros);
		
	} catch (DataAccessException e) {
	return new ResponseEntity<>(HttpStatus.CONFLICT);
	}	
		return new ResponseEntity<Cajeros>(resultado,HttpStatus.CREATED);
		
	}
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
}

