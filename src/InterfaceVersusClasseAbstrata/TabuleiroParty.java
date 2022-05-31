package InterfaceVersusClasseAbstrata;

import java.util.ArrayList;
import java.util.List;

public class TabuleiroParty extends Tabuleiro {
    private List <Carta> deck01;
    private List <Carta> deck02;
    private List <Carta> deck03;
    private List <Carta> deck04;
    private List <Carta> deck05;

    public TabuleiroParty() {
        this.deck01 = new ArrayList<>();
        this.deck02 = new ArrayList<>();
        this.deck03 = new ArrayList<>();
        this.deck04 = new ArrayList<>();
        this.deck05 = new ArrayList<>();
        this.jogadores = new ArrayList<>();
        this.numeroCartasPorDeck = 80;
        this.numeroCartasAtaque = 34;
    }

    @Override
    public void inserirDeck(RepositorioDeCartas jogo) {
        sortearCartas(jogo, deck01);
        sortearCartas(jogo, deck02);
        sortearCartas(jogo, deck03);
        sortearCartas(jogo, deck04);
        sortearCartas(jogo, deck05);
    }

    @Override
    public void verificarGanhador() {
        int jogadoresVivos = 5;
        for (Jogador jogador : jogadores) {
            if (jogador.isEstaVivo()) {
                jogadoresVivos++;
            }
        }
        if (jogadoresVivos == 1) {
            for (Jogador jogador : jogadores) {
                if (jogador.isEstaVivo()){
                    System.out.println(jogador.getNome() + " venceu!");
                    break;
                }
            }
        }
    }

    @Override
    public void inserirJogadoresNoTabuleiro(List<Jogador> jogadores) {
        this.jogadores.add(jogadores.get(0));
        this.jogadores.add(jogadores.get(1));
        this.jogadores.add(jogadores.get(2));
        this.jogadores.add(jogadores.get(3));
        this.jogadores.add(jogadores.get(4));
    }

    @Override
    public void verificarCartaDeAtaque() {
        int contadorDeCartasAtaque = 0;

        List<Carta> cartasNoCampo;

        for (Jogador jogador : this.jogadores) {
            cartasNoCampo = jogador.getCartasNoCampo();
            if (jogador.getContadorDeCartas() >= numeroCartasPorDeck) {
                jogador.setPodeJogarCarta(false);

            } else {
                for (Carta carta : cartasNoCampo) {
                    if (carta instanceof CartaDeAtaque) {
                            contadorDeCartasAtaque++;
                    }
                }
                if (contadorDeCartasAtaque >= numeroCartasAtaque) {
                    jogador.setPodeJogarCartaAtaque(false);
                }
            }
        }
    }

    public List<Carta> getDeck01() {
        return deck01;
    }

    public List<Carta> getDeck02() {
        return deck02;
    }

    public List<Carta> getDeck03() {
        return deck03;
    }

    public List<Carta> getDeck04() {
        return deck04;
    }

    public List<Carta> getDeck05() {
        return deck05;
    }
}
