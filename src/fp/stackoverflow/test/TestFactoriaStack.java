package fp.stackoverflow.test;

import fp.stackoverflow.*;

public class TestFactoriaStack {

	public static void main(String[] args) {
		lecturaDatos("data/output copy.csv");
	}

	private static void lecturaDatos(String fichero) { // Test simple de lectura
		System.out.println("\nTest Lectura Fichero:\n");
		Stack data = FactoriaStackOverflow.leerStack(fichero);
		System.out.println("\nOutput:\n");
		data.getStack().stream().forEach(System.out::println);
	}
}
