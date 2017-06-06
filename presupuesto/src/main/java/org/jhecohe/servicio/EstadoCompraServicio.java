package org.jhecohe.servicio;

import org.jhecohe.dominio.EstadoCompra;

public interface EstadoCompraServicio {

	EstadoCompra agregarEstadoCompra(EstadoCompra estadoCompra);
	EstadoCompra modificarEstadoCompra(int idestadoCompra);
	void borrarEstadoCompra(int idestadoCompra);
	Iterable<EstadoCompra> listadoEstadoCompra();
}
