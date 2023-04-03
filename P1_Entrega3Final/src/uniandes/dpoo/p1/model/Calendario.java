package uniandes.dpoo.p1.model;
import java.util.Date;
import java.util.HashMap;
import java.io.Serializable;
import java.util.Calendar;

public class Calendario implements Serializable {
	
	private HashMap<Date, Integer > tarifaEstandar = new HashMap<Date, Integer>();
	
	private HashMap<Date, Integer > tarifaSuit = new HashMap<Date, Integer>();
	
	private HashMap<Date, Integer > tarifaSuitDoble = new HashMap<Date, Integer>();
	
	public Calendario( HashMap< Date, Integer > nTarifaEstandar, HashMap< Date, Integer > nTarifaSuit, HashMap< Date, Integer > nTarifaSuitDoble){
		
		tarifaEstandar = nTarifaEstandar;
		
		tarifaSuit = nTarifaSuit;
		
		tarifaSuitDoble = nTarifaSuitDoble;
		
	}
	
	public HashMap<Date, Integer > getTarifaEstandar() {
		return tarifaEstandar;
	}

	public void setTarifaEstandar(HashMap<Date, Integer > tarifaEstandar) {
		this.tarifaEstandar = tarifaEstandar;
	}

	public HashMap<Date, Integer > getTarifaSuit() {
		return tarifaSuit;
	}

	public void setTarifaSuit(HashMap<Date, Integer > tarifaSuit) {
		this.tarifaSuit = tarifaSuit;
	}

	public HashMap<Date, Integer > getTarifaSuitDoble() {
		return tarifaSuitDoble;
	}

	public void setTarifaSuitDoble(HashMap<Date, Integer > tarifaSuitDoble) {
		this.tarifaSuitDoble = tarifaSuitDoble;
	}
	
	public String obtenerDiaSemana(Date fecha) {
	    Calendar calendario = Calendar.getInstance();
	    calendario.setTime(fecha);

	    int dia = calendario.get(Calendar.DAY_OF_WEEK);
	    switch (dia) {
	      case Calendar.SUNDAY:
	        return "domingo";
	      case Calendar.MONDAY:
	        return "lunes";
	      case Calendar.TUESDAY:
	        return "martes";
	      case Calendar.WEDNESDAY:
	        return "miercoles";
	      case Calendar.THURSDAY:
	        return "jueves";
	      case Calendar.FRIDAY:
	        return "viernes";
	      case Calendar.SATURDAY:
	        return "sabado";
	      default:
	        return "";
	    }
	}
	
}
