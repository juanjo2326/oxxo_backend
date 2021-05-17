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

import mx.edu.itlapiedad.models.TicketReng;
import mx.edu.itlapiedad.services.TicketRengService;

@RestController
@RequestMapping("/devops/ticket_renglones")

public class TicketRengWS {

	@Autowired
	TicketRengService servicio;

	@GetMapping("/{id}")
	public ResponseEntity<?> buscar(@PathVariable int id) {
		TicketReng resultado;
		try {
			resultado = servicio.buscar(id);
		} catch (DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<TicketReng>(resultado, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> insertar(@RequestBody TicketReng TicketReng) {
		TicketReng resultado;
		try {
			resultado = servicio.insertar(TicketReng);

		} catch (DataAccessException e) {
			System.out.println(e);
			return new ResponseEntity<>(HttpStatus.CONFLICT);
			
		}
		return new ResponseEntity<TicketReng>(resultado, HttpStatus.CREATED);

	}

	@GetMapping()
	public ResponseEntity<?> consultarTicketReng() {
		List<TicketReng> resultado;
		try {
			resultado = servicio.consultarTicketReng();
		} catch (DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<TicketReng>>(resultado, HttpStatus.OK);
	}

	@PutMapping()
	public ResponseEntity<?> actualizar(@RequestBody TicketReng TicketReng) {
		try {
			servicio.actualizar(TicketReng);
		} catch (DataAccessException e) {
			System.out.println(e);
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarProducto(@PathVariable int id) {

		try {
			servicio.eliminar(id);
		} catch (DataAccessException e) {

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		}

		return new ResponseEntity<TicketReng>(HttpStatus.OK);

	}

}

