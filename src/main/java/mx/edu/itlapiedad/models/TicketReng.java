
package mx.edu.itlapiedad.models;

public class TicketReng {
private int id, TICKET_id, PRODUCTO_id,cantidad,activo;
private float precio,importe;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getTICKET_id() {
	return TICKET_id;
}
public void setTICKET_id(int tICKET_id) {
	TICKET_id = tICKET_id;
}
public int getPRODUCTO_id() {
	return PRODUCTO_id;
}
public void setPRODUCTO_id(int pRODUCTO_id) {
	PRODUCTO_id = pRODUCTO_id;
}
public int getCantidad() {
	return cantidad;
}
public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}
public float getPrecio() {
	return precio;
}
public void setPrecio(float precio) {
	this.precio = precio;
}
public float getImporte() {
	return importe;
}
public void setImporte(float importe) {
	this.importe = importe;
}
public int getActivo() {
	return activo;
}
public void setActivo(int activo) {
	this.activo = activo;
}

}