package com.poligran.bancoxyz.presentacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.poligran.bancoxyz.aplicacion.ServicioMovimientos;
import com.poligran.bancoxyz.dominio.ModelMovimiento;
import com.poligran.bancoxyz.dominio.ModelRespuesta;

@RestController
@RequestMapping("/movimientos")
@CrossOrigin(origins = "*", methods = { RequestMethod.POST })
public class ControllerMovimientos extends BaseController {

	private final Gson gson = new Gson();

	@Autowired
	private ServicioMovimientos servicioMovimientos;

	@PostMapping("insertar")
	public ResponseEntity<ModelRespuesta> guardarMovimiento(@RequestBody String json) {
		ModelMovimiento movimiento = gson.fromJson(json, ModelMovimiento.class);
		int registrosInsertados = servicioMovimientos.registrarMovimiento(movimiento);
		return super.respuestaExito(registrosInsertados, HttpStatus.CREATED, "saldo total cuenta");
	}

}
