package org.jhecohe.repositorio;

import org.jhecohe.dominio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{
	
	Usuario findByEmail(String email);
}
