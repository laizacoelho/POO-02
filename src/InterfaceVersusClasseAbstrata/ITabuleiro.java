package InterfaceVersusClasseAbstrata;

import java.util.ArrayList;
import java.util.List;

public interface ITabuleiro {

    void inserirDeck(RepositorioDeCartas jogo);
    void receberVerificarCartaDeAtaque();
    void verificarGanhador();
    void sortearCartas(RepositorioDeCartas jogo, List<Carta> deck);
    void exbirDeck(List<Carta> deck);
    void inserirJogadoresNoTabuleiro(List<Jogador> jogadores);
}
