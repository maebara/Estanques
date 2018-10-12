
public class Estanque {
	
	private int profundidad;
	private int areaSup;
	private int capacidad;
	private double volumenLleno = 0;
	private int profCaño;
	private int profCañoAnterior;
	
	public Estanque(int profundidad, int areaSup, int profCaño, int profCañoAnterior) {
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
	
	public double llenarTodo(double agua) {
		this.volumenLleno = capacidad;
		return agua - capacidad;
	}
	
	public int cañoMasBajo() {
		if(this.profCaño < this.profCañoAnterior) {
			return 0;
		}else {
			return 1;
		}
	}
	public int getCaño() {
		return this.profCaño;
	}
	
	public double getProfCaño() {
		return (this.capacidad - volumenLleno)/this.areaSup - this.profCaño;
	}
	
	
	public double getHizq() {
		return (this.capacidad - volumenLleno)/this.areaSup - this.profCañoAnterior;
	}
	
	public double llenarHastaCañoIzquierdo(double agua) {
		int volumenHastaCaño = (this.profundidad - this.profCañoAnterior) * this.areaSup;
		double aLlenar = (agua > volumenHastaCaño)? volumenHastaCaño:agua;
		volumenLleno = aLlenar;
		return (int) (agua - volumenLleno);
	}

	
	public String toString() {
		return this.volumenLleno + " de  " + capacidad + " con h desde la base = " + (this.profundidad - (this.capacidad - volumenLleno)/this.areaSup) + " h tope = " + (this.capacidad - volumenLleno)/this.areaSup;
	}
	
	public int getCañoDelAnterior() {
		return this.profCañoAnterior;
	}
	
	public int compCaño(Estanque es) {
		return this.profCañoAnterior - es.profCaño;
	}
	
	public boolean cañosIguales() {
		return this.profCaño == this.profCañoAnterior;
	}

	public int getArea() {
		return this.areaSup;
	}

	
	
}
