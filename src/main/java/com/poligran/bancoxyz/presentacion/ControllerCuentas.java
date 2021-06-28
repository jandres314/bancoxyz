package com.poligran.bancoxyz.presentacion;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.poligran.bancoxyz.aplicacion.ServicioCuentas;
import com.poligran.bancoxyz.dominio.ModelRespuesta;

@RestController
@RequestMapping("/cuentas")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET })
public class ControllerCuentas extends BaseController {

	@Autowired
	private ServicioCuentas servicioCuentas;

	@GetMapping("{idCuenta}")
	public ResponseEntity<ModelRespuesta> info(@PathVariable String idCuenta) {
		Integer idCuentaInt = Integer.parseInt(idCuenta);
		Map<String, Object> data = servicioCuentas.consultarInformacionCuenta(idCuentaInt);
		return super.respuestaExito(data, HttpStatus.OK, "exito consulta");
	}
	
}
