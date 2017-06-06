package org.jhecohe.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipoActividad")
public class TipoActividad {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idtipoActividad;
	private String nombre;
	private String descripcion;
	
	public TipoActividad() {
	}
	public int getIdtipoActividad() {
		return idtipoActividad;
	}
	public void setIdtipoActividad(int idtipoActividad) {
		this.idtipoActividad = idtipoActividad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "TipoActividad [idtipoActividad=" + idtipoActividad + ", nombre=" + nombre + ", descripcion="
				+ descripcion + "]";
	}
}
