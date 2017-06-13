package org.jhecohe.dominio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	@OneToMany(mappedBy = "presupuesto", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<ApuLista> apuLista = new ArrayList<>();
	
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

	public List<ApuLista> getApuLista() {
		return apuLista;
	}

	public void setApuLista(List<ApuLista> apuLista) {
		this.apuLista = apuLista;
	}

//	@Override
//	public String toString() {
//		return "Presupuesto [idpresupuesto=" + idpresupuesto + ", codigo=" + codigo + ", nombre=" + nombre
//				+ ", valorTotal=" + valorTotal + ", apuLista=" + apuLista.size() + "]";
//	}
}
