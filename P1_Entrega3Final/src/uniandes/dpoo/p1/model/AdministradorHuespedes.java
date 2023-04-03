package uniandes.dpoo.p1.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AdministradorHuespedes {
    private String fichero = "./data/";

    private HashMap<Integer, Huesped> inventario;

    public void cargarHuespedes() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero+"Huespedes.dat"))) {
			this.inventario = (HashMap<Integer, Huesped>) ois.readObject();
		}
	}

    public void guardarHuespedes() throws FileNotFoundException, IOException {
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Huespedes.dat"))) {
			oos.writeObject(this.inventario);
		}
		
	}

    public void reservarHabitacion(HashMap<Integer, Habitacion> inventarioHabitaciones, HashMap<Integer, Huesped> inventarioHuespedes, Integer idHabitacion, String date, ArrayList<Huesped> listHuespedes) throws ParseException{
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");      
        Date datef = formatter.parse(date);
        for (int i = 0; i < listHuespedes.size(); i++){
            Integer idHuesped = listHuespedes.get(i).getId();
            Huesped huesped = inventarioHuespedes.get(idHuesped);
            huesped.setIdHabitacion(idHabitacion);
            
            Habitacion habitacion = inventarioHabitaciones.get(idHabitacion);
            HashMap<Date, Huesped> reservasHabitacion = habitacion.getReserva();

            if (! reservasHabitacion.containsKey(datef)){
                reservasHabitacion.put(datef, huesped);
                habitacion.setReserva(reservasHabitacion);
                habitacion.ponerOcupantes(listHuespedes);
            }
        }
    }

    public void cancelarReserva(HashMap<Integer, Habitacion> inventarioHabitaciones, HashMap<Integer, Huesped> inventarioHuespedes, Integer idHabitacion, String date, ArrayList<Huesped> idsHuespedes) throws ParseException{
        for (int i = 0; i < idsHuespedes.size(); i++){
            Integer idHuesped = idsHuespedes.get(i);
            Huesped huesped = inventarioHuespedes.get(idHuesped);
            huesped.setIdHabitacion(null);

            Habitacion habitacion = inventarioHabitaciones.get(idHabitacion);
            habitacion.ponerOcupantes(null);
            HashMap<Date, Huesped> reservasHabitacion = habitacion.getReserva();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");      
            Date datef = formatter.parse(date);
            if (reservasHabitacion.containsKey(datef)){
                reservasHabitacion.remove(datef);
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

    public void nuevaFactura(HashMap<Integer, Habitacion> inventarioHabitaciones, Integer idHabitacion) throws IOException{
        Habitacion habitacion = inventarioHabitaciones.get(idHabitacion);
        ArrayList<String[]> cuenta = habitacion.getCuenta();
        
        FileWriter archivo = null;
        PrintWriter escritor = null;

        try{
            archivo = new FileWriter("./data/factura.txt");
            escritor = new PrintWriter(archivo);
            Integer total = 0;
        
            escritor.print("              ");
            escritor.println("Factura");

            for (int i = 0; i < cuenta.size(); i++){
                String[] servicio = cuenta.get(i);
                escritor.println("Servicio: " + servicio[0] + ", " + servicio[2]);
                escritor.println("Valor: " + servicio[1]);
                String excedente = servicio[1];

                if (servicio[2] == "Pago"){
                    excedente = "0";
                }

                escritor.println("Excedente: " + excedente);
                total += Integer.parseInt(excedente);
            }

            escritor.println("Total: " + total);

        } catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }finally{
            archivo.close();
        }
    }

    public HashMap<Integer,Huesped> getInventario() {
        return this.inventario;
    }

}
