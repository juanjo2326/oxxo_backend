package mx.edu.itlapiedad.DAO;

import java.util.List;

import mx.edu.itlapiedad.models.Tickets_renglones;

public interface Tickets_renglonesDAO {
	List<Tickets_renglones> consultarTickets_renglones();
	
	Tickets_renglones buscarTickets_renglones(int id);
	
	Tickets_renglones insertarTickets_renglones(Tickets_renglones TR);

	void actualizarTickets_renglones(Tickets_renglones TR);
	

}
