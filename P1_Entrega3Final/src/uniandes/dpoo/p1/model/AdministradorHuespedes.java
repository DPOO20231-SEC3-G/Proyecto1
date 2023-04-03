package uniandes.dpoo.p1.model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class AdministradorHuespedes {
    private String fichero = "./data/";

    private HashMap<Integer, Huesped> inventario;

    public void cargarHuespedes() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero+"Huespedes.data"))) {
			this.inventario = (HashMap<Integer, Huesped>) ois.readObject();
		}
	}

    public void guardarHuespedes() throws FileNotFoundException, IOException {
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero+"Huespedes.data"))) {
			oos.writeObject(inventario);
		}
		
	}

    public void reservarHabitacion(HashMap<Integer, Habitacion> inventarioHabitaciones, HashMap<Integer, Huesped> inventarioHuespedes, Integer idHabitacion, String date, ArrayList<Integer> idsHuespedes){

        for (int i = 0; i < idsHuespedes.size(); i++){
            Integer idHuesped = idsHuespedes.get(i);
            Huesped huesped = inventarioHuespedes.get(idHuesped);
            huesped.setIdHabitacion(idHabitacion);
            
            Habitacion habitacion = inventarioHabitaciones.get(idHabitacion);
            HashMap<Date, Huesped> reservasHabitacion = habitacion.getReserva();

            if (! reservasHabitacion.containsKey(date)){
                reservasHabitacion.put(date, huesped);
                habitacion.setReserva(reservasHabitacion);
                habitacion.ponerOcupantes(idsHuespedes);
            }
        }
    }

    public void cancelarReserva(HashMap<Integer, Habitacion> inventarioHabitaciones, HashMap<Integer, Huesped> inventarioHuespedes, Integer idHabitacion, String date, ArrayList<Integer> idsHuespedes){
        for (int i = 0; i < idsHuespedes.size(); i++){
            Integer idHuesped = idsHuespedes.get(i);
            Huesped huesped = inventarioHuespedes.get(idHuesped);
            huesped.setIdHabitacion(null);

            Habitacion habitacion = inventarioHabitaciones.get(idHabitacion);
            habitacion.ponerOcupantes(null);
            HashMap<Date, Huesped> reservasHabitacion = habitacion.getReserva();

            if (reservasHabitacion.containsKey(date)){
                reservasHabitacion.put(date, null);
                habitacion.setReserva(reservasHabitacion);
            }
        }
    }

    public void registrarUsoServicio(HashMap<String, Servicio> inventarioServicios, HashMap<Integer, Habitacion> inventarioHabitaciones, Integer idHabitacion, String nombreServicio, Boolean pago){
        Servicio servicio = inventarioServicios.get(nombreServicio);
        String precio = servicio.getPrecio() + "";
        Habitacion habitacion = inventarioHabitaciones.get(idHabitacion);

        if (pago){
            String[] infoServicio = {nombreServicio, precio, "Pago"};
            habitacion.agregarServicio(infoServicio);
        }
        else{
            String[] infoServicio = {nombreServicio, precio, "No-Pago"};
            habitacion.agregarServicio(infoServicio);
            habitacion.setDeuda(true);
        }
    }

    public void registrarPago(HashMap<Integer, Habitacion> inventarioHabitaciones, Integer idHabitacion){
        Habitacion habitacion = inventarioHabitaciones.get(idHabitacion);
        ArrayList<String[]> cuenta = habitacion.getCuenta();
        ArrayList<String[]> nuevaCuenta = new ArrayList<String[]>();

        for (int i = 0; i < cuenta.size(); i++){
            String[] servicio = cuenta.get(i);
            servicio[2] = "Pago";
            nuevaCuenta.add(servicio);
        }

        habitacion.setCuenta(nuevaCuenta);
        habitacion.setDeuda(false);
    }

    public void registrarLlegada(HashMap<Integer, Habitacion> inventarioHabitaciones, Integer idHabitacion){
        Habitacion habitacion = inventarioHabitaciones.get(idHabitacion);
        habitacion.setCheckIn(true);
    }

    public boolean registrarSalida(HashMap<Integer, Habitacion> inventarioHabitaciones, Integer idHabitacion){
        Habitacion habitacion = inventarioHabitaciones.get(idHabitacion);
        boolean deuda = habitacion.getDeuda();
        boolean aprobacion = false;

        if (! deuda){
            habitacion.setCheckOut(true);
            aprobacion = true;
        } 

        return aprobacion;
    }

    

}
