package test.data_structures;

import model.data_structures.Comparendo;
import model.data_structures.Pila;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestPila {

	private Pila<Comparendo> pila;

	@Before
	public void setUp1(){

		pila = new Pila<Comparendo>(50);

	}
	
	public void setup2(){

		for(int i = 0; i<30 ; i++){
			pila.push(new Comparendo());
		}
	}

	@Test
	public void testPilaPush(){

		setUp1();
		setup2();
		assertEquals(30, pila.consultarTamano());

	}

	@Test
	public void testPilaPop(){

		setUp1();
		setup2();
		pila.pop();
		pila.pop();
		assertEquals(28, pila.consultarTamano());

	}


}
