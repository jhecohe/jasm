package org.jhecohe.controlador;

import javax.validation.Valid;

import org.jhecohe.dominio.Role;
import org.jhecohe.servicio.RoleServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class RoleControlador {

	@Autowired
	RoleServicio roleServicio;
	@RequestMapping(value="/crear", method=RequestMethod.GET)
	public String crearRole(Model model){
		model.addAttribute("Role", new Role());
		return "/admin/Role/RoleForm";
	}
	
	@RequestMapping(value="/agregar", method=RequestMethod.POST)
	public String agregarRole(@Valid Role Role, Model model){
		model.addAttribute("Role", roleServicio.agregarRole(Role));
		return "redirect:";
	}
	
	@RequestMapping(value="/modificar/{idRole}", method=RequestMethod.GET)
	public String modificarRole(@PathVariable int idRole, Model model){
		model.addAttribute("Role", roleServicio.modificarRole(idRole));
		return "/admin/Role/RoleForm";
	}
	
	@RequestMapping(value="/borrar/{idRole}", method=RequestMethod.GET)
	public String borrarRole(@PathVariable int idRole){
		roleServicio.borrarRole(idRole);
		return "redirect:/admin/Role";
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String listadoRole(Model model){
		model.addAttribute("Role", roleServicio.listadoRole());
		return "/admin/Role/Role";
	}
}
