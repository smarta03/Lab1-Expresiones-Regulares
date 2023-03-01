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
	public void isDNI_mayus() {
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
	public void isDNI_min() {
		entrada = "86774538L";
		validator.setCadena(entrada);
		validator.validar();
		assertEquals(validator.getResultados().get(0), true);
		assertEquals(validator.getResultados().get(1), false);
		assertEquals(validator.getResultados().get(2), false);
		assertEquals(validator.getResultados().get(3), false);
		assertEquals(validator.getResultados().get(4), false);
	}
	
	@Test
	public void isDNI_cero() {
		entrada = "06774538L";
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
		entrada = "93840293I";
		validator.setCadena(entrada);
		validator.validar();
		assertEquals(validator.getResultados().get(0), false);
		assertEquals(validator.getResultados().get(1), false);
		assertEquals(validator.getResultados().get(2), false);
		assertEquals(validator.getResultados().get(3), false);
		assertEquals(validator.getResultados().get(4), false);
	}
	
	@Test
	public void notDNI_letra2() {
		entrada = "93840293O";
		validator.setCadena(entrada);
		validator.validar();
		assertEquals(validator.getResultados().get(0), false);
		assertEquals(validator.getResultados().get(1), false);
		assertEquals(validator.getResultados().get(2), false);
		assertEquals(validator.getResultados().get(3), false);
		assertEquals(validator.getResultados().get(4), false);
	}
	
	@Test
	public void notDNI_letra3() {
		entrada = "938A0293P";
		validator.setCadena(entrada);
		validator.validar();
		assertEquals(validator.getResultados().get(0), false);
		assertEquals(validator.getResultados().get(1), false);
		assertEquals(validator.getResultados().get(2), false);
		assertEquals(validator.getResultados().get(3), false);
		assertEquals(validator.getResultados().get(4), false);
	}
	
	@Test
	public void notDNI_menosNumeros() {
		entrada = "986658J";
		validator.setCadena(entrada);
		validator.validar();
		assertEquals(validator.getResultados().get(0), false);
		assertEquals(validator.getResultados().get(1), false);
		assertEquals(validator.getResultados().get(2), false);
		assertEquals(validator.getResultados().get(3), false);
		assertEquals(validator.getResultados().get(4), false);
	}
	
	public void notDNI_masNumeros() {
		entrada = "93808760293P";
		validator.setCadena(entrada);
		validator.validar();
		assertEquals(validator.getResultados().get(0), false);
		assertEquals(validator.getResultados().get(1), false);
		assertEquals(validator.getResultados().get(2), false);
		assertEquals(validator.getResultados().get(3), false);
		assertEquals(validator.getResultados().get(4), false);
	}
	
	@Test
	public void notNIE_letra() {
		entrada = "K3840293P";
		validator.setCadena(entrada);
		validator.validar();
		assertEquals(validator.getResultados().get(0), false);
		assertEquals(validator.getResultados().get(1), false);
		assertEquals(validator.getResultados().get(2), false);
		assertEquals(validator.getResultados().get(3), false);
		assertEquals(validator.getResultados().get(4), false);
	}
	
	@Test
	public void notNIE_masNumeros() {
		entrada = "K38402913P";
		validator.setCadena(entrada);
		validator.validar();
		assertEquals(validator.getResultados().get(0), false);
		assertEquals(validator.getResultados().get(1), false);
		assertEquals(validator.getResultados().get(2), false);
		assertEquals(validator.getResultados().get(3), false);
		assertEquals(validator.getResultados().get(4), false);
	}
	
	@Test
	public void notNIE_menosNumeros() {
		entrada = "K384023P";
		validator.setCadena(entrada);
		validator.validar();
		assertEquals(validator.getResultados().get(0), false);
		assertEquals(validator.getResultados().get(1), false);
		assertEquals(validator.getResultados().get(2), false);
		assertEquals(validator.getResultados().get(3), false);
		assertEquals(validator.getResultados().get(4), false);
	}
	
	@Test
	public void isFLOAT1() {
		entrada = "23.218";
		validator.setCadena(entrada);
		validator.validar();
		assertEquals(validator.getResultados().get(0), false);
		assertEquals(validator.getResultados().get(1), true);
		assertEquals(validator.getResultados().get(2), false);
		assertEquals(validator.getResultados().get(3), false);
		assertEquals(validator.getResultados().get(4), false);
	}
	
	@Test
	public void isFLOAT2() {
		entrada = "-350.12";
		validator.setCadena(entrada);
		validator.validar();
		assertEquals(validator.getResultados().get(0), false);
		assertEquals(validator.getResultados().get(1), true);
		assertEquals(validator.getResultados().get(2), false);
		assertEquals(validator.getResultados().get(3), false);
		assertEquals(validator.getResultados().get(4), false);
	}
	
	@Test
	public void isFLOAT3() {
		entrada = ".766";
		validator.setCadena(entrada);
		validator.validar();
		assertEquals(validator.getResultados().get(0), false);
		assertEquals(validator.getResultados().get(1), true);
		assertEquals(validator.getResultados().get(2), false);
		assertEquals(validator.getResultados().get(3), false);
		assertEquals(validator.getResultados().get(4), false);
	}
	
	@Test
	public void isFLOAT4() {
		entrada = "+25.1e30";
		validator.setCadena(entrada);
		validator.validar();
		assertEquals(validator.getResultados().get(0), false);
		assertEquals(validator.getResultados().get(1), true);
		assertEquals(validator.getResultados().get(2), false);
		assertEquals(validator.getResultados().get(3), false);
		assertEquals(validator.getResultados().get(4), false);
	}
	
	@Test
	public void isFLOAT5() {
		entrada = "-12.0E-5";
		validator.setCadena(entrada);
		validator.validar();
		assertEquals(validator.getResultados().get(0), false);
		assertEquals(validator.getResultados().get(1), true);
		assertEquals(validator.getResultados().get(2), false);
		assertEquals(validator.getResultados().get(3), false);
		assertEquals(validator.getResultados().get(4), false);
	}
	
	@Test
	public void notFLOAT1() {
		entrada = "200";
		validator.setCadena(entrada);
		validator.validar();
		assertEquals(validator.getResultados().get(0), false);
		assertEquals(validator.getResultados().get(1), false);
		assertEquals(validator.getResultados().get(2), false);
		assertEquals(validator.getResultados().get(3), false);
		assertEquals(validator.getResultados().get(4), false);
	}
	
	@Test
	public void notFLOAT2() {
		entrada = "2";
		validator.setCadena(entrada);
		validator.validar();
		assertEquals(validator.getResultados().get(0), false);
		assertEquals(validator.getResultados().get(1), false);
		assertEquals(validator.getResultados().get(2), false);
		assertEquals(validator.getResultados().get(3), false);
		assertEquals(validator.getResultados().get(4), false);
	}
	
	@Test
	public void notFLOAT3() {
		entrada = "xx3.lcs.mit.edu";
		validator.setCadena(entrada);
		validator.validar();
		assertEquals(validator.getResultados().get(0), false);
		assertEquals(validator.getResultados().get(1), false);
		assertEquals(validator.getResultados().get(2), false);
		assertEquals(validator.getResultados().get(3), false);
		assertEquals(validator.getResultados().get(4), false);
	}

}
