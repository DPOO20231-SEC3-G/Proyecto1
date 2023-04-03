package uniandes.dpoo.p1.procesamiento;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import uniandes.dpoo.p1.model.AdministradorHabitaciones;
import uniandes.dpoo.p1.model.AdministradorHuespedes;
import uniandes.dpoo.p1.model.AdministradorServicios;
import uniandes.dpoo.p1.model.Usuario;


public class Hotel {
	
	private String fichero = "./data/";
	
	private HashMap<String, Usuario> cuentas;
	
	private AdministradorHabitaciones administradorHabitaciones = new AdministradorHabitaciones();
	
	private AdministradorServicios administradorServicios = new AdministradorServicios();

	private AdministradorHuespedes administradorHuespedes = new AdministradorHuespedes();

	
	private Usuario sesionIniciada;
	
	public void cargarCuentas() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:/Users/Manu/OneDrive - Universidad de los Andes/Documentos/Uniandes/6to/Diseño y programación orientada a objetos/proyecto 1/Proyecto1-1/P1_Entrega3Final/data/Cuentas.dat"))) {
			this.cuentas = (HashMap<String, Usuario>) ois.readObject();
		}
		
	}
	
	public void guardarCuentas() throws FileNotFoundException, IOException {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero+"Cuentas.dat"))) {
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
		administradorServicios.cargarMenuRestaurante();
		administradorServicios.cargarServicios();
		administradorHuespedes.cargarHuespedes();
		
	}
	
	public Usuario getSesionIniciada() {
		return this.sesionIniciada;
	}
	
	public AdministradorHabitaciones getAdministradorHabitaciones() {
		return this.administradorHabitaciones;
	}


	public AdministradorServicios getAdministradorServicios() {
		return this.administradorServicios;
	}
	
	public AdministradorHuespedes gAdministradorHuespedes(){
		return this.administradorHuespedes;
	}
}

