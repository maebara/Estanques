public class SistemaDeEstanques {
	
	private Estanque[] estanques;
	
	public SistemaDeEstanques(Estanque[] estanques) {
		this.estanques = estanques;
	}
	
	public double llenar(double agua) { //O(n^3)
		
		if(estanques.length == 1) {
			estanques[0].llenarTodo(agua);
			//return
		}
		
		int desde = 1;
		int hasta;
		int i = 1;
		Estanque es;
		int masBajo;
		
		while( agua > 0 && i < estanques.length) { //O(n) total = //O(n^3)
			
			es = estanques[i];
			masBajo = es.ca�oMasBajo();
			//O(1)
			
			if(masBajo == 0) {
				
				agua = es.llenarHastaCa�oIzquierdo(agua); //O(n)
				hasta = i;
				
				if(agua > 0 && estanques[desde].compCa�o(estanques[hasta]) >= 0) {//O(n) total = //O(n^2)
					
					//llenar  hasta ca�o izq
					agua = this.llenarConjuntoHastaIzq(desde, hasta, agua);//O(n)
					
					desde = encontrarProximoCa�oIzq(desde);
					while(agua > 0 && this.estanques[desde].compCa�o(this.estanques[hasta]) > 0){//O(n^2)
						agua = this.llenarConjuntoHastaIzq(desde, hasta, agua);//O(n)
						desde = encontrarProximoCa�oIzq(desde);
					}
					//llenar hasta ca�o der
					
					if(agua > 0) { //O(n)
						agua = this.llenarConjuntoHastaDer(desde, hasta, agua);
					}
				}else {//O(n)
					//llenar hasta ca�o der
					if(agua > 0) {
						agua = this.llenarConjuntoHastaDer(desde, hasta, agua);
					}
				}
					
			}else {//O(1)
				
				agua = es.llenarHastaCa�oDerecho(agua);
				
				if(!es.ca�osIguales()) {
					desde = i;
				}
			}
			
			i++;	
		}
		
		return agua;
		
	}
	
	private int encontrarProximoCa�oIzq(int e) {
		int j = e;
		while(j > 1 && (this.estanques[e].getCa�oDelAnterior() - this.estanques[j].getCa�oDelAnterior()) <= 0) {
			j--;
		}
		return j;
	}
	
	public double llenarConjuntoHastaDer(int desde, int hasta, double agua) { //O(n)
	
		double[] volumenes = new double[hasta - desde + 1];
		double h = this.estanques[hasta].getProfCa�o();
		
		int volTot = 0;
		int j = 0;
		for(int i = desde; i <= hasta; i++) { //O(n)
			volumenes[j] =  this.estanques[i].getArea() * h;
			volTot += volumenes[j];
			j++;
		}
	
		if(volTot > agua) {
			
			int areaTot = 0;
			
			for(int i = desde; i <= hasta; i++) {//O(n)
				areaTot += this.estanques[i].getArea();
			}
			
			for(int i = desde; i <= hasta; i++) {//O(n)
				estanques[i].llenar((agua/areaTot) * estanques[i].getArea());
			}
			
			
		}else {
			j = 0;
			for(int i = desde; i <= hasta; i++) {//O(n)
				this.estanques[i].llenar(volumenes[j]);
				j++;
			}
			
		}
		
	
		return (volTot > agua)? 0: agua - volTot;
	
	}

	public double llenarConjuntoHastaIzq(int desde, int hasta, double agua) {
		
		double[] volumenes = new double[hasta - desde + 1];
		System.out.println(volumenes.length);
		double h = this.estanques[desde].getHizq();
		int volTot = 0;
		
		int j = 0;
		for(int i = desde; i <= hasta; i++) {
			volumenes[j] = this.estanques[i].getArea() * h;
			volTot += volumenes[j];
			j++;
		}
		
		
		if(volTot > agua) {
			
			int areaTot = 0;
			
			for(int i = desde; i <= hasta; i++) {
				areaTot += this.estanques[i].getArea();
			}
			
			for(int i = desde; i <= hasta; i++) {
				estanques[i].llenar((agua/areaTot) * estanques[i].getArea());
			}
			
			
		}else {
			j = 0;
			for(int i = desde; i <= hasta; i++) {
				this.estanques[i].llenar(volumenes[j]);
				j++;
			}
			
		}
		
	
		return (volTot > agua)? 0: agua - volTot;	
	}
	
	public String toString() {
		String out = "";
		for(int i = 1; i < this.estanques.length; i++) {
			out += this.estanques[i] + "\n";
		}
		return out;
	}
	
} 
