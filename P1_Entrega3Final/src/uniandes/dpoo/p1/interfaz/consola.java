package uniandes.dpoo.p1.interfaz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import uniandes.dpoo.p1.model.AdministradorServicios;
import uniandes.dpoo.p1.model.Cama;
import uniandes.dpoo.p1.model.Servicio;
import uniandes.dpoo.p1.procesamiento.Hotel;


public class consola {
	
	Hotel hotel;
	
	public void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException, ParseException {
		
		boolean continuar = true;
		
		hotel.cargarTodo();
		
		
		while (continuar) 
		{
			try 
			{
				mostrarMenuInicial();
				Integer opcionSeleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
				
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
	
	public void mostrarMenuAdministrador() throws FileNotFoundException, ClassNotFoundException, IOException, NumberFormatException, ParseException {
		System.out.println("Como administrador usted puede:\n"
				+"1.Cargar un nuevo archivo de habitaciones\n"
				+"2.Crear una nueva habitacion\n"
				+"3.Cargar un nuevo archivo de tarifas habitaciones\n"
				+"4.Modificar tarifas habitaciones\n"
				+"5.Cargar un menú para el restaurante\n"
				+"6.Cargar un conjunto de servicios\n"
				+"7.Modificarle el nombre a un servicio\n"
				+"8.Modificarle el precio a un servicio\n"
				+"9.Modificarle la decripción a un servicio\n"
				+"10.Modificarle el cobro grupal a un servicio\n"
				+"11.Revisar tarifas dentro 360 dias\n");
		
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
		else if(opcionAEjecutar == 5) {
			ejecutarCargarMenu();
		}

		else if(opcionAEjecutar == 6) {
			ejecutarCargarServicios();
		}

		else if(opcionAEjecutar == 7) {
			String nombreserv = input("Ingrese el nombre del servicio que desea modificar: ");
			AdministradorServicios admin = hotel.getAdministradorServicios();
			HashMap<String,Servicio> inventario = admin.getInventario();
			Servicio servicio = inventario.get(nombreserv);
			String nombremod = input("Ingrese el nombre nuevo para el servicio que indicó: ");
			ejecutarModificarNombreServicio(nombremod,servicio);
			inventario.remove(nombreserv,servicio);
			inventario.put(nombremod,servicio);
		}

		else if(opcionAEjecutar == 8) {
			String nombreserv = input("Ingrese el nombre del servicio que desea modificar: ");
			AdministradorServicios admin = hotel.getAdministradorServicios();
			HashMap<String,Servicio> inventario = admin.getInventario();			
			Servicio servicio = inventario.get(nombreserv);
			Integer preciomod = Integer.parseInt(input("Ingrese el nuevo precio para el servicio que indicó: "));
			ejecutarModificarPrecioServicio(preciomod,servicio);
		}

		else if(opcionAEjecutar == 9) {
			String nombreserv = input("Ingrese el nombre del servicio que desea modificar: ");
			AdministradorServicios admin = hotel.getAdministradorServicios();
			HashMap<String,Servicio> inventario = admin.getInventario();			
			Servicio servicio = inventario.get(nombreserv);
			String dservmod = input("Ingrese la nueva descripción para el servicio que indicó: ");
			ejecutarModificarDescripcionServicio(dservmod,servicio);
		}

		else if(opcionAEjecutar == 10) {
			String nombreserv = input("Ingrese el nombre del servicio que desea modificar: ");
			AdministradorServicios admin = hotel.getAdministradorServicios();
			HashMap<String,Servicio> inventario = admin.getInventario();			
			Servicio servicio = inventario.get(nombreserv);
			boolean bool = boolInput("Ingrese si el servicio que indicó va a tener cobro grupal o no (1-True, 2-False): ");
			ejecutarModificarCGrupalServicio(bool,servicio);
		}

		else if(opcionAEjecutar == 11) {
			ejecutarRevisarTarifas();
		}
		else {System.out.println("Ingrese una opcion válida.");}
		
	}

	public void mostrarMenuEmpleado() throws FileNotFoundException, ClassNotFoundException, IOException {
		System.out.println("Como Empleado usted puede:\n"
				+"1.Ingresar el consumo de un servicio a la cuenta de un huésped\n"
				+"2.Ingresar el pago de un servicio consumido por un huésped\n");
		
		Integer opcionAEjecutar = Integer.parseInt(input("Ingrese la opcion, por favor"));

		if (opcionAEjecutar == 1) {
			ejecutarRegistroUsoDeServicio();
		}

		else if (opcionAEjecutar == 2){
			ejecutarRegistrarPago();
		}

		else {System.out.println("Ingrese una opcion válida.");}
	}

	public void mostrarMenuRecepcionista() throws FileNotFoundException, ClassNotFoundException, IOException, ParseException{
		System.out.println("Como Recepcionista usted puede:\n"
				+"1.Registrar el check in de un huésped\n"
				+"2.Registrar el check out de un huésped\n"
				+"3.Hacer una reservación para un huésped\n"
				+"4.Cancelar una reservación para un huésped\n"
				+"5.Generarle la factura final a un huésped\n"
				+"6.Revisar habitacion para cierta fecha\n");
		
		int opcionAEjecutar = Integer.parseInt(input("Ingrese la opcion, por favor"));

		if (opcionAEjecutar == 1) {
			ejecutarRegistroDeLlegada();
		}

		else if (opcionAEjecutar == 2){
			ejecutarRegistroDeSalida();
		}

		else if (opcionAEjecutar == 3){
			ejecutarReservarHabitacion();
		}

		else if (opcionAEjecutar == 4){
			ejecutarCancelarReserva();
		}

		else if (opcionAEjecutar == 5){
			ejecutarGenerarFactura();
		}
		else if (opcionAEjecutar == 6) {
			ejecutarRevisarHabitacion();
		}

		else {System.out.println("Ingrese una opcion válida.");}
	}


//Facilitar transformar datos 

	public String input(String mensaje) {
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


//Ejecutar menu administrador

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
	
	public void ejecutarModificarTarifasHabitaciones() throws NumberFormatException, IOException, ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date fechaInicial = formatter.parse(input("Ingrese la fecha de inicial (dd/MM/yyyy)"));
		Date fechaFinal = formatter.parse(input("Ingrese la fecha final (dd/MM/yyyy)"));
		char nTipoHabitacion = input("Ingrese el tipo de habitacion ('e' - Estandar / 's' - Suit / 'd' - Suit doble ").replaceAll(" ", "").charAt(1);
		while(nTipoHabitacion != 'e' && nTipoHabitacion != 's' && nTipoHabitacion != 'd') {
			System.out.println("Caracter invalido");
			nTipoHabitacion = input("Ingrese el tipo de habitacion ('e' - Estandar / 's' - Suit / 'd' - Suit doble ").replaceAll(" ", "").charAt(1);
			}
		ArrayList<String> dias = new ArrayList<String>();
		while (dias.isEmpty()) {
			if(boolInput("Desean que la tarifa se aplique los LUNES dentro del rango? (1 - True / 2 - False)")) {
				dias.add("lunes");
			}
			if(boolInput("Desean que la tarifa se aplique los MARTES dentro del rango? (1 - True / 2 - False)")) {
				dias.add("martes");
			}
			if(boolInput("Desean que la tarifa se aplique los MIERCOLES dentro del rango? (1 - True / 2 - False)")) {
				dias.add("miercoles");
			}
			if(boolInput("Desean que la tarifa se aplique los JUEVES dentro del rango? (1 - True / 2 - False)")) {
				dias.add("jueves");
			}
			if(boolInput("Desean que la tarifa se aplique los VIERNES dentro del rango? (1 - True / 2 - False)")) {
				dias.add("viernes");
			}
			if(boolInput("Desean que la tarifa se aplique los SABADO dentro del rango? (1 - True / 2 - False)")) {
				dias.add("sabado");
			}
			if(boolInput("Desean que la tarifa se aplique los DOMINGO dentro del rango? (1 - True / 2 - False)")) {
				dias.add("domingo");
			}
			if(dias.isEmpty()) {
				System.out.println("No ha ingresado ningun dia en su rango. Se procedera a preguntar otra vez.");
			}
		}
		Integer tarifa = Integer.parseInt(input("Ingrese la tarifa a colocar"));
		
		hotel.getAdministradorHabitaciones().modificarTarifaRangoFechas(nTipoHabitacion, fechaInicial, fechaFinal, dias, tarifa);
	}
	
	public void ejecutarRevisarTarifas() {
		hotel.getAdministradorHabitaciones().revisarTarifas();
	}
	
	public void ejecutarRevisarHabitacion() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date fecha = formatter.parse(input("Ingrese la fecha en formato (dd/MM/yyyy)"));
		Integer idHabitacion = Integer.parseInt(input("Ingrese el id de la habitacion a revisar"));
		hotel.getAdministradorHabitaciones().revisarHabitacion(fecha, idHabitacion);
	}

	public void ejecutarCargarMenu() throws FileNotFoundException, ClassNotFoundException, IOException {
		hotel.getAdministradorServicios().cargarMenuRestaurante();
		System.out.println("Se ha cargado exitosamente el archivo que se encuentra en la ubicacion predeterminada.");
	}

	public void ejecutarCargarServicios() throws FileNotFoundException, ClassNotFoundException, IOException {
		hotel.getAdministradorServicios().cargarServicios();
		System.out.println("Se ha cargado exitosamente el archivo que se encuentra en la ubicacion predeterminada.");
	}

	public void ejecutarModificarNombreServicio(String nombre, Servicio servicio) {
		hotel.getAdministradorServicios().modificarNombreServicio(servicio,nombre);
		System.out.println("Se ha modificado exitósamente el nombre del servicio solicitado");
	}

	public void ejecutarModificarPrecioServicio(Integer precio, Servicio servicio){
		hotel.getAdministradorServicios().modificarPrecioServicio(servicio,precio);
		System.out.println("Se ha modificado exitósamente el nombre del servicio solicitado");
	}

	public void ejecutarModificarCGrupalServicio(boolean bool, Servicio servicio){
		hotel.getAdministradorServicios().modificarCGrupalServicio(servicio,bool);
		System.out.println("Se ha modificado exitósamente el nombre del servicio solicitado");
	}

	public void ejecutarModificarDescripcionServicio(String descripcion, Servicio servicio){
		hotel.getAdministradorServicios().modificarDescripcionServicio(servicio,descripcion);
		System.out.println("Se ha modificado exitósamente el nombre del servicio solicitado");
	}



//Ejecutar menu empleado

	public void ejecutarRegistroUsoDeServicio(){}

	public void ejecutarRegistrarPago(){}


//Ejecutar menu recepcionista

	public void ejecutarRegistroDeLlegada(){}

	public void ejecutarRegistroDeSalida(){}

	public void ejecutarReservarHabitacion(){}

	public void ejecutarCancelarReserva(){}

	public File ejecutarGenerarFactura(){
		return null;}
}
