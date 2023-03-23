package uniandes.dpoo.model.administradorhuespedes;

import java.util.ArrayList;

public class Grupo{
	
	private int idGrupo;
	
	private ArrayList<Huesped> huespedes;
	
	private ArrayList<Integer> habitaciones;
	
	public Grupo(int nIdGrupo, ArrayList<Huesped> nHuespedes, ArrayList<Integer> nHabitaciones) {
		
		idGrupo = nIdGrupo;
		
		huespedes = nHuespedes;
		
		habitaciones = nHabitaciones;
	}

	public int getIdGrupo() {
		return idGrupo;
	}

	public ArrayList<Huesped> getHuespedes() {
		return huespedes;
	}

	public ArrayList<Integer> getHabitaciones() {
		return habitaciones;
	}

}
