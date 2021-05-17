package mx.edu.itlapiedad.dao;
import java.util.List;

import mx.edu.itlapiedad.models.TicketReng;

public interface TicketRengDao {

	TicketReng buscar(int id);

	TicketReng insertar(TicketReng ticketReng);

	List<TicketReng> consultarTicketReng();

	void actualizar(TicketReng ticketReng);

	void eliminar(int id);

}