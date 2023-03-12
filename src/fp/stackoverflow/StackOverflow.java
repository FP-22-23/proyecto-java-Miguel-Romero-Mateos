package fp.stackoverflow;

// EN EL PAQUETE fp.stackoverflow SE IMPLEMENTA LO NECESARIO PARA REALIZAR EL PROYECTO

// ENTREGA 1: REQUISITOS:
// 1- DOS CONSTRUCTORES ==> StackOverflow(...)
// 2- UNA PROPIEDAD DERIVADA ==> diferenciasalario(...)
// 3- UNA REPRESENTACIÓN COMO CADENA ==> toString(...)
// 4- UN CRITERIO DE IGUALDAD ==> critIgual(...)
// 5- UN CRITERIO DE ORDEN NATURAL ==> ???
// 6- DOS RESTRICCIONES DE DATOS DE DIFERENTES TIPOS ==> posicionInvalida(...); nacionalidadInvalida(...)

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
	
	public void nacionalidadInvalida(String nacionalidad) {
		if (nacionalidad == null) {
			throw new IllegalArgumentException("La nacionalidad del usuario no puede ser nula");
		}
	}
	
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
