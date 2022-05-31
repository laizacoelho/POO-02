package InterfaceVersusClasseAbstrata;

import java.util.ArrayList;
import java.util.List;

public class Jogador implements IAtaque {
    private String nome;
    private List<Carta> cartasDoDeckDoJogador;
    private List<Carta> cartasNoCampo;
    private int ataque;
    private int vida;
    private boolean estaVivo;
    private int contadorDeCartas;
    private boolean podeJogarCarta;
    private boolean podeJogarCartaAtaque;
    private boolean podeJogarCartaEspecial;
    private TabuleiroVersus tabuleiroDaPartidaVersus;
    private TabuleiroParty tabuleiroDaPartidaParty;
    private int aux;

    public Jogador(String nome, List<Carta> cartasDoDeckDoJogador) {
        this.nome = nome;
        this.vida = 50;
        this. estaVivo = true;
        this.cartasDoDeckDoJogador = cartasDoDeckDoJogador;
        this.cartasNoCampo = new ArrayList<>();
        this.contadorDeCartas = 0;
        this.ataque = 5;
        this.podeJogarCarta = true;
        this.podeJogarCartaAtaque = true;
        this.podeJogarCartaEspecial = true;
        this.aux = 0;
    }

    @Override
    public void atacarCarta(CartaDeAtaque cartaAtacada) {
        if (cartaAtacada.estaVivo) {
            cartaAtacada.receberAtaque(this.ataque);
        } else{
            System.out.println();
            System.out.println(cartaAtacada.nome + " já foi abatido antes e está fora de combate. Escolha outra carta.");
        }
    }

    @Override
    public void atacarJogador(Jogador jogadorAtacado) {
        if (jogadorAtacado.isEstaVivo()) {
            jogadorAtacado.receberAtaque(this.ataque);
        } else{
            System.out.println();
            System.out.println(jogadorAtacado.getNome() + " morreu e está fora do jogo.");
        }
    }

    @Override
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
        if (this.tabuleiroDaPartidaVersus != null) {
            this.tabuleiroDaPartidaVersus.verificarCartaDeAtaque();
        } else {
            this.tabuleiroDaPartidaParty.verificarCartaDeAtaque();
        }
        if (podeJogarCarta) {
            aux++;
            int tamanhoMaximo = cartasDoDeckDoJogador.size();
            if (aux-1 < tamanhoMaximo) {
                Carta carta = cartasDoDeckDoJogador.get(aux-1);
                if (carta instanceof CartaDeAtaque) {
                    if (carta instanceof CartaDeAtaqueEspecial) {
                        if (podeJogarCartaEspecial) {
                            cartasNoCampo.add(carta);
                            contadorDeCartas++;
                            System.out.println();
                            System.out.println("Carta jogada no campo");
                            ((CartaDeAtaqueEspecial) carta).exibirCartaDeAtaqueEspecial();
                        } else {
                            System.out.println();
                            System.out.println(nome + " não pode inserir mais carta de ataque especial no campo");
                        }
                    } else {
                        if (podeJogarCartaAtaque) {
                            cartasNoCampo.add(carta);
                            contadorDeCartas++;
                            System.out.println();
                            System.out.println("Carta jogada no campo");
                            ((CartaDeAtaque) carta).exibirCartaDeAtaque();
                        } else {
                            System.out.println();
                            System.out.println(nome + " não pode inserir mais carta de ataque no campo");
                        }
                    }
                } else {
                    cartasNoCampo.add(carta);
                    contadorDeCartas++;
                    System.out.println();
                    System.out.println("Carta jogada no campo");
                    carta.exibirCarta();
                }
            } else {
                System.out.println();
                System.out.println(nome + " não tem mais carta para jogar no campo");
            }
        } else {
            System.out.println();
            System.out.println(nome + " não tem mais carta para jogar no campo");
        }
    }

    public void vincularTabuleiroVersus (TabuleiroVersus tabuleiroDaPartidaVersus) {
        this.tabuleiroDaPartidaVersus = tabuleiroDaPartidaVersus;
    }

    public void vincularTabuleiroParty (TabuleiroParty tabuleiroDaPartidaParty) {
        this.tabuleiroDaPartidaParty = tabuleiroDaPartidaParty;
    }

    public void exibirJogador() {
        System.out.println();
        System.out.println("Jogador: " + this.nome);
        System.out.println("Vida: "+ this.vida);
        System.out.println("Deck da " + this.nome + ":");
        for (Carta carta : cartasDoDeckDoJogador) {
            if (carta instanceof CartaDeAtaqueEspecial) {
                ((CartaDeAtaqueEspecial) carta).exibirCartaDeAtaqueEspecial();
            } else if (carta instanceof CartaDeAtaque) {
                ((CartaDeAtaque) carta).exibirCartaDeAtaque();
            } else {
                carta.exibirCarta();
            }
        }
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

    public void setPodeJogarCarta(boolean podeJogarCarta) {
        this.podeJogarCarta = podeJogarCarta;
    }

    public void setPodeJogarCartaAtaque(boolean podeJogarCartaAtaque) {
        this.podeJogarCartaAtaque = podeJogarCartaAtaque;
    }

    public void setPodeJogarCartaEspecial(boolean podeJogarCartaEspecial) {
        this.podeJogarCartaEspecial = podeJogarCartaEspecial;
    }
}
