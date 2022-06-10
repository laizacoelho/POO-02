package SistemaLivraria;

public class GerenciadorDeVendas {

    double desconto = 0;

    public void solicitarVenda (Estoque estoque, Produto produto, int quantidade, Comprador comprador) {
        boolean compraAutorizada;
        compraAutorizada = isVendaAutorizada(comprador, produto);

        boolean compraEspecial;
        if (produto.tipoProduto.indice == 1) {
            compraEspecial = vendaLivroEspecial(estoque, produto, quantidade);
            if(compraAutorizada && compraEspecial) {
                VendedorComDesconto vendedorComDesconto = new VendedorComDesconto();
                vendedorComDesconto.setDesconto(desconto);
                vendedorComDesconto.operacaoVenda(estoque, produto, quantidade);
                desconto = 0;
            } else if (compraAutorizada) {
                Vendedor vendedor = new Vendedor();
                vendedor.operacaoVenda(estoque, produto, quantidade);
            }
        }
    }

    private boolean vendaLivroEspecial(Estoque estoque, Produto produto, int quantidade) {
        if ((produto.preco * quantidade) >= 200) {
            desconto = 0.15;
            return true;
        }
        return false;
    }

    private boolean isVendaAutorizada (Comprador comprador, Produto produto) {
        if (produto.isProdutoParaAdulto()) {
            if (comprador.verificarCompradorAdulto()) {
                return true;
            } else {
                System.out.println("Compra bloqueada. Este produto só pode ser comprado por maiores de 18 anos");
                return false;
            }
        } return true;
    }
}


