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
	private ArrayList<String[]> cuenta;
	private boolean checkIn;
	private boolean checkOut;
	private boolean deuda;
	
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
		cuenta = new ArrayList<String[]>();
		checkIn = false;
		checkOut = false;
		deuda = false;
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

	public boolean getCheckIn() {
		return checkIn;
	}

	public boolean getCheckOut() {
		return checkOut;
	}

	public boolean getDeuda() {
		return deuda;
	}

	public void setReserva(HashMap<Date, Huesped> reserva){
		this.reserva = reserva;
	}

	public ArrayList<Cama> getCamas() {
		return camas;
	}

	public ArrayList<Huesped> getOcupantes() {
		return this.ocupantes;
	}

	public void ponerOcupantes(ArrayList<Huesped> nOcupantes) {
		this.ocupantes = nOcupantes;
	}
	
	public void setCheckIn(boolean checkIn) {
		this.checkIn = checkIn;
	}

	public void setCheckOut(boolean checkOut){
		this.checkOut = checkOut;
	}

	public void setDeuda(boolean deuda) {
		this.deuda = deuda;
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

	public void agregarServicio(String[] nuevoServicio) {
		cuenta.add(nuevoServicio);
	}
	
	public ArrayList<String[]> getCuenta(){
		return this.cuenta;
	}

	public void setCuenta(ArrayList<String[]> cuenta){
		this.cuenta = cuenta;
	}
}
