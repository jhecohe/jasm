package org.jhecohe.controlador;

import javax.validation.Valid;

import org.jhecohe.dominio.Actividad;
import org.jhecohe.servicio.ActividadServicio;
import org.jhecohe.servicio.EstadoCompraServicio;
import org.jhecohe.servicio.SuministroServicio;
import org.jhecohe.servicio.TipoActividadServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/admin/actividad")
public class ActividadControlador {

	@Autowired
	ActividadServicio actividadServicio;
	
	@Autowired
	SuministroServicio suministroServicio;
	
	@Autowired
	TipoActividadServicio tipoActividadServicio;
	
	@Autowired
	EstadoCompraServicio estadoCompraServicio;
	
	@RequestMapping(value="/crear", method=RequestMethod.GET)
	public String crearActividad(Model model){
		model.addAttribute("actividad", new Actividad());
		model.addAttribute("suministroList", suministroServicio.listadoSuministtro());
		model.addAttribute("tipoActividadList", tipoActividadServicio.listadoTipoActividad());
		model.addAttribute("estadoCompraList", estadoCompraServicio.listadoEstadoCompra());
		return "/admin/actividad/actividadForm";
	}
	
	@RequestMapping(value="/crearActividadApu/{idapu}", method=RequestMethod.GET)
	public String crearActividadApu(@PathVariable int idapu, Model model){
		model.addAttribute("actividad", actividadServicio.agregarApu(idapu));
		model.addAttribute("suministroList", suministroServicio.listadoSuministtro());
		model.addAttribute("tipoActividadList", tipoActividadServicio.listadoTipoActividad());
		model.addAttribute("estadoCompraList", estadoCompraServicio.listadoEstadoCompra());
		return "/admin/actividad/actividadForm";
	}
	
	@RequestMapping(value="/agregar", method=RequestMethod.POST)
	public String agregarActividad(@Valid Actividad actividad, Model model){
		model.addAttribute("actividad", actividadServicio.agregarActividad(actividad));
		return "redirect:/admin/apu";
	}
	
	@RequestMapping(value="/modificar/{idactividad}")
	public String modificarActividad(@PathVariable int idactividad, Model model){
		model.addAttribute("actividad", actividadServicio.modificar(idactividad));
		return "/admin/actividad/actividadForm";
	}
	
	@RequestMapping(value="/borrar/{idactividad}")
	public String borrarActividad(@PathVariable int idactividad){
		actividadServicio.borrar(idactividad);
		return "redirect:/admin/apu";
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String listadoActividades(Model model){
		model.addAttribute("actividad", actividadServicio.listadoActividad());
		return "/admin/actividad/actividad";
	}
}
