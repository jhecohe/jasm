package org.jhecohe.repositorio;

import java.util.List;

import org.jhecohe.dominio.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActividadRepositorio extends JpaRepository<Actividad, Integer> {

	public List<Actividad> findByApuIdapu(int idapu);
}
