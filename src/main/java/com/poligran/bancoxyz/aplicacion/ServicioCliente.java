package com.poligran.bancoxyz.aplicacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poligran.bancoxyz.dominio.ModelCliente;
import com.poligran.bancoxyz.persistence.RepositorioCliente;

/**
 * servicio que orquesta operaciones asociadas a clientes
 * @author josorio
 *
 */
@Service
public class ServicioCliente {

	@Autowired
	private RepositorioCliente repositorio;
	
	/**
	 * completa la creacion de un cliente
	 * @param model
	 * @return
	 */
	public int crearCliente(ModelCliente model) {
		return this.repositorio.insertar(model);
	}
}
