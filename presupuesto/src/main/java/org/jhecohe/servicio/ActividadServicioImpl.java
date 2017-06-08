package org.jhecohe.servicio;

import java.math.BigDecimal;
import java.util.List;

import org.jhecohe.dominio.Actividad;
import org.jhecohe.dominio.Apu;
import org.jhecohe.repositorio.ActividadRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActividadServicioImpl implements ActividadServicio {

	@Autowired
	ActividadRepositorio actividadRepositorio;
	@Autowired
	ApuServicio apuServicio;
	
	@Override
	public Actividad agregarApu(int idapu) {
		Actividad actividad = new Actividad();
		Apu apu = apuServicio.obtenerApuById(idapu);
		actividad.setApu(apu);
		return actividad;
	}
	
	@Override
	public Actividad agregarActividad(Actividad actividad) {
		System.out.println(actividad.toString());
		Apu apu = actividad.getApu();
		actividad.setValorActividad((actividad.getSuministro().getValor().multiply(actividad.getRendimiento())));
//				multiply(new BigDecimal(actividad.getRendimiento()))));
		
		apu.setValorTotal(sumaActividades(actividad));
		apuServicio.agregarApu(apu);
		return actividadRepositorio.save(actividad);
	}

	@Override
	public Actividad modificar(int idactividad) {
		return actividadRepositorio.findOne(idactividad);
	}

	@Override
	public void borrar(int idactividad) {
		restaActividad(idactividad);
		actividadRepositorio.delete(idactividad);
	}

	@Override
	public List<Actividad> listadoActividad() {
		return actividadRepositorio.findAll();
	}
	
	@Override
	public List<Actividad> listadoActividadByApu(int idapu) {
		return actividadRepositorio.findByApuIdapu(idapu);
	}

	public BigDecimal sumaActividades(Actividad actividad){
		BigDecimal total= new BigDecimal(0);	
		List<Actividad> actividades = actividadRepositorio.findByApuIdapu(actividad.getApu().getIdapu());
		for (Actividad actividad2 : actividades) {
			total = total.add(actividad2.getValorActividad());
		}
		total = total.add(actividad.getValorActividad());
		return total;
	}
	
	public BigDecimal restaActividad(int idactividad){
		BigDecimal total= new BigDecimal(0);
		Actividad actividad = actividadRepositorio.findOne(idactividad);
		Apu apu = apuServicio.obtenerApuById(actividad.getApu().getIdapu());
		total = total.add(apu.getValorTotal());
		apu.setValorTotal(total.subtract(actividad.getValorActividad()));
		apuServicio.agregarApu(apu);
		return total;
	}
}
