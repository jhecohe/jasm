package org.jhecohe.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TipoSuministro {

	@Id
	@GeneratedValue
	private int idTipoSuministro;
	@Column
	private String nombre;
	@Column
	private String descripcion;
}
