package test.logic;

import static org.junit.Assert.*;

import model.data_structures.Comparendo;
import model.logic.Modelo;

import org.junit.Before;
import org.junit.Test;

public class TestModelo {

	private Modelo modelo;
	public static String PATH = "./data/comparendos_dei_2018_small.geojson";
	public static String PATH2 = "./data/comparendos_dei_2018.geojson";

	@Before
	public void setUp1() {

		modelo = new Modelo();

	}


	public void setUp2() {

		for(int i = 0; i< 8; i++){
			Comparendo comp = new Comparendo();
			comp.INFRACCION = "Prueba Infraccion";
			modelo.darArregloCola().agregar(comp);
		}

	}



	@Test
	public void testComprobarCargaYAgregar() {

		setUp1();
		setUp2();
		int num = modelo.darArregloCola().darTamano()-1;
		System.out.println(num);
		assertEquals(8, num);
		String infrac = modelo.darArregloCola().darElemento(7).INFRACCION;
		assertEquals("Prueba Infraccion", infrac);

	}


}
