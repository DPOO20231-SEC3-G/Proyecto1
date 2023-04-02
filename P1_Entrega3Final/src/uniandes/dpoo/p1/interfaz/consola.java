package uniandes.dpoo.p1.interfaz;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import uniandes.dpoo.p1.model.Cama;
import uniandes.dpoo.p1.procesamiento.Hotel;

public class consola {
	
	Hotel hotel;
	
	public void main(String[] args) {
		
		boolean continuar = true;
		
		hotel.cargarTodo();
		
		
		while (continuar) 
		{
			try 
			{
				mostrarMenuInicial();
				int opcionSeleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
				
				if (opcionSeleccionada == 1) {
					ejecutarIniciarSesion();
				}
				else if (opcionSeleccionada == 2) {
					ejecutarCerrarSesion();
				}
				else if (opcionSeleccionada == 3) {
					if (hotel.getSesionIniciada() != null){
						char rolUser = hotel.getSesionIniciada().getRol();
						
						if(rolUser == 'a') {
							mostrarMenuAdministrador();
						}
						else if(rolUser == 'r') {
							mostrarMenuRecepcionista();
						}
						else {
							mostrarMenuEmpleado();
						}
					}
					else {System.out.println("Inicie sesion antes.");}
				}
				else if (opcionSeleccionada == 4) {
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
				}
				else{
					System.out.println("Por favor seleccione una opción válida.");
				}
			}catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
		

		
	}
	
	public void mostrarMenuInicial() {
		System.out.println("Bienvenido al hotel\n\nIngrese la opcion deseada\n"+
				"1.Iniciar sesion\n"+
				"2.Cerrar sesion\n"+
				"3.Mostrar menu\n"+
				"4.Cerrar aplicacion");
	}
	
	public void mostrarMenuAdministrador() throws FileNotFoundException, ClassNotFoundException, IOException {
		System.out.println("Como administrador usted puede:\n"
				+"1.Cargar un nuevo archivo de habitaciones\n"
				+"2.Crear una nueva habitacion\n"
				+"3.Cargar un nuevo archivo de tarifas habitaciones\n"
				+"4.Modificar tarifas habitaciones\n"
				+"5.");
		
		int opcionAEjecutar = Integer.parseInt(input("Ingrese la opcion, por favor"));
		
		if (opcionAEjecutar == 1) {
			ejecutarCargaArchivoHabitaciones();
		}
		else if(opcionAEjecutar == 2) {
			ejecutarCrearHabitacion();
		}
		else if(opcionAEjecutar == 3) {
			ejecutarCargarArchivoTarifas();
		}
		else if(opcionAEjecutar == 4) {
			ejecutarModificarTarifasHabitaciones();
		}
		else {System.out.println("Ingrese una opcion válida.");}
		
		
		
	}
	
	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean boolInput(String mensaje) {
		int rta = Integer.parseInt(input(mensaje));
		
		while(rta != 1 && rta != 2) {
			System.out.println("Valor invalido.");
			rta = Integer.parseInt(input("Ingrese una opcion (1- True/ 2- False)"));
		}
		
		return 1 == rta;
	}
	
	public void ejecutarIniciarSesion() {
		
		String user = input("Ingrese su usuario");
		String contraseña = input("Ingrese su contraseña");
		
		hotel.iniciarSesion(user, contraseña);
	}
	
	public void ejecutarCerrarSesion() {
		
		hotel.cerrarSesion();
	}
	
	public void ejecutarCargaArchivoHabitaciones() throws FileNotFoundException, ClassNotFoundException, IOException {
		hotel.getAdministradorHabitaciones().cargarHabitaciones();
		System.out.println("Se ha cargado exitosamente el archivo que se encuentra en la ubicacion predeterminada.");
	}
	
	public void ejecutarCrearHabitacion() throws NumberFormatException, IOException {
		Integer nIdHabitacion = Integer.parseInt(input("Ingrese el id de la habitacion"));
		int nId = nIdHabitacion;
		String nUbicacion = input("Ingrese la ubicacion");
		int nNumPersonas = Integer.parseInt(input("Ingrese la capacidad maxima de la habitacion"));
		char nTipoHabitacion = input("Ingrese el tipo de habitacion ('e' - Estandar / 's' - Suit / 'd' - Suit doble ").replaceAll(" ", "").charAt(1);
		while(nTipoHabitacion != 'e' && nTipoHabitacion != 's' && nTipoHabitacion != 'd') {
			System.out.println("Caracter invalido");
			nTipoHabitacion = input("Ingrese el tipo de habitacion ('e' - Estandar / 's' - Suit / 'd' - Suit doble ").replaceAll(" ", "").charAt(1);
			}
		boolean nBalcon = boolInput("Ingrese si tiene balcon (1- True/ 2- False)");
		boolean nCocina = boolInput("Ingrese si tiene cocina (1- True/ 2- False)");
		boolean	nVista = boolInput("Ingrese si tiene vista (1- True/ 2- False)");
		boolean continuarCamas = true;
		ArrayList<Cama> camas = new ArrayList<Cama>();
		System.out.println("A continuacion ingrese la informacion de la primera cama.");
		while (continuarCamas) {
			double nAncho = Double.parseDouble(input("Ingrese el ancho de la cama"));
			double nAlto = Double.parseDouble(input("Ingrese el alto de la cama"));
			int nNumPersonasCama = Integer.parseInt(input("Ingrese la capacidad de la cama"));
			boolean nUsoNinos = boolInput("Ingrese si es apta para ninos");
			hotel.getAdministradorHabitaciones().agregarCamaALista(camas, nAncho, nAlto, nNumPersonasCama, nUsoNinos);
			continuarCamas = boolInput("Desea agregar otra cama? (1- True/ 2- False)");
		}
		hotel.getAdministradorHabitaciones().crearHabitacion(nIdHabitacion, nId, nUbicacion, nNumPersonas, nTipoHabitacion, nBalcon, nCocina, nVista, camas);
		
	}
	
	public void ejecutarCargarArchivoTarifas() throws FileNotFoundException, ClassNotFoundException, IOException {
		hotel.getAdministradorHabitaciones().cargarTarifas();
	}
	
	public void ejecutarModificarTarifasHabitaciones() {
		
	}

}
