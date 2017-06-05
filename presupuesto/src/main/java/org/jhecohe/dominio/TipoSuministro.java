package org.jhecohe.dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	@OneToMany(mappedBy="tipoSuministro", cascade=CascadeType.ALL)
	private List<Suministro> suministros = new ArrayList<>();
	
	public TipoSuministro() {
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
	public List<Suministro> getSuministros() {
		return suministros;
	}
	public void setSuministros(List<Suministro> suministros) {
		this.suministros = suministros;
	}
	@Override
	public String toString() {
		return "TipoSuministro [idTipoSuministro=" + idTipoSuministro + ", nombre=" + nombre + ", descripcion="
				+ descripcion + "]";
	}
}
