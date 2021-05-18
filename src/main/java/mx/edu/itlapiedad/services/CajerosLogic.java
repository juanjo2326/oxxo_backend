package mx.edu.itlapiedad.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import mx.edu.itlapiedad.dao.CajerosDao;
import mx.edu.itlapiedad.models.Cajeros;

@Service
public class CajerosLogic implements CajerosService {
	
	@Autowired
	CajerosDao repositorios;
	
	@Override
	public Cajeros buscar(int id) {
		
		return repositorios.buscar(id);
	}

	@Override
	public Cajeros insertar(Cajeros cajeros) {
		
		return repositorios.insertar(cajeros);
	}

	@Override
	public List<Cajeros> consultarCajeros() {
		
		return repositorios.consultarClientes();
	}

	@Override
	public void actualizar(Cajeros cajeros) {
		 repositorios.actualizar(cajeros);
		
	}

	@Override
	public void eliminar(int id) {
		repositorios.eliminar(id);
		
	}
	
}