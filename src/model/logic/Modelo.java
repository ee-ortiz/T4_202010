package model.logic;

import java.util.Comparator;

import model.data_structures.ArregloDinamico;
import model.data_structures.Comparendo;
import model.data_structures.IArregloDinamico;
import model.data_structures.MaxColaCP;
import model.data_structures.MaxHeapCP;
import model.data_structures.Comparendo.ComparadorXLatitud;
/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {
	/**
	 * Atributos del modelo del mundo
	 */
	private MaxHeapCP<Comparendo> comps1;
	private MaxColaCP<Comparendo> comps2;
	private GeoJSONProcessing objetoJsonGson;


	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo()
	{
		comps1 = new MaxHeapCP();
		comps2 = new MaxColaCP();
		objetoJsonGson = new GeoJSONProcessing();
	}

	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamanoHeap()
	{
		return comps1.darTamano();
	}

	public int darTamanoCola(){

		return comps2.darTamano();
	}


	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return dato encontrado
	 */
	public Comparendo buscarHeap(Comparendo dato)
	{
		return comps1.buscar(dato);
	}

	public Comparendo buscarCola(Comparendo dato)
	{
		return comps2.buscar(dato);
	}


	/**
	 * Requerimiento eliminar dato
	 * @param dato Dato a eliminar
	 * @return dato eliminado
	 */
	public String eliminar(String dato)
	{
		return null;
	}

	public Comparendo darElementoHeap(int numero){
		return comps1.darElemento(numero);

	}

	public Comparendo darElementoCola(int numero){
		return comps2.darElemento(numero);

	}

	public void cargar(String direccion){

		objetoJsonGson.cargarDatos(comps1, comps2, direccion);
	}

	public MaxHeapCP<Comparendo> darArregloHeap(){

		return comps1;
	}

	public MaxColaCP<Comparendo> darArregloCola(){

		return comps2;
	}

	public String RetornarDatos(Comparendo comp){
		//INFRACCION, OBJECTID,
		//FECHA_HORA, CLASE_VEHI, TIPO_SERVI, LOCALIDAD.
		String rta = "Codigo de infraccion: "+comp.INFRACCION +" ObjectID: " + comp.OBJECTID + " Fecha y hora: " + comp.FECHA_HORA + " Clase de vehiculo "+comp.CLASE_VEHI + " Tipo de servicio: " +
				comp.TIPO_SERVI + " Localidad: "+ comp.LOCALIDAD + "Municipio: " + comp.MUNICIPIO;
		return rta;
	}

	public String retornarDatosTaller4(Comparendo comp){
		String rta ="ObjectID: " + comp.OBJECTID + " Clase de vehiculo "+comp.CLASE_VEHI + " Latitud: "+ comp.latitud + " Longitud: " + comp.longitud;
		return rta;

	}

	public static Comparendo cambiarDeComparableAComparendo(Comparable a){

		Comparendo rta = (Comparendo) a;
		return rta;
	}

	//aqui inicia la implementacion del heapsort

	/**
	 * Rearranges the array in ascending order, using the natural order.
	 * @param pq the array to be sorted
	 */
	public static void sort(Comparable[] pq, Comparator<Comparendo> comparador)	 {
		int n = pq.length;

		// heapify phase
		for (int k = n/2; k >= 1; k--)
			sink(pq, k, n,comparador);

		// sortdown phase
		int k = n;
		while (k > 1) {
			exch(pq, 1, k--);
			sink(pq, 1, k,comparador);
		}
	}

	/***************************************************************************
	 * Helper functions to restore the heap invariant.
	 ***************************************************************************/

	private static void sink(Comparable[] pq, int k, int n, Comparator<Comparendo> comparador) {
		while (2*k <= n) {
			int j = 2*k;
			if (j < n && less(pq, j, j+1, comparador)) j++;
			if (!less(pq, k, j, comparador)) break;
			exch(pq, k, j);
			k = j;
		}
	}

	/***************************************************************************
	 * Helper functions for comparisons and swaps.
	 * Indices are "off-by-one" to support 1-based indexing.
	 ***************************************************************************/
	private static boolean less(Comparable[] pq, int i, int j, Comparator<Comparendo> comparador) {

		return comparador.compare(cambiarDeComparableAComparendo(pq[i-1]), cambiarDeComparableAComparendo(pq[j-1])) < 0;
	}

	private static void exch(Object[] pq, int i, int j) {
		Object swap = pq[i-1];
		pq[i-1] = pq[j-1];
		pq[j-1] = swap;
	}
	//aqui acaba

	/**
	 *Mostrar los N comparendos que ocurrieron más al norte (basada en la
	 *latitud) y que involucraron un tipo de vehículo que está incluido en una lista (con una
	 *MaxColaCP).
	 */
	public Comparable[] requerimiento1 (String pVehi )
	{
		int i = 0;
		String[] vehiculos= pVehi.split(",");
		MaxColaCP<Comparendo> arregloTemp = new MaxColaCP<Comparendo>();
		ComparadorXLatitud b = new ComparadorXLatitud();

		while(i<comps2.darTamano()){
			int s=0;
			boolean tipoEncontrado=false;
			while(s<vehiculos.length)
			{

				if(comps2.darElemento(i) != null && comps2.darElemento(i).CLASE_VEHI.compareTo(vehiculos[s])==0 &&tipoEncontrado==false){

					arregloTemp.agregar(comps2.darElemento(i));
					tipoEncontrado=true;
				}
				s++;
			}

			i++;
		}
		Comparable [] a = copiarArregloC(arregloTemp);
		sort(a, b );
		return a;


	}


	/**
	 * Mostrar los N comparendos que ocurrieron más al norte (basada en la 
	 * latitud) y que involucraron un tipo de vehículo que está incluido en una lista (con una 
	 * MaxHeapCP). 
	 */
	public Comparable[] requerimiento2 (String pVehi)
	{
		int i = 0;
		String[] vehiculos= pVehi.split(",");
		MaxHeapCP<Comparendo> arregloTemp = new MaxHeapCP<Comparendo>();
		ComparadorXLatitud b = new ComparadorXLatitud();
		while(i<comps1.darTamano()){
			int s=0;
			boolean tipoEncontrado=false;
			while(s<vehiculos.length)
			{
				if(comps1.darElemento(i).CLASE_VEHI.compareTo(vehiculos[s])==0&&tipoEncontrado==false){

					arregloTemp.agregar(comps1.darElemento(i));
					tipoEncontrado=true;
				}
				s++;
			}

			i++;
		}
		Comparable [] a = copiarArregloH(arregloTemp);
		sort(a, b );
		return a;


	}
	public Comparable[] copiarArregloHeap(){

		Comparable[] rta = new Comparable[comps1.darTamano()];
		int i = 0;
		while(i < comps1.darTamano()){
			rta[i] = comps1.darElemento(i);
			i++;
		}


		return rta;
	}


	public Comparable[] copiarArregloCola(){

		Comparable[] rta = new Comparable[comps2.darTamano()];
		int i = 0;
		while(i < comps2.darTamano()){
			rta[i] = comps2.darElemento(i);
			i++;
		}


		return rta;
	}

	public Comparable[] copiarArregloH( MaxHeapCP<Comparendo>  pComps){

		Comparable[] rta = new Comparable[pComps.darTamano()];
		int i = 0;
		while(i < pComps.darTamano()){
			rta[i] = pComps.darElemento(i);
			i++;
		}


		return rta;
	}


	public Comparable[] copiarArregloC( MaxColaCP<Comparendo>  pComps){

		Comparable[] rta = new Comparable[pComps.darTamano()];
		int i = 0;
		while(i < pComps.darTamano()){
			rta[i] = pComps.darElemento(i);
			i++;
		}


		return rta;
	}

}
