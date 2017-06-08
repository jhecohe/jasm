package org.jhecohe.servicio;

import org.jhecohe.dominio.Presupuesto;
import org.jhecohe.repositorio.PresupuestoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

public class PrespuestoServicioImpl implements PresupuestoServicio {

	@Autowired
	PresupuestoRepositorio presupuestoRepositorio;
	
	@Override
	public Presupuesto agregarPrespuesto(Presupuesto presupuesto) {
		return presupuestoRepositorio.save(presupuesto);
	}

	@Override
	public Presupuesto modificarPresupuesto(int idpresupuesto) {
		return presupuestoRepositorio.findOne(idpresupuesto);
	}

	@Override
	public void borrarPresupuesto(int idpresupuesto) {
		presupuestoRepositorio.delete(idpresupuesto);
	}

	@Override
	public Iterable<Presupuesto> listadoPresupuesto() {
		return presupuestoRepositorio.findAll();
	}

}
