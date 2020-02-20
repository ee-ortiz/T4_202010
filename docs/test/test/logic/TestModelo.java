package test.logic;

import static org.junit.Assert.*;

import model.data_structures.Comparendo;
import model.data_structures.ICola;
import model.data_structures.IPila;
import model.logic.Modelo;

import org.junit.Before;
import org.junit.Test;

public class TestModelo {

	private Modelo modelo;

	@Before
	public void setUp1() {

		modelo = new Modelo();

	}

	public void setUp2() {

		modelo.cargar();
		Comparendo comp = new Comparendo();
		comp.INFRACCION = "Prueba Infraccion";
		modelo.darPila().push(comp);
		modelo.darCola().enqueue(comp);

	}

	public void setUp3() {

		modelo.cargar();
		for(int i = 0; i< 8; i++){
			Comparendo comp = new Comparendo();
			comp.INFRACCION = "Prueba Infraccion";
			modelo.darPila().push(comp);
			modelo.darCola().enqueue(comp);
		}

	}



	@Test
	public void testClusterMasGrande() {

		setUp1();
		setUp3();
		ICola<Comparendo> col = modelo.clusterMasGrandeCola();
		assertEquals(8, col.consultarTam());

	}

	@Test
	public void testUltimosNComparendos() {

		setUp1();
		setUp2();
		IPila<Comparendo> pil = modelo.ultimosNComparendos(1, "Prueba Infraccion");
		assertEquals(1, pil.consultarTamano());


	}

}
