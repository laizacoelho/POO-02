package SistemaLivraria;

public interface IGerenciadorDeVendas {
    void solicitarVenda (Estoque estoque, Produto produto, int quantidade, Comprador comprador);
    boolean vendaEspecial(Estoque estoque, Produto produto, int quantidade);
    boolean isVendaAutorizada (Comprador comprador, Produto produto);

}
