package SistemaLivraria;

public class Brinquedo extends Produto {
    private TipoBrinquedo tipo;

    public Brinquedo(String nome, double preco, TipoBrinquedo tipo) {
        super(nome, preco);
        this.tipo = tipo;
        this.tipoProduto = TipoProduto.BRINQUEDO;
        geradorId();
    }

    public Brinquedo(String nome, TipoBrinquedo tipo) {
        super(nome);
        this.tipo = tipo;
        this.tipoProduto = TipoProduto.BRINQUEDO;
        geradorId();
    }

    @Override
    public void lerProduto() {
        System.out.println("===== BRINQUEDO =====");
        System.out.println("Nome: " + this.nome);
        System.out.println("ID: "+ this.id);
        System.out.println("Preço: R$" + this.preco);
        System.out.println("Tipo: " + this.tipo);
    }

    @Override
    public void editarProduto(Produto produto) {
        if (produto instanceof Brinquedo) {
            produto.id = this.id;
            this.nome = produto.nome;
            this.preco = produto.preco;
            this.tipo = ((Brinquedo) produto).tipo;

        } else {
            System.out.println("O produto informado não é um brinquedo");
        }
    }

    @Override
    public boolean isProdutoParaAdulto() {
        return false;
    }
}
