package mx.edu.itlapiedad.services;
import java.util.List;

import mx.edu.itlapiedad.models.Tickets;

public interface TicketsServices {
	
	List<Tickets> consultarTickets();
	Tickets buscar(int id);
	Tickets insertar (Tickets Tickets);
	void actualizar(Tickets Tickets);

	void eliminar(int id);
	}
