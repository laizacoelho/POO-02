package SistemaLivraria;

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

        Vendedor vendedor = new Vendedor();



        Collections.sort(estoque.produtos);
       /* for (Produto produto : estoque.produtos) {
            System.out.println(produto.nome);
            System.out.println(produto.tipoProduto);
            System.out.println();
        } */



    }
}
