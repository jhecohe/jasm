package org.jhecohe.servicio;

import org.jhecohe.dominio.TipoActividad;
import org.jhecohe.repositorio.TipoActividadRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoActividadServicioImpl implements TipoActividadServicio{

	@Autowired
	TipoActividadRepositorio tipoActividadRepositorio;
	
	@Override
	public TipoActividad agregarTipoActividad(TipoActividad tipoActividad) {
		return tipoActividadRepositorio.save(tipoActividad);
	}

	@Override
	public TipoActividad modificarTipoActividad(int idtipoActividad) {
		return tipoActividadRepositorio.findOne(idtipoActividad);
	}

	@Override
	public void borrarTipoActividad(int idtipoActividad) {
		tipoActividadRepositorio.delete(idtipoActividad);
	}

	@Override
	public Iterable<TipoActividad> listadoTipoActividad() {
		return tipoActividadRepositorio.findAll();
	}

}
