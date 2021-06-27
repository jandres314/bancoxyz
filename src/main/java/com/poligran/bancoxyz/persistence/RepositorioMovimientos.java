package com.poligran.bancoxyz.persistence;

import org.springframework.stereotype.Repository;

import com.poligran.bancoxyz.dominio.ModelMovimiento;

@Repository
public class RepositorioMovimientos extends BaseRepositorio {

	public int registrarMovimiento(ModelMovimiento model) {
		String sql = "";
		return super.update(sql, model.getIdCuenta(), model.getIdOperacion(), model.getMonto());
	}

}
