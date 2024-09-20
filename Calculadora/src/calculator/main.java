package calculator;

import java.util.Scanner;

public class main {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Calculadora");
		System.out.println("Digite o 1° numero: ");
		float num1 = scanner.nextFloat();
		
		System.out.println("Digite o 2° numero: ");
		float num2 = scanner.nextFloat();
		
		System.out.println("Digite a operação que deseja fazer com eles:");
		System.out.println("|1- Soma: + |");
		System.out.println("|2- Subtração: - |");
		System.out.println("|3- Divisão: / |");
		System.out.println("|4- Multiplicação: *|");
		int opcao = scanner.nextInt();
		
		switch(opcao) {
		case 1:
			System.out.println("Resultado: " + operacoes.somar(num1, num2));
			break;
		case 2:
			System.out.println("Resultado: " + operacoes.sub(num1, num2));
			break;
		case 3:
			System.out.println("Resultado: " + operacoes.divi(num1, num2));
			break;
		case 4:
			System.out.println("Resultado: " + operacoes.mult(num1, num2));
			break;
		}
	}

}
