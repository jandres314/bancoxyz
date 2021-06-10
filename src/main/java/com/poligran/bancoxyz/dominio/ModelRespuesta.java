/**
 * 
 */
package com.poligran.bancoxyz.dominio;

import java.time.LocalDateTime;

/**
 * clase que representa la estructura estandar de una respuesta http entregada por el servidor 
 * @author josorio
 *
 */
public class ModelRespuesta {

	private String estado;
	private String mensaje;
	private Object data;
	private final LocalDateTime fechaTransaccion;

	public ModelRespuesta() {
		this.fechaTransaccion = LocalDateTime.now();
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * @return the fecha
	 */
	public LocalDateTime getFechaTransaccion() {
		return fechaTransaccion;
	}

}
