package mx.edu.itlapiedad.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import mx.edu.itlapiedad.dao.Tickets_renglonesDao;
import mx.edu.itlapiedad.models.Tickets_renglones;


public class Tickets_renglonesLogic {
	
    @Autowired
Tickets_renglonesDao repositorio;
	

	public List<Tickets_renglones> consultarTickets_renglones() {

		return repositorio.consultarTickets_renglones();
	}

	public Tickets_renglones buscarTickets_renglones(int id) {
		// TODO Auto-generated method stub
		return repositorio.buscarTickets_renglones(id);
	}
	
	
	public Tickets_renglones insertar(Tickets_renglones TR) {
		
		return repositorio.insertarTickets_renglones(TR);
	}
	
	public void actualizarTickets_renglones(Tickets_renglones  TR) {
		
		repositorio.actualizarTickets_renglones(TR);
	}
	

}