package fp.stackoverflow.test;

import fp.stackoverflow.*;


public class TestStackOverflow {

	public static void main(String[] args) {
		
		StackOverflow s1 = new StackOverflow(1, StatusProfesional.STUDENT, "Spain", StatusEmpleo.I_PREFER_NOT_TO_SAY, "Yes", null, null, null);
		System.out.println(s1.toString()); // Prueba Constructor 1 y toString()
		StackOverflow s2 = new StackOverflow(2, 1000.0, 3000.0);
		System.out.println(s2.toString()); // Prueba Constructor 2 y toString()
		System.out.println("La diferencia entre el salario deseado y el actual es; " + s2.diferenciasalario()); // Prueba propiedad derivada
		System.out.println("El criterio de igualdad para diferentes usuarios en dos constructores diferentes devuelve: " + s2.critIgual(s1)); // Prueba criterio igualdad
		
		// NOTA: para probar las excepciones, descomentar la última línea de uno de los dos bloques:
		
		StackOverflow s3 = new StackOverflow(-1, StatusProfesional.STUDENT, "Spain", StatusEmpleo.I_PREFER_NOT_TO_SAY, "Yes", null, null, null);
		Integer pos_s3 = s3.getPosicion();
		// s3.posicionInvalida(pos_s3); // Prueba excepción de posición
		
		StackOverflow s4 = new StackOverflow(1, StatusProfesional.STUDENT, null, StatusEmpleo.I_PREFER_NOT_TO_SAY, "Yes", null, null, null);
		String nac_s4 = s4.getNacionalidad();
		// s4.nacionalidadInvalida(nac_s4); // Prueba excepción de nacionalidad
		
	}

}
