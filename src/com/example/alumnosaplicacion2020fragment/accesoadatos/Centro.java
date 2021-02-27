package com.example.alumnosaplicacion2020fragment.accesoadatos;

import java.io.Serializable;

public class Centro implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1731586799610479536L;
	/**
	 * 
	 */

	private long numCentro;
	private String nombreCentro;
	private String localidad;
	private String provincia;
	private String direccion;
	private String telefono;

	
	
	public Centro() {
		
		
	}
	
	public Centro(long numCentro, String nombreCentro, String localidad, String provincia, String direccion,
			String telefono) {
		super();
		this.numCentro = numCentro;
		this.nombreCentro = nombreCentro;
		this.localidad = localidad;
		this.provincia = provincia;
		this.direccion = direccion;
		this.telefono = telefono;

	}

	public long getNumCentro() {
		return numCentro;
	}

	public void setNumCentro(long numCentro) {
		this.numCentro = numCentro;
	}

	public String getNombreCentro() {
		return nombreCentro;
	}

	public void setNombreCentro(String nombreCentro) {
		this.nombreCentro = nombreCentro;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	

	@Override
	public String toString() {
		return "Centro [numCentro=" + numCentro + ", nombreCentro=" + nombreCentro + ", localidad=" + localidad
				+ ", provincia=" + provincia + ", direccion=" + direccion + ", telefono=" + telefono +   "]";
	}
	
	
	
	

}
