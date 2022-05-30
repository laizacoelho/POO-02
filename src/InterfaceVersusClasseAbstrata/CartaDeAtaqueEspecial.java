package InterfaceVersusClasseAbstrata;

public class CartaDeAtaqueEspecial extends CartaDeAtaque{

    private TipoDeEfeito efeito;

    public CartaDeAtaqueEspecial(String nome, TipoDeCartas tipo, int custo, int ataque, int vida, TipoDeEfeito efeito) {
        super(nome, tipo, custo, ataque, vida);
        this.efeito = efeito;
    }

    public void aplicarEfeito(CartaDeAtaque cartaAfetada){
        cartaAfetada.receberEfeito(this.efeito);
    }

    public void exibirEfeito() {
        System.out.println("Efeito: " + efeito);
    }

    public void exibirCartaDeAtaqueEspecial() {
        exibirCartaDeAtaque();
        System.out.println("Efeito: " + efeito);
    }

    public TipoDeEfeito getEfeito() {
        return efeito;
    }
}
