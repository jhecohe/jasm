package org.jhecohe.servicio;

import java.math.BigDecimal;

import org.jhecohe.dominio.Apu;
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
	@Override
	public Apu agregarApu(Apu apu) {
		if (apu.getValorTotal() == null) {
			apu.setValorTotal(new BigDecimal(0));
		}
		return apuRepositorio.save(apu);
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
