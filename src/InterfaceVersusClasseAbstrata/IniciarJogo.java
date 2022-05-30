package InterfaceVersusClasseAbstrata;

import java.util.ArrayList;
import java.util.List;

public class IniciarJogo {

   private RepositorioDeCartas jogo;
    private TabuleiroVersus tabuleiroVersus;
    private TabuleiroParty tabuleiroParty;
    private List<Jogador> jogadores = new ArrayList<>();

    public IniciarJogo(int tipoDeTabuleiro, String... nome) {
        jogo = new RepositorioDeCartas();
        jogo.cartasDoJogo();

        if (tipoDeTabuleiro == 1) {
            tabuleiroVersus = new TabuleiroVersus();
            tabuleiroVersus.inserirDeck(jogo);

            List<Carta> deck = tabuleiroVersus.getDeck01();
            Jogador jogador01 = new Jogador(nome[0], deck);
            jogadores.add(jogador01);

            deck = tabuleiroVersus.getDeck02();
            Jogador jogador02 = new Jogador(nome[1], deck);
            jogadores.add(jogador02);


        } else {
        /*    tabuleiroParty = new TabuleiroParty();
            List deck = tabuleiroParty.getDeck01;


            for (int i=0; i<5; i++) {

                Jogador jogador = new Jogador(nome[i],deck);
            }  */
        }
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }
}
