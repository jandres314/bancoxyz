package com.poligran.bancoxyz.aplicacion;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class AdapterMap {
	
	public int obtenerEntero(String key, Map<String, Object> values) {
		String value = values.get(key).toString();
		return Integer.parseInt(value);
	}
	
	public String obtenerString(String key, Map<String, Object> values) {
		return values.get(key).toString();
	}

}
