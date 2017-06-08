package org.jhecohe.servicio;

import java.util.List;

import org.jhecohe.dominio.Actividad;

public interface ActividadServicio {

	Actividad agregarActividad(Actividad actividad);
	Actividad modificar(int idactividad);
	void borrar(int idactividad);
	List<Actividad> listadoActividad();
	Actividad agregarApu(int idApu);
	List<Actividad> listadoActividadByApu(int idapu);
}
