
public class Estanque {
	
	private int profundidad;
	private int areaSup;
	private int capacidad;
	private double volumenLleno = 0;
	private int profCaño;
	private Estanque anterior;
	
	public Estanque(int profundidad, int areaSup, int profCaño, Estanque anterior) {
		this.profundidad = profundidad;
		this.areaSup = areaSup;
		this.capacidad = profundidad * areaSup;
		this.profCaño = profCaño;
		this.anterior = anterior;
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
		if(this.profCaño < this.anterior.profCaño) {
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
		return (this.capacidad - volumenLleno)/this.areaSup - this.anterior.profCaño;
	}
	
	public double llenarHastaCañoIzquierdo(double agua) {
		int volumenHastaCaño = (this.profundidad - this.anterior.profCaño) * this.areaSup;
		double aLlenar = (agua > volumenHastaCaño)? volumenHastaCaño:agua;
		volumenLleno = aLlenar;
		return (int) (agua - volumenLleno);
	}

	
	public String toString() {
		return this.volumenLleno + " de  " + capacidad + " con h desde la base = " + (this.profundidad - (this.capacidad - volumenLleno)/this.areaSup) + " h tope = " + (this.capacidad - volumenLleno)/this.areaSup;
	}
	
	public int getCañoDelAnterior() {
		return this.anterior.profCaño;
	}
	
	public int compCaño(Estanque es) {
		return this.anterior.profCaño - es.profCaño;
	}
	
	public boolean cañosIguales() {
		return this.profCaño == anterior.profCaño;
	}

	public int getArea() {
		return this.areaSup;
	}

	
	
}
