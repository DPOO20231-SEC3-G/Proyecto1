package uniandes.dpoo.p1.model;
import java.util.Date;
import java.util.HashMap;

public class Calendario {
	
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
}
