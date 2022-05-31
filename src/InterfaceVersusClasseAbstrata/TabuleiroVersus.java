package InterfaceVersusClasseAbstrata;

import java.util.*;

public class TabuleiroVersus extends Tabuleiro {
    private List <Carta> deck01;
    private List <Carta> deck02;



    public TabuleiroVersus() {
        this.deck01 = new ArrayList<>();
        this.deck02 = new ArrayList<>();
        this.jogadores = new ArrayList<>();
        this.numeroCartasPorDeck = 50;
        this.numeroCartasAtaque = 5;
        this.numeroCartasEspeciais = 2;
    }

    @Override
    public void inserirDeck(RepositorioDeCartas jogo) {
        sortearCartas(jogo, deck01);
        sortearCartas(jogo, deck02);
    }

    @Override
    public void verificarGanhador() {
        if (!this.jogadores.get(0).isEstaVivo() && this.jogadores.get(1).isEstaVivo()) {
            System.out.println(this.jogadores.get(1).getNome() + "é o vencedor!");
        } else if (!this.jogadores.get(1).isEstaVivo() && this.jogadores.get(0).isEstaVivo()) {
            System.out.println(this.jogadores.get(0).getNome() + "é o vencedor!");
        }
    }

    @Override
    public void inserirJogadoresNoTabuleiro(List<Jogador> jogadores) {
        this.jogadores.add(jogadores.get(0));
        this.jogadores.add(jogadores.get(1));
    }

    @Override
    public void verificarCartaDeAtaque() {
        int contadorDeCartasAtaque = 0;
        int contadorDeCartasEspeciais = 0;
        List<Carta> cartasNoCampo;

        for (Jogador jogador : this.jogadores) {
            cartasNoCampo = jogador.getCartasNoCampo();
            if (jogador.getContadorDeCartas() >= numeroCartasPorDeck) {
                jogador.setPodeJogarCarta(false);

            } else {
                for (Carta carta : cartasNoCampo) {
                    if (carta instanceof CartaDeAtaque) {
                        if (carta instanceof CartaDeAtaqueEspecial) {
                            contadorDeCartasEspeciais++;
                        } else {
                            contadorDeCartasAtaque++;
                        }
                    }
                }
                if (contadorDeCartasAtaque >= numeroCartasAtaque) {
                    jogador.setPodeJogarCartaAtaque(false);
                }
                if (contadorDeCartasEspeciais >= numeroCartasEspeciais) {
                    jogador.setPodeJogarCartaEspecial(false);
                }
                contadorDeCartasAtaque = 0;
                contadorDeCartasEspeciais = 0;
            }
        }
    }

    public List<Carta> getDeck01() {
        return deck01;
    }

    public List<Carta> getDeck02() {
        return deck02;
    }
}
