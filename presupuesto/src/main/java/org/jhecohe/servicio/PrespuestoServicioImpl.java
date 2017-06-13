package org.jhecohe.servicio;

import org.jhecohe.dominio.Presupuesto;
import org.jhecohe.repositorio.PresupuestoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrespuestoServicioImpl implements PresupuestoServicio {

	@Autowired
	PresupuestoRepositorio presupuestoRepositorio;
	
	@Override
	public Presupuesto agregarPrespuesto(Presupuesto presupuesto) {
		Presupuesto presupuestoOri = presupuesto;
		if(presupuesto.getIdpresupuesto() >= 1){
			presupuestoOri = presupuestoRepositorio.findOne(presupuesto.getIdpresupuesto());
			presupuestoOri.setNombre(presupuesto.getNombre());
			presupuestoOri.setCodigo(presupuesto.getCodigo());
		}
		return presupuestoRepositorio.save(presupuestoOri);
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

	@Override
	public Presupuesto obtenerPresupuestoById(int idpresupuesto) {
		return presupuestoRepositorio.findOne(idpresupuesto);
	}
}
