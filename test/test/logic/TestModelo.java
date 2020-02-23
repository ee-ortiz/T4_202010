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

		modelo.cargar(PATH);
		for(int i = 0; i< 8; i++){
			Comparendo comp = new Comparendo();
			comp.INFRACCION = "Prueba Infraccion";
			modelo.darArreglo().agregar(comp);
		}

	}



	@Test
	public void testComprobarCargaYAgregar() {

		setUp1();
		setUp2();
		int num = modelo.darArreglo().darTamano();
		assertEquals(28, num);
		String infrac = modelo.darArreglo().darElemento(27).INFRACCION;
		assertEquals("Prueba Infraccion", infrac);

	}


}
