package mx.edu.itlapiedad.services;

import java.util.List;

import mx.edu.itlapiedad.models.TicketReng;

public interface TicketRengService {

	TicketReng buscar(int id);

	TicketReng insertar(TicketReng TicketReng);

	List<TicketReng> consultarTicketReng();

	void actualizar(TicketReng TicketReng);

	void eliminar(int id);

	

}