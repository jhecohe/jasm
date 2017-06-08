package org.jhecohe.dominio;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="presupuesto")
public class Presupuesto {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idpresupuesto;
	private String codigo;
	private String nombre;
	private BigDecimal valorTotal;
	
	public Presupuesto() {
	}

	public int getIdpresupuesto() {
		return idpresupuesto;
	}

	public void setIdpresupuesto(int idpresupuesto) {
		this.idpresupuesto = idpresupuesto;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	@Override
	public String toString() {
		return "Presupuesto [idpresupuesto=" + idpresupuesto + ", codigo=" + codigo + ", nombre=" + nombre
				+ ", valorTotal=" + valorTotal + "]";
	}
}
