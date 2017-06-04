package org.jhecohe.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipoSuministro")
public class TipoSuministro {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idtipoSuministro")
	private int idTipoSuministro;
	@Column(name="nombre")
	private String nombre;
	@Column(name="Descripcion")
	private String descripcion;
	
	
	public TipoSuministro() {
		super();
	}
	public int getIdTipoSuministro() {
		return idTipoSuministro;
	}
	public void setIdTipoSuministro(int idTipoSuministro) {
		this.idTipoSuministro = idTipoSuministro;
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
		return "TipoSuministro [idTipoSuministro=" + idTipoSuministro + ", nombre=" + nombre + ", descripcion="
				+ descripcion + "]";
	}
}
