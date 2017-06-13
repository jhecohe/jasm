package org.jhecohe.servicio;

import java.math.BigDecimal;
import java.util.List;

import org.jhecohe.dominio.ApuLista;
import org.jhecohe.dominio.Presupuesto;
import org.jhecohe.repositorio.ApuListaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApuListaServicioImpl implements ApuListaServicio {

	@Autowired
	ApuListaRepositorio apuListaRepositorio;
	
	@Autowired
	PresupuestoServicio presupuestoServicio;
	
	@Override
	public ApuLista agregarApuLista(ApuLista apuLista) {
		if(apuLista.getValorApu()==null){
			apuLista.setValorApu(apuLista.getApu().getValorTotal().multiply(new BigDecimal(apuLista.getCantidad())));
		}
		Presupuesto presupuesto = apuLista.getPresupuesto();		
		ApuLista apuListaRes = apuListaRepositorio.save(apuLista);
		presupuesto.setValorTotal(sumaApus(apuLista));
		presupuestoServicio.agregarPrespuesto(presupuesto);
		return apuListaRes;
	}
	
	
	@Override
	public ApuLista agregarApuListaPresupuesto(int idpresupuesto){
		ApuLista apuLista = new ApuLista();
		Presupuesto presupuesto = presupuestoServicio.obtenerPresupuestoById(idpresupuesto);
		apuLista.setPresupuesto(presupuesto);
		return apuLista;
	}

	@Override
	public ApuLista modificarApuLista(int idapuLista) {
		return apuListaRepositorio.findOne(idapuLista);
	}

	@Override
	public void borrarApuLista(int idapuLista) {
		restaApus(idapuLista);
		apuListaRepositorio.delete(idapuLista);
	}

	@Override
	public List<ApuLista> listadoApuLista() {
		return apuListaRepositorio.findAll();
	}

	@Override
	public List<ApuLista> listadoApuListaByPresupuesto(int idpresupuesto) {
		return apuListaRepositorio.findByPresupuestoIdpresupuesto(idpresupuesto);
	}
	
	private BigDecimal sumaApus(ApuLista apuLista){
		BigDecimal total = new BigDecimal(0);
		List<ApuLista> apuListas = apuListaRepositorio.findByPresupuestoIdpresupuesto(apuLista.getPresupuesto().getIdpresupuesto()); 
		for (ApuLista actividad2 : apuListas) {
			total = total.add(actividad2.getValorApu());
		}
		return total;
	}
	
	private void restaApus(int idapuLista){
		BigDecimal total = new BigDecimal(0);
		ApuLista apuLista = apuListaRepositorio.findOne(idapuLista);
		total = apuLista.getPresupuesto().getValorTotal();
		total = total.subtract(apuLista.getValorApu());
		Presupuesto presupuesto = apuLista.getPresupuesto();
		presupuesto.setValorTotal(total);
		presupuestoServicio.agregarPrespuesto(presupuesto);
	}
}
