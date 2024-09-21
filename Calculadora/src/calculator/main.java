package calculator;

import java.util.Scanner;
import java.util.Stack;

public class main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- Bem-vindo à Calculadora 20000 ---");
        System.out.println("| Soma: +            |");
        System.out.println("| Subtração: -       |");
        System.out.println("| Divisão: /         |");
        System.out.println("| Multiplicação:   * |");
        System.out.println("| Raiz Quadrada: 2V  |");
        System.out.println("| Potência: ^        |");
        System.out.println("| Porcentagem: %     | \n");
        
        System.out.print("Para realizar sua conta, digite sua conta por completo: \nConta: ");
        String conta = scanner.nextLine(); // Lê a expressão do usuário
        
        try {
            double resultado = avaliar(conta);
            System.out.println("Resultado: " + resultado);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
    
    public static double avaliar(String expressao) throws Exception {
        expressao = expressao.replaceAll("\\s+", ""); // Remove espaços
        return calcular(expressao);
    }

    private static double calcular(String expressao) throws Exception {
        Stack<Double> valores = new Stack<>();
        Stack<Character> operadores = new Stack<>();

        for (int i = 0; i < expressao.length(); i++) {
            char ch = expressao.charAt(i);

            // Se for número
            if (Character.isDigit(ch) || ch == '.') {
                StringBuilder sb = new StringBuilder();
                while (i < expressao.length() && (Character.isDigit(expressao.charAt(i)) || expressao.charAt(i) == '.')) {
                    sb.append(expressao.charAt(i++));
                }
                i--;
                valores.push(Double.parseDouble(sb.toString()));
            } else if (ch == '(') {
                operadores.push(ch);
            } else if (ch == ')') {
                while (operadores.peek() != '(') {
                    valores.push(calcularOperacao(valores.pop(), valores.pop(), operadores.pop()));
                }
                operadores.pop();
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^' || ch == 'V' || ch == '%') {
                while (!operadores.isEmpty() && precedencia(ch) <= precedencia(operadores.peek())) {
                    valores.push(calcularOperacao(valores.pop(), valores.pop(), operadores.pop()));
                }
                operadores.push(ch);
            }
        }

        while (!operadores.isEmpty()) {
            valores.push(calcularOperacao(valores.pop(), valores.pop(), operadores.pop()));
        }

        return valores.pop();
    }

    private static int precedencia(char operador) {
        switch (operador) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            case 'V':
                return 4; // Raiz quadrada
            case '%':
                return 1; // Porcentagem
            default:
                return 0;
        }
    }

    private static double calcularOperacao(double b, double a, char operador) {
        switch (operador) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
            case '^': return Math.pow(a, b); // Potência
            case 'V': return Math.sqrt(b); // Raiz quadrada
            case '%': return a * (b / 100); // Porcentagem
            default: throw new UnsupportedOperationException("Operador inválido: " + operador);
        }
    }
}