package uniandes.dpoo.p1.model;

import java.util.ArrayList;


public class Huesped {

	private String nombre;
	private int edad;
	private String id;
	private String correo;
	private int idHabitacion;
	
	public Huesped(String nNombre, int nEdad, String nId, String nCorreo, int nIdHabitacion) {
		
		nombre = nNombre;
		edad = nEdad;
		id = nId;
		correo = nCorreo;
		idHabitacion = nIdHabitacion;
		
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int getEdad() {
		return this.edad;
	}

	public String getId() {
		return this.id;
	}

	public String getCorreo() {
		return correo;
	}

	public int getIdHabitacion() {
		return idHabitacion;
	}

	public void setIdHabitacion(Integer idHabitacion){
		this.idHabitacion = idHabitacion;
	}
	
}