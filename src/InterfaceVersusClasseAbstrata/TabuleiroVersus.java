package InterfaceVersusClasseAbstrata;

import java.util.*;

public class TabuleiroVersus implements ITabuleiro{
    private List <Carta> deck01;
    private List <Carta> deck02;
    private int numeroCartasPorDeck;
    private int numeroCartasAtaque;
    private int numeroCartasEspeciais;
    private List<Jogador> jogadores;

    Random random = new Random();

    public TabuleiroVersus() {
        this.deck01 = new ArrayList<>();
        this.deck02 = new ArrayList<>();
        this. jogadores = new ArrayList<>();
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
    public void receberVerificarCartaDeAtaque() {
        int contadorDeCartasAtaque = 0;
        int contadorDeCartasEspeciais = 0;
        boolean podeJogarCarta = true;
        boolean podeJogarCartaAtaque = true;
        boolean podeJogarCartaEspecial = true;
        List<Carta> cartasNoCampo;

        for (Jogador jogador : this.jogadores) {
            cartasNoCampo = jogador.getCartasNoCampo();
            if (jogador.getContadorDeCartas() == 50) {
                System.out.println(jogador.getNome() + " não tem mais carta para jogar no campo");
                podeJogarCarta = false;

            }
            for (Carta carta : cartasNoCampo) {
                if (carta instanceof CartaDeAtaque) {
                    if (carta instanceof CartaDeAtaqueEspecial) {
                        contadorDeCartasEspeciais++;
                    } else {
                        contadorDeCartasAtaque++;
                    }
                }
            }
            if (contadorDeCartasAtaque >= 5) {
                System.out.println(jogador.getNome() + " não pode inserir mais carta de ataque no campo");
                podeJogarCartaAtaque = false;
            }
            if (contadorDeCartasEspeciais >= 2) {
                System.out.println(jogador.getNome() + " não pode mais inserir carta de ataque especial no campo");
                podeJogarCartaEspecial = false;
            }
            contadorDeCartasAtaque = 0;
            contadorDeCartasEspeciais = 0;
            podeJogarCarta = true;
            podeJogarCartaAtaque = true;
            podeJogarCartaEspecial = true;
        }
    }

    @Override
    public void verificarGanhador() {
        if (this.jogadores.get(0).isEstaVivo()) {
            System.out.println(this.jogadores.get(1).getNome() + "é o vencedor!");
        }
        if (this.jogadores.get(1).isEstaVivo()) {
            System.out.println(this.jogadores.get(0).getNome() + "é o vencedor!");
        }
    }

    @Override
    public void sortearCartas(RepositorioDeCartas jogo, List <Carta> deck) {
        int quantidadeCartasNoJogo;
        int escolhendoCarta;
        Carta cartaEscolhida;

        quantidadeCartasNoJogo = jogo.baralhoDeCartas.size();
        for(int i = 0; i<numeroCartasPorDeck; i++) {
            escolhendoCarta = random.nextInt(quantidadeCartasNoJogo);
            cartaEscolhida = jogo.baralhoDeCartas.get(escolhendoCarta);
            deck.add(cartaEscolhida);
        }
    }

    @Override
    public void exbirDeck(List<Carta> deck) {
        for (Carta carta : deck) {
            if (carta instanceof  CartaDeAtaqueEspecial) {
                ((CartaDeAtaqueEspecial) carta).exibirCartaDeAtaqueEspecial();
            } else if (carta instanceof  CartaDeAtaque) {
                ((CartaDeAtaque) carta).exibirCartaDeAtaque();
            } else {
                carta.exibirCarta();
            }
        }
    }

    @Override
    public void inserirJogadoresNoTabuleiro(List<Jogador> jogadores) {
        this.jogadores.add(jogadores.get(0));
        this.jogadores.add(jogadores.get(1));
    }

    public List<Carta> getDeck01() {
        return deck01;
    }

    public List<Carta> getDeck02() {
        return deck02;
    }
}
