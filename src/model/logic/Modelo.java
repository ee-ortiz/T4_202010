package model.logic;

import model.data_structures.ArregloDinamico;
import model.data_structures.Cola;
import model.data_structures.Comparendo;
import model.data_structures.IArregloDinamico;
import model.data_structures.ICola;
import model.data_structures.IPila;
import model.data_structures.Pila;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {
	/**
	 * Atributos del modelo del mundo
	 */
	private IPila<Comparendo> datos;
	private ICola<Comparendo> datos1;
	private GeoJSONProcessing objetoJsonGson;

	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo()
	{
		datos = new Pila<Comparendo>(600000);
		datos1 = new Cola<Comparendo>(600000);
		objetoJsonGson = new GeoJSONProcessing();
	}

	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamanoPila()
	{
		return datos.consultarTamano();
	}

	public int darTamanoCola(){

		return datos1.consultarTam();
	}


	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return dato encontrado
	 */
	public String buscar(String dato)
	{
		return null;
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

	public String darElemento(int numero){
		return null;

	}

	public void cargar(){

		objetoJsonGson.cargarDatos(datos, datos1);
	}

	public IPila<Comparendo> darPila(){

		return datos;
	}

	public ICola<Comparendo> darCola(){

		return datos1;
	}


	public ICola<Comparendo> clusterMasGrandeCola(){

		int grupoMasGrande = 0;
		ICola<Comparendo> colaMasGrande = null;

		for(int i =0; i<datos1.consultarTam(); i++){

			ICola<Comparendo> variableTemporal = new Cola<Comparendo>(600000);
			variableTemporal.enqueue(datos1.darElementos()[i]);

			boolean continuar = true;
			for(int j = i+1; j<datos1.consultarTam() && continuar==true; j++ ){
				if(datos1.darElementos()[i].compareTo(datos1.darElementos()[j])==0){

					variableTemporal.enqueue(datos1.darElementos()[j]);

				}

				else{
					continuar = false;
					i = j;
				}
			}
			if(variableTemporal.consultarTam()>grupoMasGrande){
				colaMasGrande = variableTemporal;
				grupoMasGrande = variableTemporal.consultarTam();

			}

		}
		datos1.vaciarCola();
		return colaMasGrande;

	}

	public IPila<Comparendo> ultimosNComparendos(int numComps, String codInfrac){

		int conteo = 0;
		IPila<Comparendo> PilaResultado = null;
		IPila<Comparendo> variableTemporal = new Pila<Comparendo>(600000);
		for(int i= datos.consultarTamano()-1 ; i>=0 && conteo<=numComps; i--){
			if(datos.darElementos()[i].INFRACCION.compareTo(codInfrac)==0){

				variableTemporal.push(datos.darElementos()[i]);
				conteo++;
			}

			datos.pop();
		}
		if(variableTemporal.consultarTamano()>0){
			PilaResultado = variableTemporal;
		}

		return PilaResultado;

	}

	public String RetornarDatos(Comparendo comp){
		//INFRACCION, OBJECTID,
		//FECHA_HORA, CLASE_VEHI, TIPO_SERVI, LOCALIDAD.
		String rta = "Codigo de infraccion: "+comp.INFRACCION +" ObjectID: " + comp.OBJECTID + " Fecha y hora: " + comp.FECHA_HORA + " Clase de vehiculo "+comp.CLASE_VEHI + " Tipo de servicio: " +
				comp.TIPO_SERVI + " Localidad: "+ comp.LOCALIDAD;
		return rta;
	}
}
