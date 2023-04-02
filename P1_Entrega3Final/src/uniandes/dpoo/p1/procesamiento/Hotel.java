package uniandes.dpoo.p1.procesamiento;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import uniandes.dpoo.p1.model.AdministradorHabitaciones;
import uniandes.dpoo.p1.model.Habitacion;
import uniandes.dpoo.p1.model.Usuario;


public class Hotel {
	
	private String fichero = "./data/";
	
	private HashMap<String, Usuario> cuentas;
	
	private AdministradorHabitaciones administradorHabitaciones;
	
	private AdministradorServicios administradorServicios;

	private AdministradorHuespedes administradorHuespedes;
	
	private Usuario sesionIniciada;
	
	public void cargarCuentas() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero+"Cuentas.data"))) {
			this.cuentas = (HashMap<String, Usuario>) ois.readObject();
		}
		
	}
	
	public void guardarCuentas() throws FileNotFoundException, IOException {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero+"Habitaciones.data"))) {
			oos.writeObject(cuentas);
		}
	}
	
	public void iniciarSesion(String user, String clave) {
		
		if(sesionIniciada != null){
			System.out.println("Ya hay una sesion iniciada, cierre la antes de iniciar otra.");
		}else {
		if (cuentas.containsKey(user)) {
			if (cuentas.get(user).getContraseña() == clave ) {
				sesionIniciada = cuentas.get(user);
				System.out.println("Se inicio sesión exitosamente.");
			}
		} else {System.out.println("Verifique su usuario o contraseña.");}
		}
	}
	
	public void cerrarSesion() {
		
		if( sesionIniciada != null ) {
			sesionIniciada = null;
			System.out.println("Sesion cerrada exitosamente.");
		}
	}

	public void cargarTodo() throws FileNotFoundException, ClassNotFoundException, IOException {
		administradorHabitaciones.cargarHabitaciones();
		cargarCuentas();
		
	}
	
	public Usuario getSesionIniciada() {
		return this.sesionIniciada;
	}
	
	public AdministradorHabitaciones getAdministradorHabitaciones() {
		return this.administradorHabitaciones;
	}

	public AdministradorHuespedes getAdministradorHuespedes() {
		return this.administradorHuespedes;
	}

	public AdministradorServicios getAdministradorServicios() {
		return this.administradorServicios;
	}
	
}

