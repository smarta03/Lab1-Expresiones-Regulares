package pl;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class Tests {

	String entrada = "";
	Validator validator = new Validator ();
	
	@Before
	public void before() {
		
	}
	
	@Test
	public void isDNI() {
		entrada = "73890072A";
		validator.setCadena(entrada);
		validator.validar();
		assertEquals(validator.getResultados().get(0), true);
		assertEquals(validator.getResultados().get(1), false);
		assertEquals(validator.getResultados().get(2), false);
		assertEquals(validator.getResultados().get(3), false);
		assertEquals(validator.getResultados().get(4), false);
	}
	
	@Test
	public void isNIE() {
		entrada = "Y7965543P";
		validator.setCadena(entrada);
		validator.validar();
		assertEquals(validator.getResultados().get(0), true);
		assertEquals(validator.getResultados().get(1), false);
		assertEquals(validator.getResultados().get(2), false);
		assertEquals(validator.getResultados().get(3), false);
		assertEquals(validator.getResultados().get(4), false);
	}
	
	@Test
	public void notDNI_letra() {
		entrada = "93840293P";
		validator.setCadena(entrada);
		validator.validar();
		assertEquals(validator.getResultados().get(0), true);
		assertEquals(validator.getResultados().get(1), false);
		assertEquals(validator.getResultados().get(2), false);
		assertEquals(validator.getResultados().get(3), false);
		assertEquals(validator.getResultados().get(4), false);
	}
	
	@Test
	public void isFLOAT() {
		entrada = "93";
		validator.setCadena(entrada);
		validator.validar();
		assertEquals(validator.getResultados().get(0), false);
		assertEquals(validator.getResultados().get(1), true);
		assertEquals(validator.getResultados().get(2), false);
		assertEquals(validator.getResultados().get(3), false);
		assertEquals(validator.getResultados().get(4), false);
	}

}
