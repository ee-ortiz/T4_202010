package test.data_structures;

import model.data_structures.Comparendo;
import model.data_structures.Cola;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCola {

	private Cola<Comparendo> cola;

	@Before
	public void setUp1(){

		cola = new Cola<Comparendo>(50);
	}

	
	public void setup2(){

		for(int i = 0; i<30 ; i++){
			cola.enqueue(new Comparendo());
		}

	}

	@Test
	public void testColaEnqueue(){

		setUp1();
		setup2();
		assertEquals(30, cola.consultarTam());
	}

	@Test
	public void testColaDequeue(){

		setUp1();
		setup2();
		cola.dequeue();
		cola.dequeue();
		assertEquals(28, cola.consultarTam());

	}

}
