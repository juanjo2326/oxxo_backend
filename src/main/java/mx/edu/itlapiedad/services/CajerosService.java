package mx.edu.itlapiedad.services;

import java.util.List;

import mx.edu.itlapiedad.models.Cajeros;


public interface CajerosService {
	
	List<Cajeros> consultarCajeros();

	Cajeros buscar(int id);

	Cajeros insertar(Cajeros Cajeros);

	void actualizar(Cajeros cajeros);

	void eliminar(int id);

}
