package org.jhecohe.servicio;

import org.jhecohe.dominio.Presupuesto;

public interface PresupuestoServicio {

	Presupuesto agregarPrespuesto(Presupuesto presupuesto);
	Presupuesto modificarPresupuesto(int idprespupuesto);
	void borrarPresupuesto(int idpresupuesto);
	Iterable<Presupuesto> listadoPresupuesto();
}
