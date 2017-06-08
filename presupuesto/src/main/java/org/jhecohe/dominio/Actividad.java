package org.jhecohe.dominio;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="actividad")
public class Actividad {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idactividad;
	private BigDecimal valorActividad;
	private BigDecimal rendimiento;
	
	@ManyToOne
	@JoinColumn(name="idsuministro")
	private Suministro suministro;
	@ManyToOne
	@JoinColumn(name="idapu")
	private Apu apu;
	@ManyToOne
	@JoinColumn(name="idestadoCompra")
	private EstadoCompra estadoCompra;
	@ManyToOne
	@JoinColumn(name="idtipoActividad")
	private TipoActividad tipoActividad;
	
	public Actividad() {
	}
	
	public int getIdactividad() {
		return idactividad;
	}

	public void setIdactividad(int idactividad) {
		this.idactividad = idactividad;
	}

	public Suministro getSuministro() {
		return suministro;
	}
	public void setSuministro(Suministro suministro) {
		this.suministro = suministro;
	}
	public Apu getApu() {
		return apu;
	}
	public void setApu(Apu apu) {
		this.apu = apu;
	}
	public BigDecimal getValorActividad() {
		return valorActividad;
	}

	public void setValorActividad(BigDecimal valorActividad) {
		this.valorActividad = valorActividad;
	}

	public BigDecimal getRendimiento() {
		return rendimiento;
	}
	public void setRendimiento(BigDecimal rendimiento) {
		this.rendimiento = rendimiento;
	}
	public EstadoCompra getEstadoCompra() {
		return estadoCompra;
	}

	public void setEstadoCompra(EstadoCompra estadoCompra) {
		this.estadoCompra = estadoCompra;
	}

	public TipoActividad getTipoActividad() {
		return tipoActividad;
	}

	public void setTipoActividad(TipoActividad tipoActividad) {
		this.tipoActividad = tipoActividad;
	}

	@Override
	public String toString() {
		return "Actividad [suministro=" + suministro + ", apu=" + apu + ", valorTotal=" + valorActividad + ", rendimiento="
				+ rendimiento + "]";
	}
}
