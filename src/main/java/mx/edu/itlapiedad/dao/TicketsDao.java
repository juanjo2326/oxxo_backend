package mx.edu.itlapiedad.dao;
import java.util.List;
import mx.edu.itlapiedad.models.Tickets;

public interface TicketsDao {
	Tickets buscar(int id);

	Tickets insertar(Tickets Tickets);

	List<Tickets> consultarTickets();

	void actualizar(Tickets Tickets);

	void eliminar(int id);
}
