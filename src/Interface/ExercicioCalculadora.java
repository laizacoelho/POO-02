package Interface;

//https://github.com/rflima11/exercicios-poo2-letscode/tree/main/01%20-%20Calculadora

import java.util.Scanner;

public class ExercicioCalculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int menu;
        double numero01;
        double numero02;
        boolean sair = false;
        while (!sair) {
            do {
                System.out.println("Calculadora");
                System.out.println("Informe o primeiro número");
                numero01 = scanner.nextDouble();
                System.out.println("Informe o segundo número");
                numero02 = scanner.nextDouble();
                System.out.println("Escolha a operação");
                System.out.println("1 - Soma");
                System.out.println("2 - Subtração");
                System.out.println("3 - Multiplicação");
                System.out.println("4 - Divisão");
                System.out.println("5 - Sair");
                menu = scanner.nextInt();
            } while (menu < 0  || menu > 5);

            switch(menu){
                case(1) -> {
                    Soma soma = new Soma();
                    soma.calcular(numero01, numero02);
                }
                case(2) -> {
                    Subtracao subtracao = new Subtracao();
                    subtracao.calcular(numero01, numero02);
                }
                case(3) -> {
                    Multiplicacao multiplicacao = new Multiplicacao();
                    multiplicacao.calcular(numero01, numero02);
                }
                case(4) -> {
                    Divisao divisao = new Divisao();
                    divisao.calcular(numero01, numero02);
                }
                case(5) -> {
                    System.out.println("Calculadora encerrada");
                    sair = true;
                    scanner.close();
                }
            }
        }
    }
}
