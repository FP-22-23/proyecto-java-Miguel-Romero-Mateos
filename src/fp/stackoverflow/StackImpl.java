package fp.stackoverflow;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class StackImpl implements Stack {
	
	// Propiedad tipo Colección: (2.1)
	
	private List<StackOverflow> datos;
	
	// Tipo Contenedor sin datos de la colección: (2.2.1)
	
	public StackImpl() {
		datos = new ArrayList<StackOverflow>();
	}
	
	// Tipo Contenedor con datos de la colección: (2.2.2)
	
	public StackImpl(Collection<StackOverflow> coleccion) {
		this.datos = new ArrayList<StackOverflow>(coleccion);
	}
	
	public List<StackOverflow> getStack(){
		return new ArrayList<StackOverflow>(datos);
	}
	
	// Contenedor Stream con todas las propiedades básicas: (1C)
		
	public StackImpl(Stream<StackOverflow> datos) {
		this.datos = datos.collect(Collectors.toList());
	}
	
	// Número de elementos: (5.1)
	
	public Integer getNumeroElementos() {
		return datos.size();
	}
	
	// Añadir un elemento: (5.2)
	
	public void añadirElemento(StackOverflow s) {
		if (!datos.contains(s)) {
			datos.add(s);
		}
	}
	
	// Añadir una Colección de elementos: (5.3)
	
	public void añadeColeccion(List<StackOverflow> datos) {
		this.datos.addAll(datos);
	}
	
	public void eliminarElemento(StackOverflow s) {
		if(!datos.contains(s)) {
			throw new IllegalArgumentException("Este dato no está registrado");
		}
		else {
			datos.remove(s);
		}
	}
	
	// Bucle tipo Existe: (6.1)
	
	public Boolean existeSalarioDeseado(Double salariodeseado) {
		Boolean res = false;
		for (StackOverflow s :datos) {
			if (s.getSalariodeseado() == salariodeseado) {
				res = true;
			}
		}
		return res;
	}
	
	// Bucle tipo Media: (6.2)
	
	public Double mediaSalarioDeseado() {
		Double res = 0.0;
		for (StackOverflow s :datos) {
			res += s.getSalariodeseado();
		}
		return res/getNumeroElementos();
	}
	
	// Bucle tipo Filtrado: (6.3)
	
	public Integer numeroPersonasMenosSalarioDeseado(Double salariodeseado) {
		Integer res = 0;
		for (StackOverflow s :datos) {
			if (s.getSalariodeseado() < salariodeseado) {
				res += 1;
			}
		}
		return res;
	}
	
	// Bucle con Map: (6.4)
	
	public Map<String,List<StackOverflow>> agrupaNacionalidad(){
		Map<String,List<StackOverflow>> res = new HashMap<String,List<StackOverflow>>();
		for (StackOverflow s :datos) {
			String clave = s.getNacionalidad();
			if (res.containsKey(clave)) {
				res.get(clave).add(s);
			}
			else {
				List<StackOverflow> lista = new ArrayList<StackOverflow>();
				lista.add(s);
				res.put(clave, lista);
			}
		}
		return res;
	}
	
	// Bucle con Map y suma: (6.5)
	
	public Map<String,Double> agrupaNacionalidadSumaSalarioDeseado(){
		Map<String,Double> res = new HashMap<String,Double>();
		for (StackOverflow s :datos) {
			String clave = s.getNacionalidad();
			if (res.containsKey(clave)) {
				res.put(clave, (res.get(clave) + s.getSalariodeseado()));
			}
			else {
				res.put(clave, s.getSalariodeseado());
			}
			}
		return res;
		}
	
	// Criterio de igualdad: (3)
	
	public int hashCode() {
		return Objects.hash(datos);
	}
	public boolean equals(Object objeto) {
		if (this == objeto) {
			return true;
		}
		if (objeto == null) {
			return false;
		}
		if (getClass() != objeto.getClass()) {
			return false;
		}
		StackImpl other = (StackImpl) objeto;
		return Objects.equals(datos, other.datos);
	}
	
	// Representación como cadena: (4)
	
	public String toString() {
		return "El número total de registros es:" + getNumeroElementos();
	}
	
	// IMPLEMENTACIÓN STREAMS (BLOQUE I): (3C,4C)
	
	// Método tipo Existe Streams: (4.1C)
	
	public Boolean existeSalarioDeseadoStreams(Double salariodeseado) {
		return datos.stream().anyMatch(x->x.getSalariodeseado().equals(salariodeseado));
	}
	
	// Método tipo Media Streams: (4.2C)
	
	public Double mediaSalarioDeseadoStreams() {
		return datos.stream().collect(Collectors.averagingDouble(StackOverflow::getSalariodeseado));
	}
	
	// Método tipo Filtrado Streams: (4.3C)
	
	public List<StackOverflow> numeroPersonasMenosSalarioDeseadoStreams(Double salariodeseado) {
		return datos.stream().filter(x->x.getSalariodeseado().equals(salariodeseado)).collect(Collectors.toList());
	}
	
	// Método tipo Mínimo: (4.4C)
	
	public Double minimoSalarioDeseado(Double salariodeseado) {
		return datos.stream().max(Comparator.comparing(datos->datos.getSalariodeseado())).map(StackOverflow::getSalariodeseado).orElse(null);
	}
	
	// Método tipo Selección: (4.5C)
	
	public List<Double> personasEstudiosSalarioActualMayorMenor(Double salarioactual){
		return datos.stream().filter(datos->datos.formateaEstudiosUniversitarios().equals(true)).sorted(Comparator.comparing(StackOverflow::getSalarioactual)).map(StackOverflow::getSalarioactual).collect(Collectors.toList());
	}
	
	// IMPLEMENTACIÓN STREAMS (BLOQUE II): (5C)
	
	// Método tipo Número de elementos: (5.1C)
	
	public Long getNumeroElementosStreams() {
		return datos.stream().count();
	}
	
	// Método collectingAndThen: (5.2C)
	
	public Map<String,Double> getMediaSalarioDeseadoNacionalidad(String nacionalidad){
		return datos.stream().filter(x->x.getNacionalidad().equals(nacionalidad)).collect(Collectors.groupingBy(StackOverflow::getNacionalidad,Collectors.collectingAndThen(Collectors.averagingDouble(x->x.getSalariodeseado()),Double::valueOf)));
	}
	
	// Método Map con máximo: (5.3C)
	
	public Map<StatusProfesional,Double> getMaximoSalarioEstatusProfesional(){
		return datos.stream().collect(Collectors.groupingBy(StackOverflow::getStatusprof,Collectors.collectingAndThen(Collectors.toList(),lista->parseamax(lista))));
	}

	private Double parseamax(List<StackOverflow> lista) { // Esta es una función de parseo auxiliar al método anterior
		return lista.stream().max(Comparator.comparing(StackOverflow::getSalarioactual)).get().getSalarioactual();
	}
	
	// Método SortedMap con atributos y listas con n peores elementos: (5.4C)
	
	public SortedMap<StatusProfesional, List<Object>> getNSalariosDeseadosBajosEstatusProfesional(Integer n){
		return datos.stream().collect(Collectors.groupingBy(StackOverflow::getStatusprof,TreeMap::new,Collectors.mapping(x->x.getSalariodeseado(),Collectors.toList())));
	}
	
	// Método Clave con Valor mínimo: (5.5C)
	
	public Integer getPosicionSalarioDeseadoMasBajo() {
		Map<Integer,Double> m = datos.stream().collect(Collectors.toMap(StackOverflow::getPosicion, StackOverflow::getSalariodeseado, (sal1,sal2)->Math.min(sal1,sal2)));
		return m.entrySet().stream().min(Map.Entry.comparingByValue()).map(Map.Entry::getKey).get();
	}
	
}

