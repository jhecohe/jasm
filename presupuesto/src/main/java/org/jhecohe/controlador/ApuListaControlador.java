package org.jhecohe.controlador;

import javax.validation.Valid;

import org.jhecohe.dominio.ApuLista;
import org.jhecohe.servicio.ApuListaServicio;
import org.jhecohe.servicio.ApuServicio;
import org.jhecohe.servicio.PresupuestoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/admin/apuLista")
public class ApuListaControlador {

	@Autowired
	ApuListaServicio apuListaServicio;
	
	@Autowired
	ApuServicio apuServicio;
	
	@Autowired
	PresupuestoServicio presupuestoServicio;
	
	@RequestMapping(value="/crear")
	public String crearApuLista(Model model){
		model.addAttribute("apuLista", new ApuLista());
		model.addAttribute("apuListado", apuServicio.listadoApu());
		return "/admin/apuLista/apulistaForm";
	}
	
	@RequestMapping(value="/crearApuListaPresupuesto/{idpresupuesto}")
	public String crearApuListaPresupuesto(@PathVariable int idpresupuesto, Model model){
		model.addAttribute("apuLista", apuListaServicio.agregarApuListaPresupuesto(idpresupuesto));
		model.addAttribute("apuListado", apuServicio.listadoApu());
		return "/admin/apuLista/apuListaForm";
	}
	
	@RequestMapping(value="/agregar", method=RequestMethod.POST)
	public String agregarApuLista(@Valid ApuLista apuLista, Model model){
		model.addAttribute("apuLista", apuListaServicio.agregarApuLista(apuLista));
		return "redirect:/admin/presupuesto/detalle/"+apuLista.getPresupuesto().getIdpresupuesto();
	}
	
	@RequestMapping(value="/modificar/{idapuLista}")
	public String modificarApuLista(@PathVariable int idapuLista, Model model){
		model.addAttribute("apuLista", apuListaServicio.modificarApuLista(idapuLista));
		model.addAttribute("apuListado", apuServicio.listadoApu());
		return "/admin/apuLista/apuListaForm";
	}
	
	@RequestMapping(value="/borrar/{idapuLista}/{idpresupuesto}")
	public String borrarApuList(@PathVariable int idapuLista, @PathVariable int idpresupuesto){
		apuListaServicio.borrarApuLista(idapuLista);
//		return "redirect:/admin/presupuesto";
		return "redirect:/admin/presupuesto/detalle/"+idpresupuesto;
	}
	
	@RequestMapping(value="")
	public String listadoApuListado(Model model){
		model.addAttribute("apuLista", apuListaServicio.listadoApuLista());
		return "/admin/apuListado/apuListado";
	}
}
