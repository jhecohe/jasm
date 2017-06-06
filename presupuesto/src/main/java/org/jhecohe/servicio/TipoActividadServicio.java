package org.jhecohe.servicio;

import org.jhecohe.dominio.TipoActividad;

public interface TipoActividadServicio {

	TipoActividad agregarTipoActividad(TipoActividad tipoActividad);
	TipoActividad modificarTipoActividad(int idtipoActividad);
	void borrarTipoActividad(int idtipoActividad);
	Iterable<TipoActividad> listadoTipoActividad();
}
