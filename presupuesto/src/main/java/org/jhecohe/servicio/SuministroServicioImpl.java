package org.jhecohe.servicio;

import org.jhecohe.dominio.Suministro;
import org.jhecohe.repositorio.SuministroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuministroServicioImpl implements SuministroServicio {

	@Autowired
	private SuministroRepositorio suministroRepositorio;
	
	@Override
	public Suministro agregarSuministro(Suministro suministro) {
		if(suministro.getCodigo()== 0){
			String code=""+suministroRepositorio.idUltimaInsercion()+""+suministro.getTipoSuministro().getIdTipoSuministro();
			suministro.setCodigo(Integer.parseInt(code));
		}
		return suministroRepositorio.save(suministro);
	}

	@Override
	public Suministro modificarSuministro(int idsuministro) {
		return suministroRepositorio.findOne(idsuministro);
	}

	@Override
	public void borrarSuministtro(int idsuministro) {
		suministroRepositorio.delete(idsuministro);
	}

	@Override
	public Iterable<Suministro> listadoSuministtro() {
		return suministroRepositorio.findAll();
	}

}
