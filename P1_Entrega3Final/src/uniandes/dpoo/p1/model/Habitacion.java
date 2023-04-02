package uniandes.dpoo.p1.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.io.Serializable;

public class Habitacion implements Serializable{
	
	private int id;
	private String ubicacion;
	private int numPersonas;
	private char tipoHabitacion;
	private boolean balcon;
	private boolean cocina;
	private boolean vista;
	private ArrayList<Cama> camas;
	private HashMap<Date, Huesped> reserva;
	private ArrayList<Huesped> ocupantes;
	
	public Habitacion(int nId, String nUbicacion, int nNumPersonas, char nTipoHabitacion, boolean nBalcon, boolean nCocina, boolean nVista, ArrayList<Cama> nCamas , HashMap<Date, Huesped> nReserva) {
		
		id = nId;
		ubicacion = nUbicacion;
		numPersonas = nNumPersonas;
		tipoHabitacion = nTipoHabitacion;
		balcon = nBalcon;
		cocina = nCocina;
		vista = nVista;
		camas = nCamas;
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

	public ArrayList<Cama> getCamas() {
		return camas;
	}

	public ArrayList<Huesped> getOcupantes() {
		return ocupantes;
	}

	public void ponerOcupantes(ArrayList<Huesped> nOcupantes) {
		this.ocupantes = nOcupantes;
	}
	
	public String toString() {
		String rta = "Id habitacion = $s\nUbicacion = $s\nCapacidad de personas = $d\nTipo de habitacion = $s\nCamas = $s\nCocina = $s\nBalcon = $s\nVista = $s\n";
		String camas = "";
		String tHabitacion = "";
		String hCocina = "No";
		String hBalcon = "No";
		String hVista = "No";
		for (Cama cama : this.camas) {
			camas += "\n*"+cama.toString();
		}
		if (this.tipoHabitacion == 'e'){
			tHabitacion = "Estandar";}
		else if (this.tipoHabitacion == 's') {
			tHabitacion = "Suit";}
		else if (this.tipoHabitacion == 'd') {
			tHabitacion = "Doble Suit";}
		
		if (this.cocina == true) {
			hCocina = "Si";
		}
		if (this.balcon == true) {
			hBalcon = "Si";
		}
		if (this.vista == true) {
			hVista = "Si";
		}
		
		return rta.formatted(this.id, this.ubicacion, this.numPersonas, tHabitacion, camas, hCocina, hBalcon, hVista);
	}
	

}