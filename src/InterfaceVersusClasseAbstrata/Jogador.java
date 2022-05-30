package InterfaceVersusClasseAbstrata;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
    private String nome;
    private List<Carta> cartasDoDeckDoJogador;
    private List<Carta> cartasNoCampo;
    private int vida;
    private boolean estaVivo;
    private int contadorDeCartas;

    public Jogador(String nome, List<Carta> cartasDoDeckDoJogador) {
        this.nome = nome;
        this.vida = 50;
        this.cartasDoDeckDoJogador = cartasDoDeckDoJogador;
        this.cartasNoCampo = new ArrayList<>();
        this.contadorDeCartas = 0;
    }

    public void receberAtaque(int ataqueRecebido) {
        this.vida -= ataqueRecebido;
        System.out.println();
        System.out.printf("%s perdeu %d pontos de vida.\n", nome, ataqueRecebido);
        checarVida();
        if(!estaVivo) {
            System.out.println(nome + " morreu e perdeu o jogo!");
        }
    }

    public void jogarCartaNoCampo() {
        contadorDeCartas++;
        Carta carta = cartasDoDeckDoJogador.get(contadorDeCartas-1);
        cartasNoCampo.add(carta);
    }

    public void checarVida() {
        estaVivo = vida > 0;
    }

    public String getNome() {
        return nome;
    }

    public List<Carta> getCartasNoCampo() {
        return cartasNoCampo;
    }

    public boolean isEstaVivo() {
        return estaVivo;
    }

    public int getContadorDeCartas() {
        return contadorDeCartas;
    }
}
