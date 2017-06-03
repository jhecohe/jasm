package org.jhecohe.servicio;

import org.jhecohe.dominio.Usuario;

public interface UsuarioServicio {

	public Usuario findUsuarioByEmail(String email);
	public void saveUsuario(Usuario usuario);
}
