
public class pruebas {
	
	public static void main(String[] args) {
		/*
		Estanque e0 = null;
		Estanque e1 = null;  
		Estanque e2 = null; 
		Estanque e3 = null;
		
		e0 = new Estanque(0,0,0,e1,null);
		e1 = new Estanque(10, 10, 3, e2, e0);
		e2 = new Estanque(10, 40, 4, e3, e1);
		e3 = new Estanque(10, 25, 3, null, e2);
		
		Estanque[] estanques = {e0,e1,e2,e3};
		SistemaDeEstanques se = new SistemaDeEstanques(estanques);
		*/
		/*
		int agua = 150;
		int areaTot = e1.getArea() + e2.getArea() + e3.getArea();
		int agua1 = (agua/areaTot) * e1.getArea();
		int agua2 = (agua/areaTot) * e2.getArea();
		int agua3 = (agua/areaTot) * e3.getArea();
		e1.llenar(agua1);
		e2.llenar(agua2);
		e3.llenar(agua3);
		System.out.println(e1);
		System.out.println(e2);
		System.out.println(e3);
		
		int agua = 150;
		int areaTot = e1.getArea() + e2.getArea() + e3.getArea();
		int agua1 = (agua/areaTot) * e1.getArea();
		int agua2 = (agua/areaTot) * e2.getArea();
		int agua3 = (agua/areaTot) * e3.getArea();
		e1.llenar(agua1);
		e2.llenar(agua2);
		e3.llenar(agua3);
		System.out.println(e1);
		System.out.println(e2);
		System.out.println(e3);
		int res =se.llenarConjuntoHastaDer(1, 3, 100);
		System.out.println(e1);
		System.out.println(e2);
		System.out.println(e3);
		System.out.println(res);
	*/

		Estanque e1 = null;  
		Estanque e2 = null;
		Estanque e3 = null;  
		Estanque e4 = null;
		Estanque e5 = null;
		Estanque e6 = null;  
		Estanque e7 = null;
		Estanque e8 = null;  
		Estanque e9 = null;

		e1 = new Estanque(9, 70, 3, 0);
		e2 = new Estanque(7, 50, 5, 3);
		e3 = new Estanque(7, 80, 5, 5);
		e4 = new Estanque(6, 60, 2, 5);
		e5 = new Estanque(10, 50, 7, 2);
		e6 = new Estanque(9, 30, 8, 7);
		e7 = new Estanque(12, 40, 8, 8);
		e8 = new Estanque(11, 70, 3, 8);
		e9 = new Estanque(9, 60, 0, 3);
		
		Estanque[] estanques = {e1,e2,e3,e4,e5,e6,e7,e8,e9};
		SistemaDeEstanques se = new SistemaDeEstanques(estanques);
		//con 2070 no da con el de mariano
		System.out.println((se.llenar(2070 + 190 + 190 + 190 + 190 + 360 + 250 + 510)));
		System.out.println(se);
		
		
	}
}
