package org.jhecohe.dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "unidades")
public class Unidades {

	@Id
	@GeneratedValue (strategy =GenerationType.AUTO)
	@Column(name="idunidades")
	private int idunidades;
	@Column(name="nombre")
	private String nombre;
	@Column(name="descripcion")
	private String descripcion;
	@OneToMany(mappedBy="unidades", cascade=CascadeType.ALL)
	private List<Suministro> suministros= new ArrayList<>();
	
	public Unidades() {
		super();
	}
	public int getIdunidades() {
		return idunidades;
	}
	public void setIdunidades(int idunidades) {
		this.idunidades = idunidades;
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
		return "Unidades [idunidades=" + idunidades + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	} 
	
}
