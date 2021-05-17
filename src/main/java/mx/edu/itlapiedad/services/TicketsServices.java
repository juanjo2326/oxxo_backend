package mx.edu.itlapiedad.services;
import java.util.List;

import mx.edu.itlapiedad.models.Tickets;

public interface TicketsServices {
	
	


		Tickets buscar(int id);

		Tickets insertar(Tickets Tickets);

		List<Tickets> consultarTickets();

		void actualizar(Tickets Tickets);

		void eliminar(int id);

	
}
