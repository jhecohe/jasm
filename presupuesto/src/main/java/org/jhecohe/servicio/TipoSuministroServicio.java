package org.jhecohe.servicio;

import org.jhecohe.dominio.TipoSuministro;

public interface TipoSuministroServicio {

	TipoSuministro agregarTipoSuministro(TipoSuministro tipoSuministro);
	TipoSuministro modificarTipoSuministro(int idTipoSuministro);
	void borrarTipoSuministro(int idtipoSuministro);
	Iterable<TipoSuministro> listadoTipoSuministro();
}
