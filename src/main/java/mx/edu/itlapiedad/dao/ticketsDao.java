package mx.edu.itlapiedad.DAO;

import java.util.List;

import mx.edu.itlapiedad.models.tickets;

public interface ticketsDao {

	List<tickets> consultarTickets();
	
	tickets buscar(int id);
	
	tickets insertar(tickets tickets);
	
	void actualizar(tickets tickets);

	void eliminar(int id);
	
}
