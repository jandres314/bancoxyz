package com.poligran.bancoxyz.persistence;

import org.springframework.stereotype.Repository;

import com.poligran.bancoxyz.dominio.ModelCliente;

/**
 * repositorio que expone operaciones de persistencia para clientes
 * 
 * @author josorio
 *
 */
@Repository
public class RepositorioCliente extends BaseRepositorio {

	/**
	 * crea un cliente en base de datos
	 * 
	 * @param model
	 * @return
	 */
	public int insertar(ModelCliente model) {
		String sql = "insert into clientes (nombre, tipo_identificacion, numero_identificacion, estado, telefono, ciudad, direccion, fecha_nacimiento) values(?, ?, ?, ?, ?, ?, ?, ?)";
		return super.update(sql, model.getNombre(), model.getTipoIdentificacion(), model.getNumeroIdentificacion(),
				model.isEstado(), model.getTelefono(), model.getCiudad(), model.getDireccion(),
				model.getFechaNacimiento());
	}

}
