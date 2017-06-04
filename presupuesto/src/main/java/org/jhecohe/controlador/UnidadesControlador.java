package org.jhecohe.controlador;

import javax.validation.Valid;

import org.jhecohe.dominio.Unidades;
import org.jhecohe.servicio.UnidadesServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/admin/unidades")
public class UnidadesControlador {

	@Autowired
	UnidadesServicio unidadesServicio;
	
	@RequestMapping("")
	public String unidadesListado(Model model){
		model.addAttribute("unidades", unidadesServicio.listadoUnidades());
		return "/admin/unidades/unidades";
	}
	
	@RequestMapping(value="/crear")
	public String crearUnidades(Model model){
		model.addAttribute("unidades", new Unidades());
		return "admin/unidades/unidadesForm";
	}
	
	@RequestMapping(value="/agregar")
	public String unidadesAgregar(@Valid Unidades unidades, Model model){
		model.addAttribute("unidades", unidadesServicio.agregarUnidad(unidades));
		return "redirect:";
	} 
	
	@RequestMapping(value="/modificar/{idunidades}")
	public String unidadesModificar(@PathVariable int idunidades, Model model){
		model.addAttribute("unidades", unidadesServicio.unidadesById(idunidades));
		return "admin/unidades/unidadesForm";
	}
	
	@RequestMapping(value = "/borrar/{idunidades}")
	public String unidadesBorrar(@PathVariable int idunidades){
		unidadesServicio.borrarUnidad(idunidades);
		return "redirect:/admin/unidades";
	}
}
