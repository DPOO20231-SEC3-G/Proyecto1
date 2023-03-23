package uniandes.dpoo.model.administradorservicios;

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

	public boolean isCobroGrupal() {
		return this.cobroGrupal;
	}

	public HashMap<String ,ArrayList<Time>> getDisponibilidad() {
		return this.disponibilidad;
	}
}
