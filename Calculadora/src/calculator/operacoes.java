package calculator;

import java.util.Scanner;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

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
			 throw new ArithmeticException("Erro: Divis�o por zero!");
		}
	}
	
	public static double mult(double n1, double n2) {
		return n1*n2;
	}
	
	public static void pergunta(int opc) {
		System.out.println("1- Adicionar mais um numero para calcular");
		System.out.println("2- Resultado");
	}
	
}

