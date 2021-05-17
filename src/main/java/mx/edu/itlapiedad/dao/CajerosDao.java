package mx.edu.itlapiedad.dao;



import java.util.List;

import mx.edu.itlapiedad.models.Cajeros;

public interface CajerosDao {
	
	Cajeros buscar(int id);

	Cajeros insertar(Cajeros Cajeros);

	List<Cajeros> consultarCajeros();
	
	void actualizar(Cajeros cajeros);

	void eliminar(int id);

}
