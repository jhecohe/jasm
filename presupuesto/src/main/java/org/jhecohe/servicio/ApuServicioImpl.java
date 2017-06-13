package org.jhecohe.servicio;

import org.jhecohe.dominio.Apu;
import org.jhecohe.dominio.Unidades;
import org.jhecohe.repositorio.ApuRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApuServicioImpl implements ApuServicio {

	@Override
	public Apu obtenerApuById(int idapu) {
		return apuRepositorio.findOne(idapu);
	}

	@Autowired
	ApuRepositorio apuRepositorio;
	
	@Autowired
	UnidadesServicio unidadServicio;
	
	@Override
	public Apu agregarApu(Apu apu) {
		Apu apuOri = apu;
		if (apu.getIdapu() >= 1) {
			apuOri = apuRepositorio.findOne(apu.getIdapu());
			apuOri.setNombre(apu.getNombre());
//			Unidades unidad = unidadServicio.unidadesById(apu.getUnidades().getIdunidades());
			apuOri.setUnidades(apu.getUnidades());
		}
		return apuRepositorio.save(apuOri);
	}

	@Override
	public Apu modificarApu(int idapu) {
		return apuRepositorio.findOne(idapu);
	}

	@Override
	public void borrarApu(int idapu) {
		apuRepositorio.delete(idapu);

	}

	@Override
	public Iterable<Apu> listadoApu() {
		return apuRepositorio.findAll();
	}

}
