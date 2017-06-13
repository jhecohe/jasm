package org.jhecohe.dominio;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="apuLista")
public class ApuLista {

	@Id
	@GeneratedValue
	private int idapuLista;
	private int cantidad;
	private BigDecimal valorApu;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idapu")
	private Apu apu;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idpresupuesto")
	private Presupuesto presupuesto;
	
	public ApuLista() {
	}
	public int getIdapuLista() {
		return idapuLista;
	}
	public void setIdapuLista(int idapuLista) {
		this.idapuLista = idapuLista;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public BigDecimal getValorApu() {
		return valorApu;
	}
	public void setValorApu(BigDecimal valorApu) {
		this.valorApu = valorApu;
	}
	public Apu getApu() {
		return apu;
	}
	public void setApu(Apu apu) {
		this.apu = apu;
	}
	public Presupuesto getPresupuesto() {
		return presupuesto;
	}
	public void setPresupuesto(Presupuesto presupuesto) {
		this.presupuesto = presupuesto;
	}
	@Override
	public String toString() {
		return "ApuLista [idapuLista=" + idapuLista + ", cantidad=" + cantidad + ", valorApu=" + valorApu + ", apu="
				+ apu + ", presupuesto=" + presupuesto + "]";
	}	
}
