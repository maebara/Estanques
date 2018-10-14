package edu.unlam.estanques;

import java.io.File;
import java.io.FileNotFoundException;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class ArchivoEstanques {
	
	public static void resolver(String path, String pathSalida) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new File(path));
		Estanque[] estanques = new Estanque[sc.nextInt()];
		
		int cañoAnt = 0;
		
		for(int i = 0; i < estanques.length - 1; i++) {
			int aux = cañoAnt;
			estanques[i] = new Estanque(sc.nextInt(), sc.nextInt(), (cañoAnt = sc.nextInt()), aux);	
		}
		
		estanques[estanques.length - 1] = new Estanque(sc.nextInt(), sc.nextInt(), 0, cañoAnt);	
		
		int agua = sc.nextInt();
		sc.close();
		
		SistemaDeEstanques se = new SistemaDeEstanques(estanques);
		double aguaRes = se.llenar(agua);
		System.out.println(se); // para ver todos los estanques
		PrintWriter file = new PrintWriter(pathSalida);
		
		if(aguaRes > 0) {
			file.print("Hay desborde: " + (int)aguaRes);
		}else {
			
			LinkedList<Integer> lista = se.estadoEstanques();
			
			
			int cant = lista.getFirst();
			file.println(cant);
			cant*=2;
			
			for(int i = 1; i < cant; i = i + 2) {
				file.print(lista.get(i) + " " + lista.get(i + 1) + System.lineSeparator());
			}
			
			
		}
		
		
		file.close();
		
	}
	
}
