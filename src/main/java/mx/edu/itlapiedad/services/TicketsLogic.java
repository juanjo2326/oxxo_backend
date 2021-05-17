package mx.edu.itlapiedad.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.itlapiedad.dao.TicketsDao;
import mx.edu.itlapiedad.models.Tickets;

@Service


public class TicketsLogic implements TicketsServices {
	
	@Autowired
	TicketsDao repositorios;
	
	
	@Override
	public Tickets buscar(int id) {
		return repositorios.buscar(id);
	}

	@Override
	public Tickets insertar(Tickets Tickets) {
		return repositorios.insertar(Tickets);
	}

	@Override
	public List<Tickets> consultarTickets() {
		return repositorios.consultarTickets();
	}

	@Override
	public void actualizar(Tickets Tickets) {
		 repositorios.actualizar(Tickets);
		
	}

	@Override
	public void eliminar(int id) {
		repositorios.eliminar(id);
		
	}

}


