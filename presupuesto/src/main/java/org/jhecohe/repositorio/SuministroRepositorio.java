package org.jhecohe.repositorio;

import org.jhecohe.dominio.Suministro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SuministroRepositorio extends CrudRepository<Suministro, Integer>{

	@Query("SELECT MAX(idsuministro) FROM Suministro")
	Integer idUltimaInsercion();
}
