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
		// Ver que pasa con {7} ya que si insetas menos numeros si que lo hace bien
		// pero si metes mas de 7 la da como valida y esta mal
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
		Pattern patron = Pattern.compile("");
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
					result.append("DNI_NIE");
					break;
				}
				case 1: {
					result.append("FLOAT");
					break;
				}
				case 2: {
					result.append("DOMINIO");
					break;
				}
				case 3: {
					result.append("EMAIL");
					break;
				}
				case 4: {
					result.append("DENTIFICADOR");
					break;
				}
				}
			}
		}
		
		if(result.length()==1) {
			result.append("Cadena de caracteres no identificada");
		}
		result.append(")\n");
		return result.toString();
	}

}
