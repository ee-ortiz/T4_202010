package test.logic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamico;
import model.data_structures.MaxHeapCP;
import model.logic.Modelo;

public class TestAlgoritmosOrdenamiento {


	/*Definir las pruebas unitarias del ordenamiento ShellSort para tres conjuntos de datos de
	prueba: datos aleatorios, datos ordenados ascendentemente y datos ordenados
	descendentemente.
	AYUDA 1: Para generar una muestra de datos aleatorios, puede generar números reales
	(double) pseudoaleatorios con el método
	double Math.random()
	AYUDA 2: Para generar una muestra de datos ordenados ascendentemente puede generar
	una muestra de números enteros usando un ciclo for con valor inicial i = 0 y avance i++.
	AYUDA 3: Para generar una muestra de datos ordenados descendentemente puede generar
	una muestra de números enteros usando un ciclo for con valor inicial i = 0 y avance i--. 
	 */

	private Modelo modelo;
	private MaxHeapCP<Double> arregloDoubles;
	private MaxHeapCP<Integer> arregloIntegers;
	private Comparable[] doubles;
	private Comparable[] ints;
	

	@Before
	public void setUp1() {

		modelo = new Modelo();
		arregloDoubles = new MaxHeapCP<>();
		arregloIntegers = new MaxHeapCP<>();
		doubles = new Comparable[20];
		ints = new Comparable[20];

	}

	public void setUp2(){

		for(int i = 0; i<20; i++){
			ints[i] = arregloIntegers.darElemento(i);
			doubles[i] = arregloDoubles.darElemento(i);

		}

	}
	// arreglo aleatorio
	public void setUp1Arreglo(){

		for(int i = 0; i<20; i++){
			double aAgregar = Math.random();
			arregloDoubles.agregar(aAgregar);

		}

	}
	//arreglo ordenado ascendentemente
	public void setUp2Arreglo(){

		for(int i = 0; i<20; i++ ){
			arregloIntegers.agregar(i);
		}

	}
	// arreglo ordenado descendentemente
	public void setUp3Arreglo(){

		for(int i = 0; i> -20; i--){
			arregloIntegers.agregar(i);
		}

	}

	@Test
	public void testAgregarMaxHeapCP() {

		setUp1();
		setUp1Arreglo();
		setUp2();
		int variable= arregloDoubles.darTamano();
		arregloDoubles.agregar(2.1);
		assertTrue(arregloDoubles.darTamano()>variable);

			//assertTrue(doubles[i].compareTo(doubles[i+1])<=0);

		

	}
	public void testDarNumeroDeElementosMaxHeap() {

		setUp1();
		setUp1Arreglo();
		setUp2();
		int variable= arregloDoubles.darTamano();
		arregloDoubles.agregar(2.1);
		assertTrue(arregloDoubles.darTamano()>variable);

	}
	public void testSacarMaxHeap() {

		
		setUp2();
		int variable= arregloIntegers.sacarMax();
		assertTrue(variable>arregloIntegers.darElemento(0));

			//assertTrue(doubles[i].compareTo(doubles[i+1])<=0);

	}
	public void testdarMaxMaxHeap(){
		setUp2();
		int variable= arregloIntegers.sacarMax();
		assertTrue(variable>arregloIntegers.darElemento(0));
	}
	public void testEstaVacio(){
		assertTrue(arregloIntegers.darElemento(0)==null);
	}

	
}
