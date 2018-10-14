package edu.unlam.estanques;

public class Estanque {
	
	private int profundidad;
	private int areaSup;
	private int capacidad;
	private double volumenLleno = 0;
	private int profCaño;
	private int profCañoAnterior;
	
	public Estanque( int areaSup, int profundidad, int profCaño, int profCañoAnterior) {
		this.profundidad = profundidad;
		this.areaSup = areaSup;
		this.capacidad = profundidad * areaSup;
		this.profCaño = profCaño;
		this.profCañoAnterior = profCañoAnterior;
	}
	
	public double llenarHastaCañoDerecho(double agua) {
		
		int volumenHastaCaño = (profundidad - profCaño) * areaSup;
		double aLlenar = (agua > volumenHastaCaño)? volumenHastaCaño:agua;
		
		volumenLleno = aLlenar;
		agua -= volumenLleno;
				
		return agua;
	}
	
	public double llenar(double agua) {
		if(agua > (this.capacidad - volumenLleno)) {
			this.volumenLleno = capacidad;
			return agua - (this.capacidad - volumenLleno);
		}else {	
			this.volumenLleno += agua;
			return 0;
		}
	}

	public double llenarHastaCañoIzquierdo(double agua) {
		int volumenHastaCaño = (this.profundidad - this.profCañoAnterior) * this.areaSup;
		double aLlenar = (agua > volumenHastaCaño)? volumenHastaCaño:agua;
		volumenLleno = aLlenar;
		return (int) (agua - volumenLleno);
	}
	
	public String toString() {
		return this.volumenLleno + " de  " + capacidad + " con h desde la base = " + (this.profundidad - (this.capacidad - volumenLleno)/this.areaSup) + " , h truncado : " + this.calcularHdesdeBase() +  ",  h tope = " + (this.capacidad - volumenLleno)/this.areaSup;
	}
	
	
	public int calcularHdesdeBase() {
		double h = (this.profundidad - (this.capacidad - volumenLleno)/this.areaSup);

		return (int)h ;
	}
	
	public double getHizq() {
		return (this.capacidad - volumenLleno)/this.areaSup - this.profCañoAnterior;
	}

	public double getProfCaño() {
		return (this.capacidad - volumenLleno)/this.areaSup - this.profCaño;
	}
	
	public int getCañoDelAnterior() {
		return this.profCañoAnterior;
	}

	public int getCaño() {
		return this.profCaño;
	}
	
	public int getArea() {
		return this.areaSup;
	}
	
	public int compCaño(Estanque es) {
		return this.profCañoAnterior - es.profCaño;
	}
	
	public boolean cañosIguales() {
		return this.profCaño == this.profCañoAnterior;
	}

	public boolean cañoDerechoEsMasBajo() {
		return this.profCaño < this.profCañoAnterior;
	}

	
	
	
	
	
	
}
