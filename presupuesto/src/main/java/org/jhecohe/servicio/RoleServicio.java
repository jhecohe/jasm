package org.jhecohe.servicio;

import org.jhecohe.dominio.Role;

public interface RoleServicio{

	Role agregarRole(Role Role);
	Role modificarRole(int idRole);
	void borrarRole(int idRole);
	Iterable<Role> listadoRole();
}
