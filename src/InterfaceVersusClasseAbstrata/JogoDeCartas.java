package InterfaceVersusClasseAbstrata;


import java.util.List;
import java.util.Scanner;

public class JogoDeCartas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int menu = 0;
        do {
            System.out.println("============ JOGO DE CARTAS ============");
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Tabuleiro Versus");
            System.out.println("2 - Tabuleiro Party");
            menu = scanner.nextInt();
            scanner.nextLine();

            if (menu == 1) {
                String[] nome = new String[2];
                System.out.println("Informe o nome do jogador 01:");
                nome [0] = scanner.nextLine();
                System.out.println("Informe o nome do jogador 02:");
                nome [1] = scanner.nextLine();

                IniciarJogo novoJogo = new IniciarJogo(1, nome[0], nome[1]);
            }

            if (menu == 2) {
                String[] nome = new String[5];
                for (int i=0; i<5; i++) {
                    System.out.println("Informe o nome do jogador " + (i+1));
                    nome [i] = scanner.nextLine();
                }
                IniciarJogo novoJogo = new IniciarJogo(2, nome[0], nome[1], nome[2], nome[3], nome[4]);
            }
        } while (menu != 1 && menu != 2);
        scanner.close();
        System.out.println("Jogo iniciado");
    }
}
