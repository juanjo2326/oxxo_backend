package mx.edu.itlapiedad.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.itlapiedad.dao.*;
import mx.edu.itlapiedad.models.Tickets;

@Service
public class TicketsLogic implements TicketsServices{
	@Autowired
	TicketsDao repositorio;
	
	@Override
	public List<Tickets> consultarTickets(){
		return repositorio.consultarTickets();		
	}
	
	@Override
	public Tickets buscar(int id) {
		// TODO Auto-generated method stub
		return repositorio.buscar(id);
	}
	
	@Override
	public Tickets insertar(Tickets Tickets) {
		
		return repositorio.insertar(Tickets);
	}
	
	@Override
	public void actualizar(Tickets Tickets) {
		 repositorio.actualizar(Tickets);
		
	}

	@Override
	public void eliminar(int id) {
		repositorio.eliminar(id);
		
	}
}