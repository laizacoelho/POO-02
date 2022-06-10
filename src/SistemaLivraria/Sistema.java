package SistemaLivraria;
//https://github.com/rflima11/exercicios-poo2-letscode/tree/main/03%20-%20Sistema%20Livraria

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Sistema {
    public static void main(String[] args) {
        List<Genero> generos = new ArrayList<>();
        generos.add(Genero.ROMANCE);
        generos.add(Genero.COMEDIA);
        List<String> escritores = new ArrayList<>();
        escritores.add("JK");
        Livro livro = new Livro("blah", 10.99,generos,escritores,"intriseca");
        Brinquedo brinquedo = new Brinquedo("barbie", 50, TipoBrinquedo.BONECO);
        Jogo jogo = new Jogo("Zerodown", 299.90, "Sony", generos, "warner");

        Estoque estoque = new Estoque("estoque01");
        GerenciadorEstoque genrenciaEstoque = new GerenciadorEstoque();

        genrenciaEstoque.adicionarProdutoEstoque(estoque,brinquedo,8);
        genrenciaEstoque.adicionarProdutoEstoque(estoque,livro,4);
        genrenciaEstoque.adicionarProdutoEstoque(estoque,jogo,1);

        LocalDate dataNascida = LocalDate.of(1988,3,16);
        Comprador comprador = new Comprador("Laiza", "1501363", "10897719751", dataNascida);
        GerenciadorDeVendas vendedor = new GerenciadorDeVendas();




        Collections.sort(estoque.produtos);
       /* for (Produto produto : estoque.produtos) {
            System.out.println(produto.nome);
            System.out.println(produto.tipoProduto);
            System.out.println();
        } */



    }
}
