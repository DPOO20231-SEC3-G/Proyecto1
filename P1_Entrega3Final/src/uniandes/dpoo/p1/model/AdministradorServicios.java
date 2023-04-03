package uniandes.dpoo.p1.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;


public class AdministradorServicios {
	
	private String fichero = "./data/"; 
	
	private HashMap<String,Servicio> inventario;
	
	private HashMap<String,Servicio> menu;
	
	public void cargarServicios() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero+"Servicios.dat"))) {
			this.inventario = (HashMap<String,Servicio>) ois.readObject();
		}
	}
	public void guardarServicios() throws FileNotFoundException, IOException {
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Servicios.dat"))) {
			oos.writeObject(this.inventario);
		}
		
	}
	public void cargarMenuRestaurante() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero+"Restaurante.dat"))) {
			this.menu = (HashMap<String,Servicio>) ois.readObject();
		}
	}
	
	public void guardarMenuRestaurante() throws FileNotFoundException, IOException {
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Restaurante.dat"))) {
			oos.writeObject(this.menu);
		}
		
	}

	public void modificarDescripcionServicio(Servicio servicio, String descripcion) {
		servicio.setDescripcion(descripcion);
	}
	
	public void modificarPrecioServicio(Servicio servicio, Integer precio) {
		servicio.setPrecio(precio);
	}
	
	public void modificarNombreServicio (Servicio servicio, String nombre) {
		servicio.setNombre(nombre);
	}
	
	public void modificarCGrupalServicio (Servicio servicio, boolean bool) {
		servicio.setCobroGrupal(bool);
	}

    public HashMap<String,Servicio> getInventario() {
        return this.inventario;
    }

	public HashMap<String,Servicio> getMenu() {
		return this.menu;
	}
}
