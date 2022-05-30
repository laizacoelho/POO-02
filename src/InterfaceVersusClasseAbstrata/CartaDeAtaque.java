package InterfaceVersusClasseAbstrata;

public class CartaDeAtaque extends Carta {
    protected int ataque;
    protected int vida;
    protected int vidaInicial;
    protected boolean estaVivo;

    public CartaDeAtaque(String nome, TipoDeCartas tipo, int custo, int ataque, int vida) {
        super(nome, tipo, custo);
        this.ataque = ataque;
        this.vida = vida;
        this.estaVivo = true;
        this.vidaInicial = vida;
    }

    public void atacarCarta(CartaDeAtaque cartaAtacada) {
        if (cartaAtacada.estaVivo) {
            cartaAtacada.receberAtaque(this.ataque);
        } else{
            System.out.println();
            System.out.println(cartaAtacada.nome + " já foi abatido antes e está fora de combate. Escolha outra carta.");
        }
    }

    public void atacarJogador(Jogador jogadorAtacado) {
        if (jogadorAtacado.isEstaVivo()) {
            jogadorAtacado.receberAtaque(this.ataque);
        } else{
            System.out.println();
            System.out.println(jogadorAtacado.getNome() + " morreu e está fora do Jogo.");
        }
    }

    public void receberAtaque(int ataqueRecebido) {
        this.vida -= ataqueRecebido;
        System.out.println();
        System.out.printf("%s perdeu %d pontos de vida.\n", nome, ataqueRecebido);
        checarVida();
        if(!estaVivo) {
            System.out.println(nome + " foi abatido!");
        }
    }

    public void receberEfeito(TipoDeEfeito efeitoLancado) {
        switch (efeitoLancado.VALOR) {
            case 1 -> this.custo /= 2;
            case 2 -> {
                this.vida = 0;
                checarVida();
            }
            case 3 -> this.ataque = 0;
            case 4 -> this.vida = vidaInicial;
        }
        efeitoLancado.descreverEfeito(this.nome);
    }


    public void exibirCartaDeAtaque() {
        exibirCarta();
        System.out.println("Pontos de ataque: " + ataque);
        System.out.println("Pontos de vida: " + vida);
    }


    public void exibirAtaque() {
        System.out.println("Ataque: " + this.ataque);
    }

    public void exibirVida() {
        System.out.println("Vida: " + this.vida);
    }

    protected void checarVida() {
        estaVivo = vida > 0;
    }
}
