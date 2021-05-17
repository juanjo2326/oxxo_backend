package mx.edu.itlapiedad.dao;

import java.util.List;

import mx.edu.itlapiedad.models.Tickets;
public interface TicketsDao {
	
	List<Tickets> consultarTickets();
	
	Tickets buscar(int id);
	
	Tickets insertar(Tickets Tickets);
	
	void actualizar(Tickets Tickets);

	void eliminar(int id);
	

}
