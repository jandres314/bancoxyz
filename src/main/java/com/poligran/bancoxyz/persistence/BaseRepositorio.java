package com.poligran.bancoxyz.persistence;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
class BaseRepositorio {
	
	@Autowired
	protected JdbcTemplate jdbc;
	
	/**
	 * ejecuta una sentencia sql tipo dml 
	 * @param sql
	 * @param args
	 * @return
	 */
	protected int update(String sql, Object... args) {
		return jdbc.update(sql, args);
	}
	
	/**
	 * consulta un registro y retorna un mapa de valores con un unico registro
	 * @param sql
	 * @param args
	 * @return
	 */
	protected Map<String, Object> consultarRegistro(String sql, Object... args) {
		return jdbc.queryForMap(sql, args);
	}

}
