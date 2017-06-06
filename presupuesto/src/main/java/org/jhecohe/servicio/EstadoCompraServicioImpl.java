package org.jhecohe.servicio;

import org.jhecohe.dominio.EstadoCompra;
import org.jhecohe.repositorio.EstadoCompraRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoCompraServicioImpl implements EstadoCompraServicio {

	@Autowired
	EstadoCompraRepositorio estadoCompraRepositorio;
	
	@Override
	public EstadoCompra agregarEstadoCompra(EstadoCompra estadoCompra) {
		return estadoCompraRepositorio.save(estadoCompra);
	}

	@Override
	public EstadoCompra modificarEstadoCompra(int idestadoCompra) {
		return estadoCompraRepositorio.findOne(idestadoCompra);
	}

	@Override
	public void borrarEstadoCompra(int idestadoCompra) {
		estadoCompraRepositorio.delete(idestadoCompra);

	}

	@Override
	public Iterable<EstadoCompra> listadoEstadoCompra() {
		return estadoCompraRepositorio.findAll();
	}

}
