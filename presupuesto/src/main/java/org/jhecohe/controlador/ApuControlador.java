package org.jhecohe.controlador;

import javax.validation.Valid;

import org.jhecohe.dominio.Apu;
import org.jhecohe.servicio.ActividadServicio;
import org.jhecohe.servicio.ApuServicio;
import org.jhecohe.servicio.UnidadesServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/admin/apu")
public class ApuControlador {

	@Autowired
	ApuServicio apuServicio;
	
	@Autowired
	UnidadesServicio uniddadesServicio;
	
	@Autowired
	ActividadServicio actividadServicio;
	
	@RequestMapping(value="/crear", method=RequestMethod.GET)
	public String crearApu(Model model){
		model.addAttribute("apu", new Apu());
		model.addAttribute("unidadList", uniddadesServicio.listadoUnidades());
		return "/admin/apu/apuForm";
	}
	
	@RequestMapping(value="/agregar", method=RequestMethod.POST)
	public String agregarApu(@Valid Apu apu, Model model){
		model.addAttribute("apu", apuServicio.agregarApu(apu));
		return "redirect:";
	}
	
	@RequestMapping(value="/modificar/{idapu}", method=RequestMethod.GET)
	public String modificar(@PathVariable int idapu, Model model){
		model.addAttribute("apu", apuServicio.modificarApu(idapu));
		model.addAttribute("unidadList", uniddadesServicio.listadoUnidades());
		return "/admin/apu/apuForm";
	}
	
	@RequestMapping(value="/borrar/{idapu}", method=RequestMethod.GET)
	public String borrarApu(@PathVariable int idapu){
		apuServicio.borrarApu(idapu);
		return "redirect:/admin/apu";
	}
	
	@RequestMapping(value="")
	public String listadoApu(Model model){
		model.addAttribute("apuListado", apuServicio.listadoApu());
		return "/admin/apu/apu";
	}
	
	@RequestMapping(value="/detalle/{idapu}")
	public String listadoApuDetalle(@PathVariable int idapu, Model model){
		model.addAttribute("apuDetalle", apuServicio.obtenerApuById(idapu));
		model.addAttribute("actividadList", actividadServicio.listadoActividadByApu(idapu));
		return "/admin/apu/apuVer";
	}
}
