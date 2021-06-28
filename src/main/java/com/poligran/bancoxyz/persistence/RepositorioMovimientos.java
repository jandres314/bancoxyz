package com.poligran.bancoxyz.persistence;

import org.springframework.stereotype.Repository;

import com.poligran.bancoxyz.dominio.ModelMovimiento;

@Repository
public class RepositorioMovimientos extends BaseRepositorio {

	/**
	 * persiste un movimiento en la tabla de movimientos
	 * @param model
	 * @return
	 */
	public int registrarMovimiento(ModelMovimiento model) {
		String sql = "insert into movimientos (id_cuenta, monto, estado, operacion) values (?, ?, ?, ?)";
		return super.update(sql, model.getIdCuenta(), model.getMonto() ,model.isEstado(), model.getIdOperacion());
	}

}
