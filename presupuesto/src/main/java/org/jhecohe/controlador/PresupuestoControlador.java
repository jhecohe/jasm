package org.jhecohe.controlador;

import javax.validation.Valid;

import org.jhecohe.dominio.Presupuesto;
import org.jhecohe.servicio.ApuListaServicio;
import org.jhecohe.servicio.PresupuestoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/admin/presupuesto")
public class PresupuestoControlador {

	@Autowired
	PresupuestoServicio presupuestoServicio;
	
	@Autowired
	ApuListaServicio apuListaServicio;
	
	@RequestMapping(value="/crear")
	public String crearPresupuesto(Model model){
		model.addAttribute("presupuesto", new Presupuesto());
		return "/admin/presupuesto/presupuestoForm";
	}
	
	@RequestMapping(value="/agregar", method=RequestMethod.POST)
	public String agregarPresupuesto(@Valid Presupuesto presupuesto, Model model){
		model.addAttribute("presupuesto", presupuestoServicio.agregarPrespuesto(presupuesto));
		return "redirect:";
	}
	
	@RequestMapping(value="/modificar/{idpresupuesto}")
	public String modificarPresupuesto(@PathVariable int idpresupuesto, Model model){
		model.addAttribute("presupuesto", presupuestoServicio.modificarPresupuesto(idpresupuesto));
		return "/admin/presupuesto/presupuestoForm";
	}
	
	@RequestMapping(value="/borrar/{idpresupuesto}")
	public String borrarPresupuesto(@PathVariable int idpresupuesto){
		presupuestoServicio.borrarPresupuesto(idpresupuesto);
		return "redirect:/admin/presupuesto";
	}
	
	@RequestMapping(value="")
	public String listaPresupuesto(Model model){
		model.addAttribute("presupuesto", presupuestoServicio.listadoPresupuesto());
		return "/admin/presupuesto/presupuesto";
	}
	
	@RequestMapping(value="/detalle/{idpresupuesto}")
	public String listadoPresupuestoApuLista(@PathVariable int idpresupuesto, Model model){
		model.addAttribute("presupuesto", presupuestoServicio.modificarPresupuesto(idpresupuesto));
		model.addAttribute("apuLista", apuListaServicio.listadoApuListaByPresupuesto(idpresupuesto));
		return "/admin/presupuesto/presupuestoVer";
	}
}
