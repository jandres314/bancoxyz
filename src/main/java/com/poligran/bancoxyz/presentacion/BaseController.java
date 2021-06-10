package com.poligran.bancoxyz.presentacion;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.poligran.bancoxyz.dominio.ModelRespuesta;

/**
 * clase base para exponer cualquier servicio web 
 * @author josorio
 *
 */
abstract class BaseController {

	/**
	 * genera objeto de respuesta http de exito
	 * @param data
	 * @param status
	 * @param msg
	 * @return
	 */
	protected ResponseEntity<ModelRespuesta> respuestaExito(Object data, HttpStatus status, String msg) {
		ModelRespuesta rta = new ModelRespuesta();
		rta.setData(data);
		rta.setEstado("exito");
		rta.setMensaje(msg);
		return new ResponseEntity<>(rta, status);
	}
	
	/**
	 * genera objeto de respuesta http de exito
	 * @param mensaje
	 * @param estado
	 * @param status
	 * @return
	 */
	protected ResponseEntity<ModelRespuesta> respuestaError(String mensaje, String estado, HttpStatus status) {
		ModelRespuesta rta = new ModelRespuesta();
		rta.setMensaje(mensaje);
		rta.setEstado(estado);
		return new ResponseEntity<>(rta, status);
	}

}
