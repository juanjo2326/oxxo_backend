package mx.edu.itlapiedad.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.itlapiedad.dao.TicketRengDao;
import mx.edu.itlapiedad.models.TicketReng;

@Service
public class TicketRengLogic implements TicketRengService {
	@Autowired
	TicketRengDao repositorio;

	@Override
	public TicketReng buscar(int id) {
		// TODO Auto-generated method stub
		return repositorio.buscar(id);
	}

	@Override
	public TicketReng insertar(TicketReng TicketReng) {
		// TODO Auto-generated method stub
		return repositorio.insertar(TicketReng);
	}

	@Override
	public List<TicketReng> consultarTicketReng() {
		// TODO Auto-generated method stub
		return repositorio.consultarTicketReng();
	}

	@Override
	public void actualizar(TicketReng TicketReng) {
		// TODO Auto-generated method stub
repositorio.actualizar(TicketReng);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		repositorio.eliminar(id);
	}



}