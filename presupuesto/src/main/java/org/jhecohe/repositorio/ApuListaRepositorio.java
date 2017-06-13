package org.jhecohe.repositorio;

import java.util.List;

import org.jhecohe.dominio.ApuLista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApuListaRepositorio extends JpaRepository<ApuLista, Integer>{

	List<ApuLista> findByPresupuestoIdpresupuesto(int idpresupuesto);
}
