package org.jhecohe.servicio;

import java.util.Arrays;
import java.util.HashSet;

import org.jhecohe.dominio.Role;
import org.jhecohe.dominio.Usuario;
import org.jhecohe.repositorio.RoleRepositorio;
import org.jhecohe.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("usuarioServicio")
public class UsuarioServicioImpl implements UsuarioServicio {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	private RoleRepositorio roleRepositorio;
	
	@Autowired
	private BCryptPasswordEncoder bCrypt;
	
	@Override
	public Usuario findUsuarioByEmail(String email) {
		return usuarioRepositorio.findByEmail(email);
	}

	@Override
	public void saveUsuario(Usuario usuario) {
		usuario.setClave(bCrypt.encode(usuario.getClave()));
		usuario.setEstado(1L);
		Role usuarioRole = roleRepositorio.findByDescripcion("admin");
		usuario.setRole(new HashSet<Role>(Arrays.asList(usuarioRole)));
		usuarioRepositorio.save(usuario);
	}

}
