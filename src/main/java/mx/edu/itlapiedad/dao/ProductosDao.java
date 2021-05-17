package mx.edu.itlapiedad.dao;



import java.util.List;

import mx.edu.itlapiedad.models.Productos;

public interface ProductosDao {

	Productos buscar(int id);

	Productos insertar(Productos productos);

	List<Productos> consultarProductos();
	
	void actualizar(Productos productos);

	void eliminar(int id);

}