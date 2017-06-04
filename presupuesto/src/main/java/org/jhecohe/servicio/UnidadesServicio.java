package org.jhecohe.servicio;

import org.jhecohe.dominio.Unidades;

public interface UnidadesServicio {
	
	Unidades agregarUnidad(Unidades unidades);
	Iterable<Unidades> listadoUnidades();
	void borrarUnidad(int idunidad);
	Unidades unidadesById(int idunidades);
}
