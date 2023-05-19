package fp.stackoverflow;
import java.util.List;
import java.util.Map;

// Interfaz de StackImpl --> Consultar "StackImpl" para apartados 2 a 6

public interface Stack {
	List<StackOverflow> getStack();
	Integer getNumeroElementos();
	void añadirElemento(StackOverflow s);
	void añadeColeccion(List<StackOverflow> datos);
	void eliminarElemento(StackOverflow s);
	Boolean existeSalarioDeseado(Double salariodeseado);
	Double mediaSalarioDeseado();
	Integer numeroPersonasMenosSalarioDeseado(Double salariodeseado);
	Map<String,List<StackOverflow>> agrupaNacionalidad();
	Map<String,Double> agrupaNacionalidadSumaSalarioDeseado();
	Boolean existeSalarioDeseadoStreams(Double salariodeseado);
	Double mediaSalarioDeseadoStreams();
	List<StackOverflow> numeroPersonasMenosSalarioDeseadoStreams(Double salariodeseado);
	Double minimoSalarioDeseado(Double salariodeseado);
	List<Double> personasEstudiosSalarioActualMayorMenor(Double salarioactual);
	Long getNumeroElementosStreams();
	Map<String,Double> getMediaSalarioDeseadoNacionalidad(String nacionalidad);
	Map<StatusProfesional,Double> getMaximoSalarioEstatusProfesional();
	Map<StatusProfesional, List<Object>> getNSalariosDeseadosBajosEstatusProfesional(Integer n);
	Integer getPosicionSalarioDeseadoMasBajo();
}
