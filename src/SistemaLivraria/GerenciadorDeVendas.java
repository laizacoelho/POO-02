package SistemaLivraria;

public class GerenciadorDeVendas implements IGerenciadorDeVendas {

    double desconto = 0;

    @Override
    public void solicitarVenda (Estoque estoque, Produto produto, int quantidade, Comprador comprador) {
        boolean compraAutorizada;
        compraAutorizada = isVendaAutorizada(comprador, produto);

        boolean compraEspecial;
        compraEspecial = vendaEspecial(estoque, produto, quantidade);

        if (estoque.produtoCadastradoNoEstoque(produto.id)) {
            if(compraAutorizada && compraEspecial) {
                System.out.println("Realizando compra com desconto.");
                VendedorComDesconto vendedorComDesconto = new VendedorComDesconto();
                vendedorComDesconto.setDesconto(desconto);
                vendedorComDesconto.operacaoVenda(estoque, produto, quantidade);
                desconto = 0;
            } else if (compraAutorizada) {
                Vendedor vendedor = new Vendedor();
                vendedor.operacaoVenda(estoque, produto, quantidade);
            }
        } else {
            System.out.println("Produto não cadastrado no estoque");
        }
    }

    @Override
    public boolean vendaEspecial(Estoque estoque, Produto produto, int quantidade) {
        if(produto.tipoProduto.indice == 1) {
            if ((produto.preco * quantidade) >= 200) {
                desconto = 0.15;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isVendaAutorizada (Comprador comprador, Produto produto) {
        boolean isProdutoParaAdulto = false;

        if ((produto instanceof LivroAdulto) ||
                (produto instanceof JogoAdulto) ||
                (produto instanceof FilmeAdulto) ||
                (produto instanceof BrinquedoAdulto) ||
                (produto instanceof AlbumMusicalAdulto)) {
            isProdutoParaAdulto = true;
        }

        if (isProdutoParaAdulto) {
            if (comprador.verificarCompradorAdulto()) {
                return true;
            } else {
                System.out.println("Compra bloqueada. Este produto só pode ser comprado por maiores de 18 anos");
                return false;
            }
        } return true;
    }
}