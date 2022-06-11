package SistemaLivraria;
//https://github.com/rflima11/exercicios-poo2-letscode/tree/main/03%20-%20Sistema%20Livraria

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sistema {
    public static void main(String[] args) {
        Estoque estoque = new Estoque("estoque");
        GerenciadorDeVendas gerenciadorDeVendas = new GerenciadorDeVendas();

        LocalDate dataNascida = LocalDate.of(2009,9,16);
        Comprador comprador = new Comprador("Luana", "1601366", "108378347-57", dataNascida);

        List<Genero> generos = new ArrayList<>();
        generos.add(Genero.ROMANCE);
        generos.add(Genero.COMEDIA);
        List<String> escritores = new ArrayList<>();
        escritores.add("JK");

        Livro livro = new Livro("Harry Potter", 10.99,generos,escritores,"intriseca");
        Brinquedo brinquedo = new Brinquedo("barbie", 50, TipoBrinquedo.BONECO);
        Brinquedo brinquedo2 = new Brinquedo("Root", 50, TipoBrinquedo.TABULEIRO);
        Filme filmeAdulto = new FilmeAdulto("Beleza Americana", 64.95);
        Jogo jogo = new Jogo("Zerodown", 299.90);
        AlbumMusicalAdulto albumMusicalAdulto = new AlbumMusicalAdulto("Artpop", 19.99);



        GerenciadorEstoque.adicionarProdutoEstoque(estoque, livro, 132);
        GerenciadorEstoque.adicionarProdutoEstoque(estoque,brinquedo,8);
        GerenciadorEstoque.adicionarProdutoEstoque(estoque,brinquedo2,2);
        GerenciadorEstoque.adicionarProdutoEstoque(estoque, filmeAdulto, 8);
        GerenciadorEstoque.adicionarProdutoEstoque(estoque,jogo,1);
        GerenciadorEstoque.adicionarProdutoEstoque(estoque,albumMusicalAdulto,13);

        Collections.sort(estoque.produtos);

        gerenciadorDeVendas.solicitarVenda(estoque,albumMusicalAdulto,2, comprador);
        gerenciadorDeVendas.solicitarVenda(estoque,brinquedo,10, comprador);
        gerenciadorDeVendas.solicitarVenda(estoque,brinquedo, 5, comprador);

        GerenciadorEstoque.deletarProdutoEstoque(estoque, livro.id);
        gerenciadorDeVendas.solicitarVenda(estoque,livro,1,comprador);
    }
}
