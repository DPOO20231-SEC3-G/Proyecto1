package uniandes.dpoo.p1.model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;


public class AdministradorHabitaciones {
	
	private String fichero = "./data/"; 
	
	private HashMap<Integer, Habitacion> inventario = new HashMap<Integer, Habitacion>();
	
	private Calendario calendario = new Calendario(new HashMap <Date, Integer>() , new HashMap <Date, Integer>(), new HashMap <Date, Integer>()); 
	
	public void cargarHabitaciones() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero+"Habitaciones.data"))) {
			HashMap<Integer, Habitacion> read = (HashMap<Integer, Habitacion>) ois.readObject();
			this.inventario = read;
		}
	}
	
	public void cargarTarifas()throws FileNotFoundException, IOException, ClassNotFoundException {
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero+"Tarifa.data"))) {
			this.calendario = (Calendario) ois.readObject();
		}
	}
	
	public void guardarHabitaciones() throws FileNotFoundException, IOException {
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero+"Habitaciones.data"))) {
			oos.writeObject(inventario);
		}
		
	}
	
	public void guardarTarifas() throws FileNotFoundException, IOException {
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero+"Tarifa.data"))) {
			oos.writeObject(calendario);
			
		}
	
	}
	
	public void modificarTarifa(char indiceHabitacion, Date Fecha, Integer valor) throws NumberFormatException, IOException {
		
		HashMap<Date, Integer> tarifas;
		
		if (indiceHabitacion == 1) {
			tarifas = calendario.getTarifaEstandar();
			if (tarifas.containsKey(Fecha)) {
				Integer tarifa = tarifas.get(Fecha);
				
				if (tarifa > valor) {
					tarifas.put(Fecha, valor);
					calendario.setTarifaEstandar(tarifas);
				}
			}
			else {tarifas.put(Fecha, valor);
				calendario.setTarifaEstandar(tarifas);
				}
			System.out.println("Tarifa ingresada exitosamente");
		}
		else if (indiceHabitacion == 2) {
			tarifas = calendario.getTarifaSuit();
			if (tarifas.containsKey(Fecha)) {
				Integer tarifa = tarifas.get(Fecha);
				
				if (tarifa > valor) {
					tarifas.put(Fecha, valor);
					calendario.setTarifaSuit(tarifas);
				}
			}
			else {tarifas.put(Fecha, valor);
				calendario.setTarifaSuit(tarifas);
				}
			System.out.println("Tarifa ingresada exitosamente");
		}
		else if (indiceHabitacion == 3) {
			tarifas = calendario.getTarifaSuitDoble();
			if (tarifas.containsKey(Fecha)) {
				Integer tarifa = tarifas.get(Fecha);
				
				if (tarifa > valor) {
					tarifas.put(Fecha, valor);
					calendario.setTarifaSuitDoble(tarifas);
				}
			}
			else {tarifas.put(Fecha, valor);
				calendario.setTarifaSuitDoble(tarifas);
				}
			System.out.println("Tarifa ingresada exitosamente");
		}
		else {System.out.println("Valor invalido");}
			
	}
	
	public void modificarTarifaRangoFechas(char indiceHabitacion, Date fechaInicia, Date fechaFinal, ArrayList<String> listaDias, Integer valor) throws NumberFormatException, IOException {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fechaFinal);
		
		while (calendar.getTime().before(fechaFinal) || calendar.getTime().equals(fechaFinal)) {
			
			if (listaDias.contains(calendario.obtenerDiaSemana(calendar.getTime()))) {
				this.modificarTarifa(indiceHabitacion, calendar.getTime(), valor);
			}
			
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			
		}
	}
	
	public void crearHabitacion(Integer idHabitacion, int nId, String nUbicacion, int nNumPersonas, char nTipoHabitacion, boolean nBalcon, boolean nCocina, boolean nVista, ArrayList<Cama> nCamas) throws NumberFormatException, IOException {
		Habitacion nuevaHabitacion = new Habitacion(nId, nUbicacion, nNumPersonas, nTipoHabitacion, nBalcon, nCocina, nVista, nCamas, null);
		if (inventario.containsKey(idHabitacion)){
			System.out.println("La id ya le pertenece a una habitacion\nDesea reemplazarla(0-Si/1-No): ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			int opcion = Integer.parseInt(reader.readLine());
			if (opcion == 0) {
				inventario.put(idHabitacion, nuevaHabitacion);
				System.out.println("La habitacion se ha agregado exitosamente");
			}else {System.out.println("La habitacion no se ha agregado exitosamente");}
		}
		else {inventario.put(idHabitacion, nuevaHabitacion);
				System.out.println("La habitacion se ha agregado exitosamente");}
	}
	
	public void revisarHabitacion(Date fecha, Integer idHabitacion) {
		Habitacion habitacionInfo = inventario.get(idHabitacion);
		String estado = "Sin reservar";
		if (habitacionInfo.getOcupantes().isEmpty()) {
			if (habitacionInfo.getReserva().containsKey(fecha)) {
				estado = "Reservada a nombre de "+ habitacionInfo.getReserva().get(fecha);
			}
		}
		else { estado = "Ocupada por";
			for ( Huesped ocupante : habitacionInfo.getOcupantes()) {
				estado += " "+ocupante.getNombre()+",";}
			estado = estado.substring(0, estado.length()- 1);
		}
		
		System.out.print(habitacionInfo.toString()+"\nEstado = "+estado);
		
	}
	
	public ArrayList<Cama> agregarCamaALista(ArrayList<Cama> lista,double ancho, double alto, int numPersonas, boolean usoNinos){
		lista.add(new Cama(ancho, alto, numPersonas, usoNinos));
		
		return lista;}
		
	public void revisarTarifas() {
		HashMap<Date, Integer> tarifasEstandar =  this.calendario.getTarifaEstandar();
		HashMap<Date, Integer> tarifasSuit = this.calendario.getTarifaSuit();
		HashMap<Date, Integer> tarifasSuitDoble = this.calendario.getTarifaSuitDoble();
		ArrayList<String> listaEstandar = new ArrayList<String>();
		ArrayList<String> listaSuit = new ArrayList<String>();
		ArrayList<String> listaSuitDoble = new ArrayList<String>();
		
		Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        
        for (int i = 0; i < 365; i++) {
            
            if(!tarifasEstandar.containsKey(calendar.getTime())) {
            	listaEstandar.add(formatter.format(calendar.getTime()));
            }
            if(!tarifasSuit.containsKey(calendar.getTime())) {
            	listaSuit.add(formatter.format(calendar.getTime()));
            }
            if(!tarifasSuitDoble.containsKey(calendar.getTime())) {
            	listaSuitDoble.add(formatter.format(calendar.getTime()));
            }
            calendar.add(Calendar.DATE, 1);
        }
        if (listaEstandar.isEmpty() && listaSuit.isEmpty() && listaSuitDoble.isEmpty()) {
        	System.out.println("Tienes las tarifas establecidas para los proximos 360 dias");
        } else {
        	System.out.println("No ha establecido las siguientes tarifas:");
        	if (!listaEstandar.isEmpty()) {
        		System.out.println("Estandar:");
        		for (String item: listaEstandar) {
        			System.out.println(item);
        		}
        	}
        	if (!listaSuit.isEmpty()) {
        		System.out.println("Estandar:");
        		for (String item: listaSuit) {
        			System.out.println(item);
        		}
        	}
        	if (!listaSuitDoble.isEmpty()) {
        		System.out.println("Estandar:");
        		for (String item: listaSuitDoble) {
        			System.out.println(item);
        		}
        	}
        }
		
	}
		
}
