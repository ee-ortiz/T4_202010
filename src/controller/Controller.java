package controller;

import java.util.Scanner;

import model.data_structures.Comparendo;
import model.data_structures.ICola;
import model.data_structures.IPila;
import model.logic.Modelo;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;

	/* Instancia de la Vista*/
	private View view;

	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}

	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		int dato = 0;
		Comparendo respuesta = null;

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
			case 1:
				modelo = new Modelo();

				long start = System.currentTimeMillis();
				modelo.cargar();
				IPila<Comparendo> pila = modelo.darPila();
				ICola<Comparendo> cola = modelo.darCola();
				long end = System.currentTimeMillis();

				view.printMessage("Tiempo de carga (s): " + (end-start)/1000.0);
				view.printMessage("Datos cargados en la pila: " + pila.consultarTamano() + "\n");
				view.printMessage("Datos cargados en la cola: " + cola.consultarTam() + "\n");
				view.printMessage("Primer dato cola: " + cola.consultarElementoPrincipio().toString() + "\n");
				view.printMessage("Primer dato pila: " + pila.consultarTope().toString() + "\n");
				break;

			case 2:
				//usuario debe mostrarse el número de comparendos del grupo
				//resultado y por cada comparendo debe informarse (en orden): INFRACCION, OBJECTID,
				//FECHA_HORA, CLASE_VEHI, TIPO_SERVI, LOCALIDAD
				ICola<Comparendo> nueva = modelo.clusterMasGrandeCola();
				if(nueva !=null){
					view.printMessage("La nueva cola creada tiene un tamaño de " + nueva.consultarTam());
					view.printMessage("Sus elementos son: ");
					for(int i = 0; i<nueva.consultarTam(); i++){
						view.printMessage("- "  + modelo.RetornarDatos(nueva.darElementoEspecifico(i)));
					}
				}
				else{
					view.printMessage("No has cargado los datos aun");
				}
				break;

			case 3: 
				view.printMessage("Ingrese El número de comparendos que busca tener en su nueva pila");
				int num = lector.nextInt();
				view.printMessage("Ingrese el codigo de infraccion que desea que tengan los comparendos de su nueva pila");
				String infra = lector.next();
				IPila<Comparendo> nueva1 = modelo.ultimosNComparendos(num, infra);
				if(nueva1!=null){
					view.printMessage("La nueva pila creada tiene un tamaño de "+ nueva1.consultarTamano());
					view.printMessage("Sus elementos son: ");
					for(int j = 0; j<nueva1.consultarTamano(); j++){
						view.printMessage("- " + modelo.RetornarDatos(nueva1.darElementoEspecifico(j)));
					}
				}
				else{
					view.printMessage("No has cargado los datos aun ó no existe ningun comparendo con el codigo de infracción que indicaste");
				}
				break;
			default: 
				view.printMessage("--------- \n Opcion Invalida !! \n---------");
				break;
			}
		}

	}	
}
