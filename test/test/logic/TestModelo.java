package test.logic;

import static org.junit.Assert.*;
import model.logic.Modelo;

import org.junit.Before;
import org.junit.Test;

public class TestModelo {

	private Modelo modelo;
	private static int CAPACIDAD=100;

	@Before
	public void setUp1() {

	}

	public void setUp2() {

	}

	@Test
	public void testModelo() {

	}

	@Test
	public void testDarTamano() {
		// TODO
		setUp1();
		setUp2();

	}

	@Test
	public void testAgregar() {
		// TODO Completar la prueba
		setUp1();
		setUp2();

	}

	@Test
	public void testBuscar() {
		setUp2();
		assertEquals("1", modelo.buscar("1"));
		// TODO Completar la prueba
	}

	@Test
	public void testEliminar() {
		setUp2();
		modelo.eliminar("0");
		assertEquals("1",modelo.darElemento(0));
		// TODO Completar la prueba

	}

}
