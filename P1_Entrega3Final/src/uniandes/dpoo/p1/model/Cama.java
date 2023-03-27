package uniandes.dpoo.p1.model;

import java.io.Serializable;

public class Cama implements Serializable{
	
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
	
	public String toString() {
		String paraNiños = "No";
		if (usoNinos == true) {
			paraNiños = "Si";
		}
		
		return "Ancho = $f\nAlto = $f\nCapacidad = $d\nApta para niños = $s".formatted(this.ancho,this.alto,this.numPersonas,paraNiños);
	}
}

