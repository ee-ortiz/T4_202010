package model.data_structures;

import model.logic.Modelo;

public class MaxHeapCP <T extends Comparable<T>>{
	/**
	 * Capacidad maxima del arreglo
	 */
	private int tamanoMax;
	/**
	 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0)
	 */
	private int tamanoAct;
	/**
	 * Arreglo de elementos de tamaNo maximo
	 */
	private T elementos[ ];
	
	private Modelo modelo;

	/**
	 * Construir un arreglo con la capacidad maxima inicial.
	 * @param max Capacidad maxima inicial
	 */
	public MaxHeapCP() {
		// TODO Auto-generated constructor stub
		tamanoAct = 1;
		tamanoMax = tamanoAct;
		elementos = (T[]) new Comparable[tamanoMax];
	
		
		
		
	}

	public void agregar( T dato )
	{
		if ( tamanoAct == tamanoMax )
		{  // caso de arreglo lleno (aumentar tamaNo)

			tamanoMax = 2 * tamanoMax;
			T [ ] copia = elementos;
			elementos = (T[]) new Comparable[tamanoMax];
			for ( int i = 0; i < tamanoAct; i++)
			{
				elementos[i] = copia[i];
			} 
			System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
		}	
		elementos[tamanoAct] = dato;
		tamanoAct++;
	}

	public int darCapacidad() {
		return tamanoMax;
	}

	public int darTamano() {
		return tamanoAct;
	}

	public T darElemento(int i) {

		return elementos[i];
	}

	public T buscar(T dato) {

		boolean found = false;
		T rta = null;

		for(int i = 0; i<tamanoAct && found ==false ;i++){

			if(elementos[i].compareTo(dato)==0){

				rta = elementos[i];
				found = true;
			}
		}

		return rta;

	}



	public T eliminar(T dato){

		T rta = null;
		boolean delete = false;
		int i = 0;
		while(i< tamanoAct && delete==false){

			if(elementos[i].compareTo(dato)==0){
				rta = elementos[i];
				elementos[i] = null;
				delete = true;
				int j = i+1;
				while(j< tamanoAct){
					elementos[j-1] = elementos[j];
				}
			}
			i++;
		}
		return rta;

	}
	public T sacarMax()
	{
		if(darElemento(0)!=null)
		{
			int cont=0;
			T eliminado=elementos[0];
			while(tamanoAct>cont )
			{
				elementos[cont]=elementos[cont+1];
				cont++;
			}
			return eliminado;
		}
		return null;
	}
	public T darMax()
	{
		return elementos[0];
	}
	boolean esVacia ()
	{
		if(elementos.length==0)
		{
			return true;
		}
		return false;
	}
	
}

