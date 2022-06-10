package SistemaLivraria;

public class BriquedoAdulto extends Brinquedo{
    private boolean maiorDeIdade;

    public BriquedoAdulto(String nome, double preco, TipoBrinquedo tipo) {
        super(nome, preco, tipo);
        this.maiorDeIdade = true;
        this.tipoProduto = TipoProduto.BRINQUEDO;
        geradorId();
    }

    public BriquedoAdulto(String nome, TipoBrinquedo tipo) {
        super(nome, tipo);
        this.maiorDeIdade = true;
        this.tipoProduto = TipoProduto.BRINQUEDO;
        geradorId();
    }

    @Override
    public boolean isProdutoParaAdulto() {
        return true;
    }
}
