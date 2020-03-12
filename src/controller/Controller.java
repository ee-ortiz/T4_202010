package controller;

import java.util.Scanner;

import model.data_structures.Comparendo;
import model.data_structures.IArregloDinamico;
import model.data_structures.ICola;
import model.data_structures.IPila;
import model.data_structures.MaxHeapCP;
import model.logic.Modelo;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;

	/* Instancia de la Vista*/
	private View view;

	private boolean cargado;
	public static String PATH = "./data/comparendos_dei_2018_small.geojson";
	public static String PATH2 = "./data/comparendos_dei_2018.geojson";
	public static String PATH3 = "./data/Comparendos_DEI_2018_Bogotá_D.C.geojson";
	private Comparable<Comparendo>[] aOrdenar;
	private Comparable<Comparendo>[] copiaPrimera;

	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
		cargado = false;
	}

	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;


		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
			case 1:
				if(cargado == false){
					modelo = new Modelo();

					long start = System.currentTimeMillis();
					modelo.cargar(PATH3);
					MaxHeapCP<Comparendo> comps = modelo.darArreglo();
					long end = System.currentTimeMillis();

					view.printMessage("Tiempo de carga (s): " + (end-start)/1000.0);
					view.printMessage("El numero de datos cargados es: " + comps.darTamano());
					view.printMessage("El primer comparendo cargado es: " + comps.darElemento(0).retornarDatos());
					view.printMessage("El ultimo comparendo cargado es: "+ comps.darElemento(comps.darTamano()-1).retornarDatos() +"\n");
					cargado = true;
				}

				else{

					view.printMessage("Los datos contenidos en los archivos sólo se pueden leer una vez" +"\n");
				}

				break;			

				//Mostrar:
				// El tiempo en milisegundos que tomó el algoritmo realizando el ordenamiento 
				// Los 10 primeros comparendos y los 10 últimos comparendos resultado del ordenamiento.
			case 2:
				if(cargado == true){
					copiaPrimera  = modelo.copiarComparendos();	
					view.printMessage("El numero de comparendos que contiene el nuevo arreglo es: " + copiaPrimera.length + "\n");
				}
				else{
					view.printMessage("Aun no has cargado los comparendos");
				}
				break;

			case 3:
				//supuestamente ya se cargaron los datos
				String rtas="";
				view.printMessage("ingrese el nombre del vehiculos");
				 String vehiculo = lector.next();

				 try {

						

						Comparable [] a = modelo.requerimiento2(vehiculo);

						int i = 0;

						if(a.length>0){
							while(i<a.length){
								Comparendo aMostar = (Comparendo) a[i];
								rtas += "- " + modelo.RetornarDatos(aMostar) + "\n";
								i++;
							}
							view.printMessage("El total de comparendos registrados en el archivo dada una Latitud es: " + a.length + "\n" );
							view.printMessage(rtas);
						}
						else{
							view.printMessage("No se encontraron comparendos con esa fecha en los archivos");
						}
					}

					catch (Exception e) {
						e.printStackTrace();
					}

				break;

		


			default: 

				view.printMessage("--------- \n Opcion Invalida !! \n---------");
				break;
			}

		}

	}	
}