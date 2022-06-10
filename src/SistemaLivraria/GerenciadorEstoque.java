package SistemaLivraria;

public class GerenciadorEstoque implements IGerenciadorEstoque{

    @Override
    public void adicionarProdutoEstoque(Estoque estoque, Produto produto, int quantidade) {
        if (estoque.produtoCadastradoNoEstoque(produto.id)) {
            int posicao = estoque.localizarProduto(produto.id);
            int total = estoque.quantidadeProduto.get(posicao) + quantidade;
            estoque.quantidadeProduto.set(posicao,total);
            System.out.println("Este produto já existe no estoque, a sua quantidade foi atulizada.");
        } else {
            estoque.produtos.add(produto);
            estoque.quantidadeProduto.add(quantidade);
            System.out.println("Produto cadastrado no estoque.");
        }
    }

    @Override
    public void deletarProdutoEstoque(Estoque estoque, String idProduto) {
        int posicao = estoque.localizarProduto(idProduto);
        if (posicao >= 0) {
            estoque.produtos.remove(posicao);
            estoque.quantidadeProduto.remove(posicao);
        } else {
            System.out.println("Produto não está cadastrado no estoque");
        }
    }

    @Override
    public void editarQuantidadeProdutoEstoque (Estoque estoque, String idProduto, int novaQuantidade) {
        int posicao = estoque.localizarProduto(idProduto);
        if (posicao >= 0) {
            estoque.quantidadeProduto.set(posicao, novaQuantidade);
            System.out.println("Quantidade editada.");
        } else {
            System.out.println("Produto não está cadastrado no estoque");
        }
    }
}
