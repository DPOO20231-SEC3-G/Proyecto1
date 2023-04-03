package uniandes.dpoo.p1.model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;

public class Servicio {
	private String nombre;
	private int precio;
	private String descripcion;
	private boolean cobroGrupal;
	private HashMap<String ,ArrayList<Time>> disponibilidad ;
	
	public Servicio(String nNombre, int nPrecio, String nDescripcion, boolean nBool, HashMap<String ,ArrayList<Time>> nDisponibilidad) {
		
		nombre = nNombre;
		precio = nPrecio;
		descripcion = nDescripcion;
		cobroGrupal = nBool;
		disponibilidad = nDisponibilidad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public int getPrecio() {
		return this.precio;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public boolean getCobroGrupal() {
		return this.cobroGrupal;
	}

	public HashMap<String ,ArrayList<Time>> getDisponibilidad() {
		return this.disponibilidad;
	}
	
	public void setNombre (String nNombre) {
		this.nombre = nNombre;
	}
	
	public void setPrecio (int nPrecio) {
		this.precio = nPrecio;
	}
	
	public void setDescripcion (String ndespcripcion) {
		this.descripcion = ndespcripcion;
	}
	
	public void setCobroGrupal (boolean nBool) {
		this.cobroGrupal = nBool;
	}
	
}
