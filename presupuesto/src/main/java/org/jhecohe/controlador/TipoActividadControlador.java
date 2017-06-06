package org.jhecohe.controlador;

import javax.validation.Valid;

import org.jhecohe.dominio.TipoActividad;
import org.jhecohe.dominio.TipoSuministro;
import org.jhecohe.servicio.TipoActividadServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/admin/tipoActividad")
public class TipoActividadControlador {

	@Autowired
	TipoActividadServicio tipoActividadServicio;
	
	@RequestMapping(value="/crear", method=RequestMethod.GET)
	public String crearTipoActividad(Model model){
		model.addAttribute("tipoActividad", new TipoActividad());
		return "/admin/tipoActividad/tipoActividadForm";
	}
	
	@RequestMapping(value="/agregar", method=RequestMethod.POST)
	public String agregarTipoActividad(@Valid TipoActividad tipoActividad, Model model){
		model.addAttribute("tipoActividad", tipoActividadServicio.agregarTipoActividad(tipoActividad));
		return "redirect:";
	}
	
	@RequestMapping(value="/modificar/{idTipoActividad}", method=RequestMethod.GET)
	public String modificarTipoActividad(@PathVariable int idTipoActividad, Model model){
		model.addAttribute("tipoActividad", tipoActividadServicio.modificarTipoActividad(idTipoActividad));
		return "/admin/tipoActividad/tipoActividadForm";
	}
	
	@RequestMapping(value="/borrar/{idTipoActividad}", method=RequestMethod.GET)
	public String borrarTipoActividad(@PathVariable int idTipoActividad){
		tipoActividadServicio.borrarTipoActividad(idTipoActividad);
		return "redirect:/admin/tipoActividad";
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String listadoTipoActividad(Model model){
		model.addAttribute("tipoActividad", tipoActividadServicio.listadoTipoActividad());
		return "/admin/tipoActividad/tipoActividad";
	}
}
