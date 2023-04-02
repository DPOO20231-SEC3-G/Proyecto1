package uniandes.dpoo.p1.model;

public class AdministradorServicios {
	
	private String fichero = "./data/"; 
	
	private HashMap<String,Servicio> inventario;
	
	private HashMap<String,Servicio> menu;
	
	public void cargarServicios() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero+"Servicios.data"))) {
			this.inventario = (HashMap<String,Servicio>) ois.readObject();
		}
	}
	
	public void cargarMenuRestaurante() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero+"Restaurante.data"))) {
			this.inventario = (HashMap<String,Servicio>) ois.readObject();
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
	
	public void modificarDisponibilidadServicio (Servicio servicio, HashMap<String ,ArrayList<Time>> disponibilidad) {
		servicio.setDisponibilidad(disponibilidad);
	}

    public HashMap<String,Servicio> getInventario(){
        return this.inventario
    }
}
