package SistemaLivraria;

public class BrinquedoAdulto extends Brinquedo{
    private boolean maiorDeIdade;

    public BrinquedoAdulto(String nome, double preco, TipoBrinquedo tipo) {
        super(nome, preco, tipo);
        this.maiorDeIdade = true;
        this.tipoProduto = TipoProduto.BRINQUEDO;
        geradorId();
    }

    public BrinquedoAdulto(String nome, double preco) {
        super(nome, preco);
        this.maiorDeIdade = true;
        this.tipoProduto = TipoProduto.BRINQUEDO;
        geradorId();
    }
}
