package org.jhecohe.servicio;

import org.jhecohe.dominio.Unidades;
import org.jhecohe.repositorio.UnidadesRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnidadesServicioImpl implements UnidadesServicio {

	@Autowired
	UnidadesRepositorio unidadesRespositorio;
	
	@Override
	public Unidades agregarUnidad(Unidades unidades) {
		return unidadesRespositorio.save(unidades);
	}

	@Override
	public Iterable<Unidades> listadoUnidades() {
		return unidadesRespositorio.findAll();
	}

	@Override
	public void borrarUnidad(int idunidad) {
		unidadesRespositorio.delete(idunidad);
	}

	@Override
	public Unidades unidadesById(int idunidades) {
		return unidadesRespositorio.findOne(idunidades);
	}

}
