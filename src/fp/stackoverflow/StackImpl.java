package fp.stackoverflow;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
}

