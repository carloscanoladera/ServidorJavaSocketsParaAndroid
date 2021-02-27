package com.example.alumnosaplicacion2020fragment.accesoadatos;

import java.io.Serializable;
import java.util.HashMap;

import constantesservidor.ConstantesServidor;

public class PeticionRespuesta extends HashMap<String, Centro> implements Serializable{

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	
	public static final PeticionRespuesta RESPUESTA_ERRONEA = new PeticionRespuesta(ConstantesServidor.RESPUESTA_ERROR,null);
	
	
	public PeticionRespuesta() {
		
		
		
	}
	
	public PeticionRespuesta(String codigo, Centro centro) {
		
		
		put(codigo,centro);
		
		
		
	}

	@Override
	public String toString() {
		return "PeticionRespuesta []";
	}
	
	

}
