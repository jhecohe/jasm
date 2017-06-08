package org.jhecohe.servicio;

import org.jhecohe.dominio.Apu;

public interface ApuServicio {

	Apu agregarApu(Apu apu);
	Apu modificarApu(int idapu);
	void borrarApu(int idapu);
	Iterable<Apu> listadoApu();
	Apu obtenerApuById(int idapu);
}
