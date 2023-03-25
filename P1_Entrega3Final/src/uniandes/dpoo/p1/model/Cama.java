package uniandes.dpoo.p1.model;

public class Cama {
	
	private double ancho;
	
	private double alto;
	
	private int numPersonas;
	
	private boolean usoNinos;
	
	public Cama(double nAncho, double nAlto, int nNumPersonas, boolean nUsoNinos) {
		
		ancho = nAncho;
		
		alto = nAlto;
		
		numPersonas = nNumPersonas;
		
		usoNinos = nUsoNinos;
	}
	
	public double[] getMedidas() {
		
		double medidas[] = {this.ancho,this.alto};
		
		return medidas;
	}
	
	public int getNumPersonas() {
		
		return this.numPersonas;
	}
	
	public boolean getUsoNinos() {
		return this.usoNinos;
	}
}

