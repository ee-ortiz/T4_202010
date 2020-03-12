package view;

import model.logic.Modelo;

public class View 
{
	/**
	 * Metodo constructor
	 */
	public View()
	{

	}

	public void printMenu()
	{
		System.out.println("1. Cargar Datos");
		System.out.println("2. Crear un arreglo de objetos Comparables con los comparendos de la carga inicial");
		System.out.println("3. Mostrar los N comparendos que ocurrieron más al norte (basada en la latitud) y que involucraron un tipo de vehículo que está incluido en una lista (con unaMaxColaCP)");
		System.out.println("4. Mostrar los N comparendos que ocurrieron más al norte (basada en la latitud) y que involucraron un tipo de vehículo que está incluido en una lista (con unaMaxHeapCP");	
		System.out.println("Dar el numero de opcion a resolver, luego oprimir tecla Return:");

	}

	public void printMessage(String mensaje) {

		System.out.println(mensaje);
	}		

	public void printModelo(Modelo modelo)
	{
		// TODO implementar
		System.out.println(modelo);
	}
}
