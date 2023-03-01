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
		boolean resultado = cumple.find();
		return resultado;
	}

	public boolean isFloat() {
		Pattern patron = Pattern.compile("[+-]?\\d*[.][[eE][[+-]?[0-9]*]?]");
		Matcher cumple = patron.matcher(cadena);
		boolean resultado = cumple.find();
		return resultado;
	}

	public boolean isDomain() {
		return false;
	}

	public boolean isEmail() {
		return false;
	}

	public boolean isIdentifier() {
		return false;
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
		for (int i = 0; i < 5; i++) {
			if (resultados.get(i) == true) {
				// Hacer un swith que dependindo del valor de i escriba si es DNI, float, ...
				switch (i) {
				case 0: {
					result.append("DNI_NIE\n");
					break;
				}
				case 1: {
					result.append("FLOAT\n");
					break;
				}
				case 2: {
					result.append("DOMINIO\n");
					break;
				}
				case 3: {
					result.append("EMAIL\n");
					break;
				}
				case 4: {
					result.append("IDENTIFICADOR\n");
					break;
				}

				}
			}
		}
		return result.toString();
	}

}
