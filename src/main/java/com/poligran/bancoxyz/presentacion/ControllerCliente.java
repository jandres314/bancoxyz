package com.poligran.bancoxyz.presentacion;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
public class ControllerCliente {

	@PostMapping("insertar")
	public ResponseEntity<Object> guardarTraza(@RequestBody String json) {
		Gson gson = new Gson();
//		TrazabilidadModel trazabilidad = gson.fromJson(parametrosTraza, TrazabilidadModel.class);
//		trazabilidad = insercionRegistroUseCase.insertarRegistro(trazabilidad);
//		return super.respuestaExito(trazabilidad.getId(), HttpStatus.CREATED);
		return null;
	}
}
