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
            jogador01.vincularTabuleiroVersus(tabuleiroVersus);
            jogadores.add(jogador01);

            deck = tabuleiroVersus.getDeck02();
            Jogador jogador02 = new Jogador(nome[1], deck);
            jogador02.vincularTabuleiroVersus(tabuleiroVersus);
            jogadores.add(jogador02);

            tabuleiroVersus.inserirJogadoresNoTabuleiro(jogadores);


        } else {
            tabuleiroParty = new TabuleiroParty();
            tabuleiroParty.inserirDeck(jogo);

            List<Carta> deck = tabuleiroParty.getDeck01();
            Jogador jogador01 = new Jogador(nome[0], deck);
            jogadores.add(jogador01);

            deck = tabuleiroParty.getDeck02();
            Jogador jogador02 = new Jogador(nome[1], deck);
            jogadores.add(jogador02);

            deck = tabuleiroParty.getDeck03();
            Jogador jogador03 = new Jogador(nome[2], deck);
            jogadores.add(jogador03);

            deck = tabuleiroParty.getDeck04();
            Jogador jogador04 = new Jogador(nome[3], deck);
            jogadores.add(jogador04);

            deck = tabuleiroParty.getDeck05();
            Jogador jogador05 = new Jogador(nome[4], deck);
            jogadores.add(jogador05);

            tabuleiroParty.inserirJogadoresNoTabuleiro(jogadores);
        }
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public TabuleiroVersus getTabuleiroVersus() {
        return tabuleiroVersus;
    }

    public TabuleiroParty getTabuleiroParty() {
        return tabuleiroParty;
    }
}
