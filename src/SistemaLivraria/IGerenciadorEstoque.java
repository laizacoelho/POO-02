package SistemaLivraria;

public interface IGerenciadorEstoque {
    void adicionarProdutoEstoque(Estoque estoque, Produto produto, int quantidade);
    void deletarProdutoEstoque(Estoque estoque, String idProduto);
    void editarQuantidadeProdutoEstoque (Estoque estoque, String idProduto, int novaQuantidade);
}
