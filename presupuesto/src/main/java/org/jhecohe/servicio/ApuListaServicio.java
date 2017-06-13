package org.jhecohe.servicio;

import java.util.List;

import org.jhecohe.dominio.ApuLista;

public interface ApuListaServicio {

	ApuLista agregarApuLista(ApuLista apuLista);
	ApuLista modificarApuLista(int idapuLista);
	void borrarApuLista(int idapuLista);
	List<ApuLista> listadoApuLista();
	List<ApuLista> listadoApuListaByPresupuesto(int idpresupuesto);
	ApuLista agregarApuListaPresupuesto(int idpresupuesto);
}
