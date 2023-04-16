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
			StackOverflow s = parseaStack(linea);
			res.añadirElemento(s);
		}
		return res;
	}
	
	// Método 1: (1.1) --> Retorna Objeto tipo StackOverflow
	
	private static StackOverflow parseaStack(String linea) {
		String[] trozos = linea.split(",");
		Integer posicion = Integer.parseInt(trozos[0].trim());
		StatusProfesional statusprof = StatusProfesional.valueOf(trozos[1].trim().replace(" ", "_").replace("-", "_").toUpperCase());
		String nacionalidad = trozos[3].trim();
		StatusEmpleo statusemp = StatusEmpleo.valueOf(trozos[5].trim().replace(" ", "_").replace("-", "_").replace(",", "_").toUpperCase());
		String estudiosuniversitarios = trozos[4].trim();
		Double salarioactual = Double.parseDouble(trozos[152].trim());
		Double salariodeseado = Double.parseDouble(trozos[153].trim());
		String volumenempresa = trozos[9].trim();
		return new StackOverflow(posicion,statusprof,nacionalidad,statusemp,estudiosuniversitarios,salarioactual,salariodeseado,volumenempresa);
	}
	
}
