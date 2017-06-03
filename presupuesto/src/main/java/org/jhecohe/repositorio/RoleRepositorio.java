package org.jhecohe.repositorio;

import org.jhecohe.dominio.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepositorio extends JpaRepository<Role, Long>{

	Role findByDescripcion(String descripcion);
}
