package pl;

import java.util.regex.*;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String cadena = "76898865J";
		Validator v = new Validator(cadena);
		System.out.println(v.printResults());
	}
}