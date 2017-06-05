package org.jhecohe.dominio;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="suministro")
public class Suministro {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idsuministro;
	private int codigo;
	private String nombre;
	private String descripcion;
	private BigDecimal valor;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idunidades")
	private Unidades unidades;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idTipoSuministro")
	private TipoSuministro tipoSuministro;
	
	
	public Suministro() {
	}
	public int getIdsuministro() {
		return idsuministro;
	}
	public void setIdsuministro(int idsuministro) {
		this.idsuministro = idsuministro;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public Unidades getUnidades() {
		return unidades;
	}
	public void setUnidades(Unidades unidades) {
		this.unidades = unidades;
	}
	public TipoSuministro getTipoSuministro() {
		return tipoSuministro;
	}
	public void setTipoSuministro(TipoSuministro tipoSuministro) {
		this.tipoSuministro = tipoSuministro;
	}
	@Override
	public String toString() {
		return "Suministro [idsuministro=" + idsuministro + ", codigo=" + codigo + ", nombre=" + nombre
				+ ", descripcion=" + descripcion + ", valor=" + valor + ", unidades=" + unidades + ", tipoSuministro="
				+ tipoSuministro + "]";
	}
}
