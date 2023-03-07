/*
 * Sergio Martínez Agüero 71529484J
 * Procesadres de Lenguaje
 * 2022-2023 - Universidad de León
 * 
 * EXPRESIONES REGULARES UTILIZADAS
 * 
 * 1. DNI_NIE:
 * 		[0-9XYZ]: la cadena debe comenzar por un digito o X o Y o Z.
 * 		\\d{7}: seguido de siete digitos, ya que el primero ya se contabilizo.
 * 		[a-h,j-n,p-t,v-z,A-H,J-N,P-T,V-Z]: termina con el conjunto de letras especificado, ya sean mayusculas o minusculas.
 * 
 * 2. FLOAT:
 * 		[+-]?: la cadena puede comenzar con un mas o un menos o ninguno de los dos.
 * 		\\d*: seguido de 0 o indeterminados dígitos.
 * 		\\.: seguido del simbolo punto.
 * 		\\d*: seguido de 0 o indeterminados dígitos.
 * 		([eE][+-]?[0-9]*)?: seguido o no de: e, simbolo de mas o menos o ninguno, 0 o indeterminados dígitos. 
 * 
 * 3. DOMINIO:
 * 		(
 * 		[a-zA-Z]: la cadena comienza por una letra ya sea mayuscula o minuscula.
 * 		[a-zA-Z\\d-]*: seguido o no de: una letra mayuscula o minuscula o un digito o un guion medio, todo ello puede repetirse indeterminadamente.
 * 		[a-zA-Z\\d]: seguido de una letra mayuscula o minuscula o un digito.
 * 		\\.: seguido del caracter punto.
 * 		)+: todo lo anterior puede aparacer de una a indeterminadas veces.
 * 		[a-zA-Z]: seguido de una letra ya sea mayuscula o minuscula.
 * 		[a-zA-Z\\d-]*:seguido o no de: una letra mayuscula o minuscula o un digito o un guion medio, todo ello puede repetirse indeterminadamente.
 * 		[a-zA-Z\\d]: termina con una letra mayuscula o minuscula o un digito.
 * 
 * 4. EMAIL:
 * 		[\\w\\.+-]+: la cadena comienza con una letra mayúscula o minúscula, un dígito o el carácter _. Esto puede repetirse indeterminadas veces.
 * 		@: seguido del caracter @.
 * 		(
 * 		[a-zA-Z0-9-]+: seguido una letra mayúscula o minúscula, un dígito o guión medio. Esto puede repetirse indeterminadas veces.
 * 		\\.: seguido del caracter punto.
 * 		)+: este bloque anterior puede repetirse una o indeterminadas veces.
 * 		[a-zA-Z]{2,}: seguido de al menos de dos o indeterminadas letras mayusculas o minusculas.
 * 
 * 5. IDENTIFICADOR:
 * 		[a-zA-Z_]: la cadena comienza con una letra mayúscula o minúscula o el carácter _.
 * 		[\\w]*: seguido o no de una letra mayúscula o minúscula, un dígito o el carácter _. Esto puede repetirse indeterminadas veces.
 * 
 */


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
	public void isNIE_and_isIDENTIFIER() {
		entrada = "Y7965543P";
		validator.setCadena(entrada);
		validator.validar();
		assertEquals(validator.getResultados().get(0), true);
		assertEquals(validator.getResultados().get(1), false);
		assertEquals(validator.getResultados().get(2), false);
		assertEquals(validator.getResultados().get(3), false);
		assertEquals(validator.getResultados().get(4), true);
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
	public void notNIE_letra_and_isIDENTIFIER() {
		entrada = "K3840293P";
		validator.setCadena(entrada);
		validator.validar();
		assertEquals(validator.getResultados().get(0), false);
		assertEquals(validator.getResultados().get(1), false);
		assertEquals(validator.getResultados().get(2), false);
		assertEquals(validator.getResultados().get(3), false);
		assertEquals(validator.getResultados().get(4), true);
	}
	
	@Test
	public void notNIE_masNumeros_and_isIDENTIFIER() {
		entrada = "K38402913P";
		validator.setCadena(entrada);
		validator.validar();
		assertEquals(validator.getResultados().get(0), false);
		assertEquals(validator.getResultados().get(1), false);
		assertEquals(validator.getResultados().get(2), false);
		assertEquals(validator.getResultados().get(3), false);
		assertEquals(validator.getResultados().get(4), true);
	}
	
	@Test
	public void notNIE_menosNumeros_and_isIDENTIFIER() {
		entrada = "K384023P";
		validator.setCadena(entrada);
		validator.validar();
		assertEquals(validator.getResultados().get(0), false);
		assertEquals(validator.getResultados().get(1), false);
		assertEquals(validator.getResultados().get(2), false);
		assertEquals(validator.getResultados().get(3), false);
		assertEquals(validator.getResultados().get(4), true);
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
	public void isDOMINIO1() {
		entrada = "xx3.lcs.mit.edu";
		validator.setCadena(entrada);
		validator.validar();
		assertEquals(validator.getResultados().get(0), false);
		assertEquals(validator.getResultados().get(1), false);
		assertEquals(validator.getResultados().get(2), true);
		assertEquals(validator.getResultados().get(3), false);
		assertEquals(validator.getResultados().get(4), false);
	}
	
	@Test
	public void isDOMINIO2() {
		entrada = "ingenierias.unileon.es";
		validator.setCadena(entrada);
		validator.validar();
		assertEquals(validator.getResultados().get(0), false);
		assertEquals(validator.getResultados().get(1), false);
		assertEquals(validator.getResultados().get(2), true);
		assertEquals(validator.getResultados().get(3), false);
		assertEquals(validator.getResultados().get(4), false);
	}
	
	@Test
	public void isDOMINIO3() {
		entrada = "SRI-NIC.ARPA";
		validator.setCadena(entrada);
		validator.validar();
		assertEquals(validator.getResultados().get(0), false);
		assertEquals(validator.getResultados().get(1), false);
		assertEquals(validator.getResultados().get(2), true);
		assertEquals(validator.getResultados().get(3), false);
		assertEquals(validator.getResultados().get(4), false);
	}
	
	@Test
	public void notDOMINIO_sinPunto() {
		entrada = "SRI-NIC";
		validator.setCadena(entrada);
		validator.validar();
		assertEquals(validator.getResultados().get(0), false);
		assertEquals(validator.getResultados().get(1), false);
		assertEquals(validator.getResultados().get(2), false);
		assertEquals(validator.getResultados().get(3), false);
		assertEquals(validator.getResultados().get(4), false);
	}
	
	@Test
	public void notDOMINIO_firstNum() {
		entrada = "1ngenierias.unileon.es";
		validator.setCadena(entrada);
		validator.validar();
		assertEquals(validator.getResultados().get(0), false);
		assertEquals(validator.getResultados().get(1), false);
		assertEquals(validator.getResultados().get(2), false);
		assertEquals(validator.getResultados().get(3), false);
		assertEquals(validator.getResultados().get(4), false);
	}
	
	@Test
	public void notDOMINIO_firstGuion() {
		entrada = "-ngenierias.unileon.es";
		validator.setCadena(entrada);
		validator.validar();
		assertEquals(validator.getResultados().get(0), false);
		assertEquals(validator.getResultados().get(1), false);
		assertEquals(validator.getResultados().get(2), false);
		assertEquals(validator.getResultados().get(3), false);
		assertEquals(validator.getResultados().get(4), false);
	}
	
	@Test
	public void notDOMINIO_guinFin() {
		entrada = "1ngenieria-.unileon.es";
		validator.setCadena(entrada);
		validator.validar();
		assertEquals(validator.getResultados().get(0), false);
		assertEquals(validator.getResultados().get(1), false);
		assertEquals(validator.getResultados().get(2), false);
		assertEquals(validator.getResultados().get(3), false);
		assertEquals(validator.getResultados().get(4), false);
	}
	
	@Test
	public void notDOMINIO_caracterEspecial() {
		entrada = "1ngenie*ias.unileon.es";
		validator.setCadena(entrada);
		validator.validar();
		assertEquals(validator.getResultados().get(0), false);
		assertEquals(validator.getResultados().get(1), false);
		assertEquals(validator.getResultados().get(2), false);
		assertEquals(validator.getResultados().get(3), false);
		assertEquals(validator.getResultados().get(4), false);
	}
	
	@Test
	public void isEMAIL() {
		entrada = "1234test@mail.ru";
		validator.setCadena(entrada);
		validator.validar();
		assertEquals(validator.getResultados().get(0), false);
		assertEquals(validator.getResultados().get(1), false);
		assertEquals(validator.getResultados().get(2), false);
		assertEquals(validator.getResultados().get(3), true);
		assertEquals(validator.getResultados().get(4), false);
	}
	
	@Test
	public void isEMAIL2() {
		entrada = "correo.buzon@estudiantes.unileon.es";
		validator.setCadena(entrada);
		validator.validar();
		assertEquals(validator.getResultados().get(0), false);
		assertEquals(validator.getResultados().get(1), false);
		assertEquals(validator.getResultados().get(2), false);
		assertEquals(validator.getResultados().get(3), true);
		assertEquals(validator.getResultados().get(4), false);
	}
	
	@Test
	public void notEMAIL1() {
		entrada = "@orreo.buzon@estudiantes.unileon.es";
		validator.setCadena(entrada);
		validator.validar();
		assertEquals(validator.getResultados().get(0), false);
		assertEquals(validator.getResultados().get(1), false);
		assertEquals(validator.getResultados().get(2), false);
		assertEquals(validator.getResultados().get(3), false);
		assertEquals(validator.getResultados().get(4), false);
	}

	@Test
	public void notEMAIL2() {
		entrada = "correo.buzon@estudiantes";
		validator.setCadena(entrada);
		validator.validar();
		assertEquals(validator.getResultados().get(0), false);
		assertEquals(validator.getResultados().get(1), false);
		assertEquals(validator.getResultados().get(2), false);
		assertEquals(validator.getResultados().get(3), false);
		assertEquals(validator.getResultados().get(4), false);
	}
	
	@Test
	public void notEMAIL3() {
		entrada = "correo.buzon@estudiantes@unileon.es";
		validator.setCadena(entrada);
		validator.validar();
		assertEquals(validator.getResultados().get(0), false);
		assertEquals(validator.getResultados().get(1), false);
		assertEquals(validator.getResultados().get(2), false);
		assertEquals(validator.getResultados().get(3), false);
		assertEquals(validator.getResultados().get(4), false);
	}

	@Test
	public void notEMAIL4() {
		entrada = "correo.buzon@estudiantes..es";
		validator.setCadena(entrada);
		validator.validar();
		assertEquals(validator.getResultados().get(0), false);
		assertEquals(validator.getResultados().get(1), false);
		assertEquals(validator.getResultados().get(2), false);
		assertEquals(validator.getResultados().get(3), false);
		assertEquals(validator.getResultados().get(4), false);
	}
	
	@Test
	public void isIDENTIFIER1() {
		entrada = "variable1";
		validator.setCadena(entrada);
		validator.validar();
		assertEquals(validator.getResultados().get(0), false);
		assertEquals(validator.getResultados().get(1), false);
		assertEquals(validator.getResultados().get(2), false);
		assertEquals(validator.getResultados().get(3), false);
		assertEquals(validator.getResultados().get(4), true);
	}
	
	@Test
	public void isIDENTIFIER2() {
		entrada = "SUMatorio";
		validator.setCadena(entrada);
		validator.validar();
		assertEquals(validator.getResultados().get(0), false);
		assertEquals(validator.getResultados().get(1), false);
		assertEquals(validator.getResultados().get(2), false);
		assertEquals(validator.getResultados().get(3), false);
		assertEquals(validator.getResultados().get(4), true);
	}
	
	@Test
	public void isIDENTIFIER3() {
		entrada = "_acumulador";
		validator.setCadena(entrada);
		validator.validar();
		assertEquals(validator.getResultados().get(0), false);
		assertEquals(validator.getResultados().get(1), false);
		assertEquals(validator.getResultados().get(2), false);
		assertEquals(validator.getResultados().get(3), false);
		assertEquals(validator.getResultados().get(4), true);
	}
	
	@Test
	public void isIDENTIFIER4() {
		entrada = "x";
		validator.setCadena(entrada);
		validator.validar();
		assertEquals(validator.getResultados().get(0), false);
		assertEquals(validator.getResultados().get(1), false);
		assertEquals(validator.getResultados().get(2), false);
		assertEquals(validator.getResultados().get(3), false);
		assertEquals(validator.getResultados().get(4), true);
	}
	
	@Test
	public void isIDENTIFIER5() {
		entrada = "a1";
		validator.setCadena(entrada);
		validator.validar();
		assertEquals(validator.getResultados().get(0), false);
		assertEquals(validator.getResultados().get(1), false);
		assertEquals(validator.getResultados().get(2), false);
		assertEquals(validator.getResultados().get(3), false);
		assertEquals(validator.getResultados().get(4), true);
	}
	
	@Test
	public void notIDENTIFIER() {
		entrada = "1variable";
		validator.setCadena(entrada);
		validator.validar();
		assertEquals(validator.getResultados().get(0), false);
		assertEquals(validator.getResultados().get(1), false);
		assertEquals(validator.getResultados().get(2), false);
		assertEquals(validator.getResultados().get(3), false);
		assertEquals(validator.getResultados().get(4), false);
	}
}
