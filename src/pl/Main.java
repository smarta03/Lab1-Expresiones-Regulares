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

import java.util.regex.*;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String cadena = "X7965543P";
		Validator v = new Validator(cadena);
		System.out.println(v.printResults());
	}
}
