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
import com.google.gson.GsonBuilder;
import com.poligran.bancoxyz.aplicacion.ServicioCliente;
import com.poligran.bancoxyz.dominio.ModelCliente;
import com.poligran.bancoxyz.dominio.ModelRespuesta;

@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
public class ControllerCliente extends BaseController {

	private final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

	@Autowired
	private ServicioCliente servicioCliente;

	@PostMapping("insertar")
	public ResponseEntity<ModelRespuesta> guardarTraza(@RequestBody String json) {
		ModelCliente cliente = gson.fromJson(json, ModelCliente.class);
		int registrosInsertados = servicioCliente.crearCliente(cliente);
		return super.respuestaExito(registrosInsertados, HttpStatus.CREATED, "cliente creado");
	}

}
