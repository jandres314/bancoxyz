package com.poligran.bancoxyz.persistence;

import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class RepositorioOperaciones extends BaseRepositorio {

	/**
	 * consulta la informacion de una operacion
	 * @param idOperacion
	 * @return
	 */
	public Map<String, Object> consultarOperacion(int idOperacion) {
		String sql = "select * from operacion where id = ?";
		return super.consultarRegistro(sql, idOperacion);
	}

}
