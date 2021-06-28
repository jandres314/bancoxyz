package com.poligran.bancoxyz.persistence;

import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class RepositorioCuentas extends BaseRepositorio {

	/**
	 * actualiza el saldo de una cuenta
	 * @param idCuenta
	 * @param valor
	 * @return
	 */
	public int actualizarSaldo(int idCuenta, int valor) {
		String sql = "update cuentas set saldo = ? where id = ?";
		return super.update(sql, valor, idCuenta);
	}

	/**
	 * consulta la informacion de una cuenta
	 * @param idCuenta
	 * @return
	 */
	public Map<String, Object> consultarCuenta(int idCuenta) {
		String sql = "select * from cuentas where id = ?";
		return super.consultarRegistro(sql, idCuenta);
	}

}
