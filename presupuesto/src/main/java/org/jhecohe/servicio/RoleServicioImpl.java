package org.jhecohe.servicio;

import org.jhecohe.dominio.Role;
import org.jhecohe.repositorio.RoleRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleServicioImpl implements RoleServicio {

	@Autowired
	RoleRepositorio RoleRepositorio;
	
	@Override
	public Role agregarRole(Role Role) {
		return RoleRepositorio.save(Role);
	}

	@Override
	public Role modificarRole(int idRole) {
		return RoleRepositorio.findOne(idRole);
	}

	@Override
	public void borrarRole(int idRole) {
		RoleRepositorio.delete(idRole);
	}

	@Override
	public Iterable<Role> listadoRole() {
		return RoleRepositorio.findAll();
	}

}
