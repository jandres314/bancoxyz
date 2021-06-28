package com.poligran.bancoxyz.aplicacion;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poligran.bancoxyz.dominio.ModelMovimiento;
import com.poligran.bancoxyz.persistence.RepositorioCuentas;
import com.poligran.bancoxyz.persistence.RepositorioMovimientos;
import com.poligran.bancoxyz.persistence.RepositorioOperaciones;

@Service
public class ServicioMovimientos {
	
	@Autowired
	private RepositorioCuentas repositorioCuentas;
	
	@Autowired
	private RepositorioMovimientos repositorioMovimientos;
	
	@Autowired
	private RepositorioOperaciones repositorioOperaciones;
	
	@Autowired
	private AdapterMap adapterMap;
	
	public int registrarMovimiento(ModelMovimiento movimiento) {
		String operacion = this.obtenerOperacion(movimiento.getIdOperacion());
		int saldo = this.obtenerSaldoCuenta(movimiento.getIdCuenta());
		this.validarMovimiento(movimiento.getMonto(), operacion, saldo);
		int saldoTotal = this.obtenerSaldoTotal(operacion, saldo, movimiento.getMonto());
		this.validarSaldoTotal(saldoTotal);
		this.repositorioCuentas.actualizarSaldo(movimiento.getIdCuenta(), saldoTotal);
		this.repositorioMovimientos.registrarMovimiento(movimiento);
		return saldoTotal;
	}
	
	private String obtenerOperacion(int idOperacion) {
		Map<String, Object> values = this.repositorioOperaciones.consultarOperacion(idOperacion);
		return adapterMap.obtenerString("nombre", values);
	}
	
	private int obtenerSaldoCuenta(int idCuenta) {
		Map<String, Object>  values = this.repositorioCuentas.consultarCuenta(idCuenta);
		return this.adapterMap.obtenerEntero("saldo", values);
	}
	
	private void validarMovimiento(int monto, String operacion, int saldoCuenta) {
		
		if(monto < 0) {
			throw new IllegalArgumentException("el monto en una transaccion no puede ser negaitvo");
		}
		
		int resultado = saldoCuenta - monto;
		if(operacion.equals("retiro") && resultado < 0) {
			throw new IllegalArgumentException(String.format("transaccion invalida, el saldo de la cuenta no puede ser negativo: %s", resultado));
		}
		
	}
	
	private void validarSaldoTotal(int saldoTotal) {
		if(saldoTotal < 0) {
			throw new IllegalArgumentException(String.format("el saldo total no puede ser negativo: %s", saldoTotal));
		}
	}
	
	private int obtenerSaldoTotal(String operacion, int saldoCuenta, int valorTransaccion) {
		int saldo = 0;
		if(operacion.equals("retiro")) {
			saldo = saldoCuenta - valorTransaccion;
		} else if(operacion.equals("consignacion")) {
			saldo = saldoCuenta + valorTransaccion;
		}
		return saldo;
	}

}
