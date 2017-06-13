package org.jhecohe.dominio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="apu")
public class Apu{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idapu;
	private String nombre;
	private BigDecimal valorTotal;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idunidades")
	private Unidades unidades;
	
	@OneToMany(mappedBy="apu", cascade = CascadeType.ALL, orphanRemoval=true)
	private List<Actividad> actividad= new ArrayList<>();
	
	@OneToMany(mappedBy="apu", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<ApuLista> apuLista = new ArrayList<>();
	
	public Apu() {
	}
	public int getIdapu() {
		return idapu;
	}
	public void setIdapu(int idapu) {
		this.idapu = idapu;
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
	public Unidades getUnidades() {
		return unidades;
	}
	public void setUnidades(Unidades unidades) {
		this.unidades = unidades;
	}
	public List<Actividad> getActividad() {
		return actividad;
	}
	public void setActividad(List<Actividad> actividad) {
		this.actividad = actividad;
	}
	@Override
	public String toString() {
		return "Apu [idapu=" + idapu + ", nombre=" + nombre + ", valor=" + valorTotal + ", unidades=" + unidades + "]";
	}
}
