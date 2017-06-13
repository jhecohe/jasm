package org.jhecohe.servicio;

import org.jhecohe.dominio.Presupuesto;

public interface PresupuestoServicio {

	Presupuesto agregarPrespuesto(Presupuesto presupuesto);
	Presupuesto modificarPresupuesto(int idpresupuesto);
	void borrarPresupuesto(int idpresupuesto);
	Iterable<Presupuesto> listadoPresupuesto();
	Presupuesto obtenerPresupuestoById(int idpresupuesto);
}
