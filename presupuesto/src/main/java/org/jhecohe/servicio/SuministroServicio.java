package org.jhecohe.servicio;

import org.jhecohe.dominio.Suministro;

public interface SuministroServicio {

	Suministro agregarSuministro(Suministro suministro);
	Suministro modificarSuministro(int idsuministro);
	void borrarSuministtro(int idsuministro);
	Iterable<Suministro> listadoSuministtro();
}
