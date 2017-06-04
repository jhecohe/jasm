package org.jhecohe.controlador;

import javax.validation.Valid;

import org.jhecohe.dominio.TipoSuministro;
import org.jhecohe.servicio.TipoSuministroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/admin/tipoSuministro")
public class TipoSuministroControlador {

	@Autowired
	TipoSuministroServicio tipoSuministroServicio;
	
	@RequestMapping(value="/crear", method=RequestMethod.GET)
	public String crearTipoSuministro(Model model){
		model.addAttribute("tipoSuministro", new TipoSuministro());
		return "/admin/tipoSuministro/tipoSuministroForm";
	}
	
	@RequestMapping(value="/agregar", method=RequestMethod.POST)
	public String agregarTipoSuministro(@Valid TipoSuministro tipoSuministro, Model model){
		model.addAttribute("tipoSuministro", tipoSuministroServicio.agregarTipoSuministro(tipoSuministro));
		return "redirect:";
	}
	
	@RequestMapping(value="/modificar/{idTipoSuministro}", method=RequestMethod.GET)
	public String modificarTipoSuministro(@PathVariable int idTipoSuministro, Model model){
		model.addAttribute("tipoSuministro", tipoSuministroServicio.modificarTipoSuministro(idTipoSuministro));
		return "/admin/tipoSuministro/tipoSuministroForm";
	}
	
	@RequestMapping(value="/borrar/{idTipoSuministro}", method=RequestMethod.GET)
	public String borrarTipoSuministro(@PathVariable int idTipoSuministro){
		tipoSuministroServicio.borrarTipoSuministro(idTipoSuministro);
		return "redirect:/admin/tipoSuministro";
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String listadoTipoSuministro(Model model){
		model.addAttribute("tipoSuministro", tipoSuministroServicio.listadoTipoSuministro());
		return "/admin/tipoSuministro/tipoSuministro";
	}
}
