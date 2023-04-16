package fp.stackoverflow;

import fp.utiles.TiposCheckers;

// EN EL PAQUETE fp.stackoverflow SE IMPLEMENTA LO NECESARIO PARA REALIZAR EL PROYECTO

// ENTREGA 1: REQUISITOS:
// 1- DOS CONSTRUCTORES ==> StackOverflow(...)
// 2- UNA PROPIEDAD DERIVADA ==> diferenciasalario(...)
// 3- UNA REPRESENTACIÓN COMO CADENA ==> toString(...)
// 4- UN CRITERIO DE IGUALDAD ==> critIgual(...)
// 5- UN CRITERIO DE ORDEN NATURAL ==> ???
// 6- DOS RESTRICCIONES DE DATOS DE DIFERENTES TIPOS ==> posicionInvalida(...); nacionalidadInvalida(...)

// ENTREGA 2: REQUISITOS:
// 1- UNA FACTORÍA
//	1.1- Método 1: recibe una cadena con el formato de las líneas del fichero CSV y devuelve un objeto del tipo.
//	1.2- Método 2: recibe una cadena con el nombre y la ruta del fichero CSV y devuelve una lista de objetos del tipo.
// 2- TIPO CONTENEDOR:
// 	2.1- Requisito 1: mínimo una propiedad de tipo colección para almacenar los elementos del tipo base.
//	2.2- Reguisito 2: tener al menos dos constructores:
//		2.2.1- Constructor 1: recibe todas las propiedades básicas (exc. colección) y crea un tipo contenedor sin elementos en la colección.
//		2.2.2- Constructor 2: lo mismo que Const. 1 recibiendo además una colección y creando un tipo contenedor con todos sus elementos.
// 3- UN CRITERIO DE IGUALDAD
// 4- UNA REPRESENTACIÓN COMO CADENA
// 5- OPERACIONES AUXILIARES:
// 	5.1- OP1: obtener el número de elementos.
//	5.2- OP2: añadir un elemento.
// 	5.3- OP3: añadir una colección de elementos.
//	5.4- OP4: eliminar un elemento.
// 6- IMPLEMENTACIÓN DE BUCLES:
//	6.1- Opciones A1 / A2: bucle tipo existe / bucle tipo para todo.
//	6.2- Opciones B1 / B2 / B3: contador / suma / media.
//	6.3- Una selección con filtrado.
//	6.4- Un método de agrupación que devuelva un Map con claves tipo base y valores colección de objetos tipo base.
//	6.5- Un método de acumulación que devuelva un Map con claves tipo base y valores conteo o suma de objetos de un contenedor.

public class StackOverflow {

	private Integer posicion; // PRIMER VALOR DEL CSV
	private StatusProfesional statusprof; // SEGUNDO VALOR DEL CSV
	private String nacionalidad; // CUARTO VALOR DEL CSV
	private StatusEmpleo statusemp; // SEXTO VALOR DEL CSV
	private String estudiosuniversitarios; // QUINTO VALOR DEL CSV
	private Double salarioactual; // VALOR Nº 153 DEL CSV
	private Double salariodeseado; // VALOR Nº 154 DEL CSV
	private String volumenempresa; // DÉCIMO VALOR DEL CSV
	
	public Boolean formateaEstudiosUniversitarios() {
		Boolean res = true;
		if (getEstudiosuniversitarios() == "Yes") {
			res = false;
		}
		return res;
	}
	
	public StackOverflow(Integer posicion,StatusProfesional statusprof,String nacionalidad,StatusEmpleo statusemp,String estudiosuniversitarios, Double salarioactual, Double salariodeseado, String volumenempresa) {
		this.posicion = posicion;
		this.statusprof = statusprof;
		this.nacionalidad = nacionalidad;
		this.statusemp = statusemp;
		this.estudiosuniversitarios = estudiosuniversitarios;
		this.salarioactual = salarioactual;
		this.salariodeseado = salariodeseado;
		this.volumenempresa = volumenempresa;
	}
	
	public StackOverflow(Integer posicion,Double salarioactual,Double salariodeseado) {
		this.posicion = posicion;
		this.salarioactual = salarioactual;
		this.salariodeseado = salariodeseado;
	}
	
	public Double diferenciasalario() {
		Double diferencia = getSalariodeseado() - getSalarioactual();
		return diferencia;
	}
	
	public String toString() {
		return "Los datos del usuario son: " + getPosicion() + ", " + getStatusprof() + ", " + getNacionalidad() + ", " + getStatusemp() + ", " + getEstudiosuniversitarios() + ", " + getSalarioactual() + ", " + getSalariodeseado() + ", " + getVolumenempresa() + ".";
	}
	
	public Boolean critIgual(Object o) {
		Boolean res = false;
		if (o instanceof StackOverflow) {
			StackOverflow s = (StackOverflow) o;
			res = this.getPosicion().equals(s.getPosicion());
		}
		return res;
	}
	
	public void posicionInvalida(Integer posicion) {
		if (posicion < 0) {
			throw new IllegalArgumentException("La posición del usuario no puede ser negativa");
		}
	}
	
	// Excepción de posición implementada con Checkers:
	
	//public void posicionInvalida2(Integer posicion) {
		//TiposCheckers.check("La posición del usuario no puede ser negativa",posicion<0);
	//}
	
	public void nacionalidadInvalida(String nacionalidad) {
		if (nacionalidad == null) {
			throw new IllegalArgumentException("La nacionalidad del usuario no puede ser nula");
		}
	}
	
	// Excepción de nacionalidad implementada con Checkers:
	
	//public void nacionalidadInvalida2(String nacionalidad) {
		//TiposCheckers.check("La nacionalidad del usuario no puede ser nula", nacionalidad = null);
	//}
	
	public Integer getPosicion() {
		return posicion;
	}
	public void setPosicion(Integer posicion) {
		this.posicion = posicion;
	}
	public StatusProfesional getStatusprof() {
		return statusprof;
	}
	public void setStatusprof(StatusProfesional statusprof) {
		this.statusprof = statusprof;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public StatusEmpleo getStatusemp() {
		return statusemp;
	}
	public void setStatusemp(StatusEmpleo statusemp) {
		this.statusemp = statusemp;
	}
	public String getEstudiosuniversitarios() {
		return estudiosuniversitarios;
	}
	public void setEstudiosuniversitarios(String estudiosuniversitarios) {
		this.estudiosuniversitarios = estudiosuniversitarios;
	}
	public Double getSalarioactual() {
		return salarioactual;
	}
	public void setSalarioactual(Double salarioactual) {
		this.salarioactual = salarioactual;
	}
	public Double getSalariodeseado() {
		return salariodeseado;
	}
	public void setSalariodeseado(Double salariodeseado) {
		this.salariodeseado = salariodeseado;
	}
	public String getVolumenempresa() {
		return volumenempresa;
	}
	public void setVolumenempresa(String volumenempresa) {
		this.volumenempresa = volumenempresa;
	}
	
	
	
	
}
