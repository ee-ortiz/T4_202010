package model.data_structures;

public class Cola <T extends Comparable<T>>  implements ICola<T>{

	private int tamMax;
	private int tamAct;
	private T elementos[];

	public Cola(int max){


		elementos = (T[]) new Comparable[max];
		tamMax = max;
		tamAct = 0;
	}

	public void enqueue(T elemento){

		if(tamAct == tamMax){

			tamMax = 2*tamAct;
			T[] copia = elementos;
			elementos = (T[]) new Comparable[tamMax]; 

			for(int i = 0; i < tamAct; i++ ){

				elementos[i] = copia[i];			
			}

		}


		elementos[tamAct] = elemento;
		tamAct++;
	}

	public T dequeue(){

		T rta = null;

		if(tamAct>0 ){

			rta = elementos[0];
			elementos[0] = null;

			for(int i = 0; i < tamAct; i++ ){

				elementos[i] = elementos[i+1];

			}
			tamAct--;
		}

		return rta;
	}

	public int consultarTam(){

		return tamAct;
	}

	public boolean estaVacia(){

		return tamAct == 0;
	}

	public T consultarElementoPrincipio(){

		T rta = null;

		if(tamAct>0){
			rta = elementos[0];
		}

		return rta;
	}

	public T[] darElementos(){

		return elementos;
	}

	public void vaciarCola(){

		elementos = (T[]) new Comparable[tamMax];
	}

	public T darElementoEspecifico(int i){

		return elementos[i];

	}


}
