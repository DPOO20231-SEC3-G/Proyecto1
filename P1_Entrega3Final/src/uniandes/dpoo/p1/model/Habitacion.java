package uniandes.dpoo.p1.model;

import java.util.Date;
import java.util.HashMap;
import java.io.Serializable;

public class Habitacion {
	
	private int id;
	private String ubicacion;
	private int numPersonas;
	private char tipoHabitacion;
	private boolean balcon;
	private boolean cocina;
	private boolean vista;
	private HashMap<Date, Huesped> reserva;
	
	public Habitacion(int nId, String nUbicacion, int nNumPersonas, char nTipoHabitacion, boolean nBalcon, boolean nCocina, boolean nVista, HashMap<Date, Huesped> nReserva) {
		
		id = nId;
		ubicacion = nUbicacion;
		numPersonas = nNumPersonas;
		tipoHabitacion = nTipoHabitacion;
		balcon = nBalcon;
		cocina = nCocina;
		vista = nVista;
		reserva = nReserva;
		
	}
	
	public int getId() {
		return this.id;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public int getNumPersonas() {
		return numPersonas;
	}

	public char getTipoHabitacion() {
		return tipoHabitacion;
	}

	public boolean getBalcon() {
		return balcon;
	}

	public boolean getCocina() {
		return cocina;
	}

	public boolean getVista() {
		return vista;
	}

	public HashMap<Date, Huesped> getReserva() {
		return reserva;
	}

}
