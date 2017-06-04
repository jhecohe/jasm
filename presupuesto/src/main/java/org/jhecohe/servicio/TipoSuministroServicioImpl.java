package org.jhecohe.servicio;

import org.jhecohe.dominio.TipoSuministro;
import org.jhecohe.repositorio.TipoSuministroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoSuministroServicioImpl implements TipoSuministroServicio{

	@Autowired
	TipoSuministroRepositorio tipoSuministroRepositorio;
	
	@Override
	public TipoSuministro agregarTipoSuministro(TipoSuministro tipoSuministro) {
		// TODO Auto-generated method stub
		return tipoSuministroRepositorio.save(tipoSuministro);
	}

	@Override
	public TipoSuministro modificarTipoSuministro(int idTipoSuministro) {
		// TODO Auto-generated method stub
		return tipoSuministroRepositorio.findOne(idTipoSuministro);
	}

	@Override
	public void borrarTipoSuministro(int idtipoSuministro) {
		// TODO Auto-generated method stub
		tipoSuministroRepositorio.delete(idtipoSuministro);
	}

	@Override
	public Iterable<TipoSuministro> listadoTipoSuministro() {
		// TODO Auto-generated method stub
		return tipoSuministroRepositorio.findAll();
	}

}
