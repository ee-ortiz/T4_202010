package model.data_structures;

import com.sun.org.apache.xalan.internal.xsltc.dom.CachedNodeListIterator;

public class Pila <T extends Comparable<T>>  implements IPila<T> {

	private int tamMax;
	private int tamAct;
	private T elementos[];

	public Pila(int max){


		elementos = (T[]) new Comparable[max];
		tamMax = max;
		tamAct = 0;
	}

	public void push(T elemento){

		if(tamAct == tamMax){

			tamMax = 2*tamAct;
			T[] copia = elementos;
			elementos = (T[]) new Comparable[tamMax]; 

			for(int i = 0; i < tamAct; i++ ){

				elementos[i] = copia[i];			
			}

		}

		elementos[tamAct] = elemento;
		tamAct ++;
	}

	public T pop(){

		T rta = null;

		if(tamAct>0){

			rta = elementos[tamAct-1];
			elementos[tamAct-1] = null;
			tamAct--;

		}

		return rta;
	}

	public int consultarTamano(){

		return tamAct;
	}

	public boolean estaVacia(){

		return tamAct==0;
	}

	public T consultarTope(){

		T rta = null;

		if(tamAct>0){

			rta = elementos[tamAct-1];
		}

		return rta;

	}

	public T[] darElementos(){

		return elementos;
	}

}
