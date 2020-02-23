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
		System.out.println("3. Ordenar ascendentemente los comparendos del nuevo arreglo usando el algoritmo ShellSort");
		System.out.println("4. Ordenar ascendentemente los comparendos del nuevo arreglo usando el algoritmo MergeSort");
		System.out.println("5. Ordenar ascendentemente los comparendos del nuevo arreglo usando el algoritmo QuickSort");		
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
