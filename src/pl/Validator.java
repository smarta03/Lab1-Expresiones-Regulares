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

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

	private String cadena;
	private ArrayList<Boolean> resultados;

	public Validator(String c) {
		cadena = c;
		resultados = new ArrayList<Boolean>();
		validar();
	}

	public Validator() {
		cadena = "";
		resultados = new ArrayList<Boolean>();
	}

	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) {
		this.cadena = cadena;
	}

	public ArrayList<Boolean> getResultados() {
		return resultados;
	}

	public void setResultados(ArrayList<Boolean> resultados) {
		this.resultados = resultados;
	}

	public boolean isDNI_NIE() {
		Pattern patron = Pattern.compile("[0-9XYZ]\\d{7}[a-h,j-n,p-t,v-z,A-H,J-N,P-T,V-Z]");
		Matcher cumple = patron.matcher(cadena);
		boolean resultado = cumple.matches();
		return resultado;
	}

	public boolean isFloat() {
		Pattern patron = Pattern.compile("[+-]?\\d*\\.\\d*([eE][+-]?[0-9]*)?");
		Matcher cumple = patron.matcher(cadena);
		boolean resultado = cumple.matches();
		return resultado;
	}

	public boolean isDomain() {
		Pattern patron = Pattern.compile("([a-zA-Z][a-zA-Z\\d-]*[a-zA-Z\\d]\\.)+[a-zA-Z][a-zA-Z\\d-]*[a-zA-Z\\d]");
		Matcher cumple = patron.matcher(cadena);
		boolean resultado = cumple.matches();
		return resultado;
	}

	public boolean isEmail() {
		Pattern patron = Pattern.compile("[\\w\\.+-]+@([a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}");
		Matcher cumple = patron.matcher(cadena);
		boolean resultado = cumple.matches();
		return resultado;
	}

	public boolean isIdentifier() {
		Pattern patron = Pattern.compile("[a-zA-Z_][\\w]*");
		Matcher cumple = patron.matcher(cadena);
		boolean resultado = cumple.matches();
		return resultado;
	}

	public void validar() {
		resultados.add(isDNI_NIE());
		resultados.add(isFloat());
		resultados.add(isDomain());
		resultados.add(isEmail());
		resultados.add(isIdentifier());
	}

	public String printResults() {
		StringBuffer result = new StringBuffer();
		result.append("(");
		for (int i = 0; i < 5; i++) {
			if (resultados.get(i) == true) {
				// Hacer un swith que dependindo del valor de i escriba si es DNI, float, ...
				switch (i) {
				case 0: {
					result.append("DNI_NIE,");
					break;
				}
				case 1: {
					result.append("FLOAT,");
					break;
				}
				case 2: {
					result.append("DOMINIO,");
					break;
				}
				case 3: {
					result.append("EMAIL,");
					break;
				}
				case 4: {
					result.append("IDENTIFICADOR,");
					break;
				}
				}
			}
		}
		
		result.setLength(result.length()-1);

		if (result.length() == 1) {
			result.append("Cadena de caracteres no identificada");
		}
		result.append(")\n");
		return result.toString();
	}

}
