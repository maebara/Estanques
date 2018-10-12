
public class Estanque {
	
	private int profundidad;
	private int areaSup;
	private int capacidad;
	private double volumenLleno = 0;
	private int profCa�o;
	private int profCa�oAnterior;
	
	public Estanque(int profundidad, int areaSup, int profCa�o, int profCa�oAnterior) {
		this.profundidad = profundidad;
		this.areaSup = areaSup;
		this.capacidad = profundidad * areaSup;
		this.profCa�o = profCa�o;
		this.profCa�oAnterior = profCa�oAnterior;
	}
	
	public double llenarHastaCa�oDerecho(double agua) {
		
		int volumenHastaCa�o = (profundidad - profCa�o) * areaSup;
		double aLlenar = (agua > volumenHastaCa�o)? volumenHastaCa�o:agua;
		
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
	
	public int ca�oMasBajo() {
		if(this.profCa�o < this.profCa�oAnterior) {
			return 0;
		}else {
			return 1;
		}
	}
	public int getCa�o() {
		return this.profCa�o;
	}
	
	public double getProfCa�o() {
		return (this.capacidad - volumenLleno)/this.areaSup - this.profCa�o;
	}
	
	
	public double getHizq() {
		return (this.capacidad - volumenLleno)/this.areaSup - this.profCa�oAnterior;
	}
	
	public double llenarHastaCa�oIzquierdo(double agua) {
		int volumenHastaCa�o = (this.profundidad - this.profCa�oAnterior) * this.areaSup;
		double aLlenar = (agua > volumenHastaCa�o)? volumenHastaCa�o:agua;
		volumenLleno = aLlenar;
		return (int) (agua - volumenLleno);
	}

	
	public String toString() {
		return this.volumenLleno + " de  " + capacidad + " con h desde la base = " + (this.profundidad - (this.capacidad - volumenLleno)/this.areaSup) + " h tope = " + (this.capacidad - volumenLleno)/this.areaSup;
	}
	
	public int getCa�oDelAnterior() {
		return this.profCa�oAnterior;
	}
	
	public int compCa�o(Estanque es) {
		return this.profCa�oAnterior - es.profCa�o;
	}
	
	public boolean ca�osIguales() {
		return this.profCa�o == this.profCa�oAnterior;
	}

	public int getArea() {
		return this.areaSup;
	}

	
	
}
