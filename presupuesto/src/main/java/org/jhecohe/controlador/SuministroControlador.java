package org.jhecohe.controlador;

import javax.validation.Valid;

import org.jhecohe.dominio.Suministro;
import org.jhecohe.servicio.SuministroServicio;
import org.jhecohe.servicio.TipoSuministroServicio;
import org.jhecohe.servicio.UnidadesServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/admin/suministro")
public class SuministroControlador {

	@Autowired
	SuministroServicio suministroServicio;
	
	@Autowired
	UnidadesServicio unidadesServicio;
	
	@Autowired
	TipoSuministroServicio tipoSuministroServicio;
	
	@RequestMapping(value="/crear", method=RequestMethod.GET)
	public String crearSuministro(Model model){
		model.addAttribute("unidadlist", unidadesServicio.listadoUnidades());
		model.addAttribute("tipoSuministroList", tipoSuministroServicio.listadoTipoSuministro());
		model.addAttribute("suministro", new Suministro());
		return "/admin/suministro/suministroForm";
	}
	
	@RequestMapping(value="/agregar", method=RequestMethod.POST)
	public String agregarSuministro(@Valid Suministro suministro, Model model){
		model.addAttribute("suministro", suministroServicio.agregarSuministro(suministro));
		
		return "redirect:";
	}
	
	@RequestMapping(value="/modificar/{idsuministro}", method=RequestMethod.GET)
	public String modificarSuministro(@PathVariable int idsuministro, Model model){
		model.addAttribute("unidadlist", unidadesServicio.listadoUnidades());
		model.addAttribute("tipoSuministroList", tipoSuministroServicio.listadoTipoSuministro());
		model.addAttribute("suministro", suministroServicio.modificarSuministro(idsuministro));
		return "/admin/suministro/suministroForm";
	}
	
	@RequestMapping(value="/borrar/{idsuministro}", method=RequestMethod.GET)
	public String borrarSuministro(@PathVariable int idsuministro){
		suministroServicio.borrarSuministtro(idsuministro);
		return "redirect:/admin/suministro";
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String listadoSuministro(Model model){
		model.addAttribute("suministro", suministroServicio.listadoSuministtro());
		return "/admin/suministro/suministro";
	}
}
