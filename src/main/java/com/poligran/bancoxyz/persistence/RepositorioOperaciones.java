package com.poligran.bancoxyz.persistence;

import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class RepositorioOperaciones extends BaseRepositorio {

	public Map<String, Object> consultarOperacion(int idOperacion) {
		String sql = "";
		return super.consultarRegistro(sql, idOperacion);
	}

}
