package InterfaceVersusClasseAbstrata;

import java.util.List;
import java.util.Random;

public abstract class Tabuleiro {

    protected int numeroCartasPorDeck;
    protected int numeroCartasAtaque;
    protected int numeroCartasEspeciais;
    protected List<Jogador> jogadores;

    Random random = new Random();

    public abstract void inserirDeck(RepositorioDeCartas jogo);

    public abstract void verificarGanhador();

    public abstract void inserirJogadoresNoTabuleiro(List<Jogador> jogadores);

    public abstract void verificarCartaDeAtaque();

    public void sortearCartas(RepositorioDeCartas jogo, List<Carta> deck){
        int quantidadeCartasNoJogo;
        int escolhendoCarta;
        Carta cartaEscolhida;

        quantidadeCartasNoJogo = jogo.baralhoDeCartaSimples.size();
        for(int i = 0; i<numeroCartasPorDeck; i++) {
            escolhendoCarta = random.nextInt(quantidadeCartasNoJogo);
            cartaEscolhida = jogo.baralhoDeCartaSimples.get(escolhendoCarta);
            deck.add(cartaEscolhida);
        }
    }

    public void exbirDeck(List<Carta> deck) {
        for (Carta carta : deck) {
            if (carta instanceof CartaDeAtaqueEspecial) {
                ((CartaDeAtaqueEspecial) carta).exibirCartaDeAtaqueEspecial();
            } else if (carta instanceof CartaDeAtaque) {
                ((CartaDeAtaque) carta).exibirCartaDeAtaque();
            } else {
                carta.exibirCarta();
            }
        }
    }

}
