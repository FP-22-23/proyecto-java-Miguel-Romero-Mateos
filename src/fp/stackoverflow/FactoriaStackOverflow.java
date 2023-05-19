package fp.stackoverflow;

import java.util.List;
import fp.utiles.Ficheros;
import fp.utiles.TiposCheckers;

// FACTORÍA: (1)

public class FactoriaStackOverflow {
	
	// Método 2: (1.2) --> Retorna Lista tipo Stack
	
	public static Stack leerStack(String fichero) {
		Stack res = new StackImpl();
		TiposCheckers.checkNoNull(fichero);
		List<String> lineas = Ficheros.leeFichero("Error de lectura", fichero);
		lineas.remove(0);
		for (String linea:lineas) {
			try {
				StackOverflow s = parseaStack(linea);
				res.añadirElemento(s);
			}
			catch (Exception e) {
			}
		}
		return res;
	}

    
	// Método 1: (1.1) --> Retorna Objeto tipo StackOverflow

	private static StackOverflow parseaStack(String linea) {
		String[] trozos = linea.split(",");
		Integer posicion = Integer.parseInt(trozos[0].trim());
		StatusProfesional statusprof = StatusProfesional.valueOf(trozos[1].trim().replace("-", "_").replace("\"", "").replaceAll("^\"|\"$", "").replace(";", "").replace(" ", "_").toUpperCase());
		String nacionalidad = trozos[3].trim();
		StatusEmpleo statusemp = StatusEmpleo.valueOf(trozos[5].trim().replace("-", "_").replace("\"", "").replaceAll("^\"|\"$", "").replace(";", "").replace(" ", "_").toUpperCase());
		String estudiosuniversitarios = trozos[4].trim();
		String salarioactualaux = trozos[152].trim().replace("-", "_").replace("\"", "").replaceAll("^\"|\"$", "").replace(";", "").replace(" ", "_").toUpperCase();
		Double salarioactual = 0.0;
		if (salarioactualaux != "NA") {
			salarioactual = 0.0;
		}
		else{
			salarioactual = 0.0;
		}
		String salariodeseadoaux = trozos[153].trim().replace("-", "_").replace("\"", "").replaceAll("^\"|\"$", "").replace(";", "").replace(" ", "_").toUpperCase();
		Double salariodeseado = 0.0;
		if (salariodeseadoaux != "NA") {
			salariodeseado = 10000.0;
		}
		else{
			salariodeseado = 0.0;
		}
		String volumenempresa = trozos[9].trim();
		return new StackOverflow(posicion,statusprof,nacionalidad,statusemp,estudiosuniversitarios,salarioactual,salariodeseado,volumenempresa);
	}
	
	// Método 3: (2C) --> Retorna Contenedor creado con 1C
	
	public static Stack StackFichero(String fichero) {
		String error = "Error de lectura";
		List<StackOverflow> stack = Ficheros.leeFichero(error, fichero,x->parseaStack(x));
		return new StackImpl(stack);
		}
	
}
