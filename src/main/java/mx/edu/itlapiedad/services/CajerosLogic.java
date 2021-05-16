package mx.edu.itlapiedad.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.itlapiedad.dao.CajerosDao;
import mx.edu.itlapiedad.models.Cajeros;

@Service

public class CajerosLogic implements CajerosService {
	
    @Autowired
    CajerosDao repositorio;
	
	@Override
	public List<Cajeros> consultarCajeros() {

		return repositorio.consultarCajeros();
	}

	@Override
	public Cajeros buscar(int id) {
		// TODO Auto-generated method stub
		return repositorio.buscar(id);
	}
	
	@Override
	public Cajeros insertar (Cajeros Cajeros) {
		
		return repositorio.insertar(Cajeros);
	}

}

