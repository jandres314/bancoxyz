package com.poligran.bancoxyz.presentacion;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.poligran.bancoxyz.dominio.ModelRespuesta;

/**
 * clase para centralizar las excepciones de la aplicacion
 * @author josorio
 *
 */
@ControllerAdvice
public class ControllerExcepciones extends BaseController {

	/**
	 * control de excepciones de negocio
	 * @param e
	 * @return
	 */
	@ExceptionHandler({ IllegalArgumentException.class })
	public ResponseEntity<ModelRespuesta> excepcionNegocio(Exception e) {
		return super.respuestaError(e.getMessage(), "excepcion de negocio", HttpStatus.BAD_REQUEST);
	}

	/**
	 * control excepciones de registros no encontrados en base de datos
	 * @param e
	 * @return
	 */
	@ExceptionHandler({ EmptyResultDataAccessException.class })
	public ResponseEntity<ModelRespuesta> excepcionNotFound(Exception e) {
		return super.respuestaError(e.getMessage(), "no se encontraron resultados, favor verificar identificadores de claves foraneas en la petición", HttpStatus.NOT_FOUND);
	}

	/**
	 * control de excepciones del sistema
	 * @param e
	 * @return
	 */
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<ModelRespuesta> excepcionNoControlada(Exception e) {
		String stackTrace = obtenerStrackTrace(e);
		return super.respuestaError(stackTrace, "error del sistema", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * extrae el stacktrace de una excepcion
	 * @param t
	 * @return
	 */
	private String obtenerStrackTrace(Throwable t) {
		final Writer result = new StringWriter();
		final PrintWriter printWriter = new PrintWriter(result);
		t.printStackTrace(printWriter);
		return result.toString();
	}
}
