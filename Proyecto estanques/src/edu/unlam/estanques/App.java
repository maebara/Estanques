package edu.unlam.estanques;
import java.io.FileNotFoundException;

public class App {
	
	public static void main(String[] args) throws FileNotFoundException {
	
		ArchivoEstanques.resolver("archivo.txt", "res.txt");
	
	}
}
