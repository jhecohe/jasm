package org.jhecohe.controlador;

import javax.validation.Valid;

import org.jhecohe.dominio.EstadoCompra;
import org.jhecohe.servicio.EstadoCompraServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/admin/estadoCompra")
public class EstadoCompraControlador {

	@Autowired
	EstadoCompraServicio estadoCompraServicio;
	
	@RequestMapping(value="/crear", method=RequestMethod.GET)
	public String crearEstadoCompra(Model model){
		model.addAttribute("estadoCompra", new EstadoCompra());
		return "/admin/estadoCompra/estadoCompraForm";
	}
	
	@RequestMapping(value="/agregar", method=RequestMethod.POST)
	public String agregarTipoSuministro(@Valid EstadoCompra estadoCompra, Model model){
		model.addAttribute("estadoCompra", estadoCompraServicio.agregarEstadoCompra(estadoCompra));
		return "redirect:";
	}
	
	@RequestMapping(value="/modificar/{idestadoCompra}", method=RequestMethod.GET)
	public String modificarEstadoCompra(@PathVariable int idestadoCompra, Model model){
		model.addAttribute("estadoCompra", estadoCompraServicio.modificarEstadoCompra(idestadoCompra));
		return "/admin/estadoCompra/estadoCompraForm";
	}
	
	@RequestMapping(value="/borrar/{idestadoCompra}", method=RequestMethod.GET)
	public String borrarEstadoCompra(@PathVariable int idestadoCompra){
		estadoCompraServicio.borrarEstadoCompra(idestadoCompra);
		return "redirect:/admin/estadoCompra";
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String listadoEstadoCompra(Model model){
		model.addAttribute("estadoCompra", estadoCompraServicio.listadoEstadoCompra());
		return "/admin/estadoCompra/estadoCompra";
	}
}
