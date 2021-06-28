package com.poligran.bancoxyz.aplicacion;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poligran.bancoxyz.persistence.RepositorioCuentas;

@Service
public class ServicioCuentas {
	
	@Autowired
	private RepositorioCuentas repositorioCuentas;
	
	/**
	 * consulta la informacion de una cuenta y su cliente asociado
	 * @param idCuenta
	 * @return
	 */
	public Map<String, Object> consultarInformacionCuenta(int idCuenta) {
		return repositorioCuentas.consultarCuentaCliente(idCuenta);
	}

}
