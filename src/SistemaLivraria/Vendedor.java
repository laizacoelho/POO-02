package SistemaLivraria;

public class Vendedor implements IVendedor{

    public void operacaoVenda (Estoque estoque, Produto produtoVendido, int quantidadeVendida) {
        int indice;
        int quantidadeAtualizada;
        for (Produto produto : estoque.produtos) {
            if (produto.id.equalsIgnoreCase(produtoVendido.id)) {
                indice = estoque.produtos.indexOf(produto);
                quantidadeAtualizada = estoque.quantidadeProduto.get(indice) - quantidadeVendida;
                if (quantidadeAtualizada < 0) {
                    System.out.println("Não existe esta quantidade no estoque");
                    System.out.println("A quantidade deste item no estoque é " + estoque.quantidadeProduto.get(indice));
                } else {
                    GerenciadorEstoque.editarQuantidadeProdutoEstoque(estoque, produtoVendido.id, quantidadeAtualizada);
                    double valorVenda = produtoVendido.preco * quantidadeVendida;
                    Caixa.receberCompra(valorVenda);
                    System.out.println("Produto: " + produtoVendido.nome + " vendido.");
                    System.out.println(("Quantidade: " + quantidadeVendida));
                    System.out.println("Quantidade ainda disponível no estoque: " + quantidadeAtualizada);
                }
            }
        }
    }
}
