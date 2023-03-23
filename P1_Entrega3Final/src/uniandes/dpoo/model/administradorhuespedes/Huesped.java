package uniandes.dpoo.model.administradorhuespedes;

import java.util.ArrayList;
import java.util.List;

public class Huesped {

	private String nombre;
	private int edad;
	private String id;
	private String correo;
	private ArrayList<int[]> cuenta;
	private int idHabitacion;
	
	public Huesped(String nNombre, int nEdad, String nId, String nCorreo, int nIdHabitacion) {
		
		nombre = nNombre;
		edad = nEdad;
		id = nId;
		correo = nCorreo;
		cuenta = new ArrayList<int[]>();
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
	
	public void agregarServicio(int codigoServicio, int valorServicio) {
		int[] temp = {codigoServicio, valorServicio};
		cuenta.add(temp);
	}
	
	public ArrayList<int[]> getCuenta(){
		return this.cuenta;
	}
	
	public int getTotalCuenta() {
		int totalCuenta = 0;
		for(int[] sublista : cuenta){
			totalCuenta += sublista[1];
		}
		return totalCuenta;
	}
	
}