package calculator;

import java.util.Scanner;

public class operacoes {
	
	public static double somar(double n1, double n2) {
		return n1+n2;
	}
	
	public static double sub(double n1, double n2) {
		return n1-n2;
	}
	
	public static double divi(double n1, double n2) {
		if (n2 != 0) {
			return n1/n2;
		} else {
			 throw new ArithmeticException("Erro: Divisão por zero!");
		}
	}
	
	public static double mult(double n1, double n2) {
		return n1*n2;
	}
	
	
}
