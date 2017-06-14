package org.jhecohe.controlador;

import javax.validation.Valid;

import org.jhecohe.dominio.Usuario;
import org.jhecohe.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class loginControlador {

	@Autowired
	private UsuarioServicio usuarioServicio;
	
	@RequestMapping(value={"/","/login"}, method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView modelAV = new ModelAndView();
		modelAV.setViewName("/login");
		return modelAV;
	}
	
	@RequestMapping(value="/registro", method=RequestMethod.GET)
	public ModelAndView registro(){
		ModelAndView modelAV = new ModelAndView();
		Usuario usuario = new Usuario();
		
		modelAV.addObject("usuario",usuario);
		modelAV.setViewName("registro");
		return modelAV;
	}
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String iniciar(){
		return "index";
	}
	
	@RequestMapping(value = "/registro", method=RequestMethod.POST)
	public ModelAndView nuevoUsuario(@Valid Usuario usuario, BindingResult bindingResult){
		ModelAndView modelAV = new ModelAndView();
		Usuario existeUsuario= usuarioServicio.findUsuarioByEmail(usuario.getEmail());
		if (existeUsuario != null) {
			bindingResult
				.rejectValue("email", "error.usuario",
						"Ya hay un usuario registrado con ese Email");
		}
		if (bindingResult.hasErrors()) {
			modelAV.setViewName("registro");
		}else{
			usuarioServicio.saveUsuario(usuario);
			modelAV.addObject("succesMessage", "El usuario ha sido registrado");
			modelAV.addObject("usuario", new Usuario());
			modelAV.setViewName("registro");
		}
		return modelAV;
	}
	
//	@RequestMapping(value="/admin/seguridad/usuarioForm", method=RequestMethod.GET)
//	public ModelAndView home(){
//		ModelAndView modelAV = new ModelAndView();
//		Authentication auth= SecurityContextHolder.getContext().getAuthentication();
//		Usuario usuario = usuarioServicio.findUsuarioByEmail(auth.getName());
//		modelAV.addObject("nombre", "Bienvenido -" + usuario.getNombre()+" "+ usuario.getApellido() + " (" + usuario.getEmail() + ")");
//		modelAV.addObject("adminMessage","Contenido solo accesible solo por usuario administradores");
//		modelAV.setViewName("/admin/seguridad/usuarioForm");
//		return modelAV;
//	}
}
