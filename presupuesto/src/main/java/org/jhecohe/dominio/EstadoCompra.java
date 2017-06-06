package org.jhecohe.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="estadoCompra")
public class EstadoCompra {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idestadoCompra;
	private String nombre;
	
	public EstadoCompra() {
	}
	public int getIdestadoCompra() {
		return idestadoCompra;
	}
	public void setIdestadoCompra(int idestadoCompra) {
		this.idestadoCompra = idestadoCompra;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "EstadoCompra [idestadoCompra=" + idestadoCompra + ", nombre=" + nombre + "]";
	}
}
