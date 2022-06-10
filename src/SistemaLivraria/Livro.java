package SistemaLivraria;

import java.util.ArrayList;
import java.util.List;

public class Livro extends Produto {
    private List<Genero> generos = new ArrayList<>();
    private List<String> escritores = new ArrayList<>();
    private String editora;

    public Livro(String nome, double preco, List<Genero> generos, List<String> escritores, String editora) {
        super(nome, preco);
        this.generos = generos;
        this.escritores = escritores;
        this.editora = editora;
        this.tipoProduto = TipoProduto.LIVRO;
        geradorId();
    }

    public Livro(String nome, List<Genero> generos, List<String> escritores, String editora) {
        super(nome);
        this.generos = generos;
        this.escritores = escritores;
        this.editora = editora;
        this.tipoProduto = TipoProduto.LIVRO;
        geradorId();
    }

    @Override
    public void lerProduto() {
        System.out.println("===== LIVRO =====");
        System.out.println("Nome: " + this.nome);
        System.out.println("ID: "+ this.id);
        System.out.println("Preço: R$" + this.preco);
        System.out.println("Editora: " + this.editora);

        if (!this.escritores.isEmpty()) {
            System.out.println("Escritores:");
            for (String escritor : this.escritores) {
                System.out.println(escritor);
            }
        }

        if (!this.generos.isEmpty()) {
            System.out.println("Gêneros:");
            for (Genero genero : this.generos) {
                System.out.println(genero);
            }
        }
    }

    @Override
    public void editarProduto(Produto produto) {
        if (produto instanceof Livro) {
            produto.id = this.id;
            nome = produto.nome;
            preco = produto.preco;
            editora = ((Livro) produto).editora;
            escritores = ((Livro) produto).escritores;
            generos = ((Livro) produto).generos;

        } else {
            System.out.println("O produto informado não é um livro");
        }
    }

    @Override
    public boolean isProdutoParaAdulto() {
        return false;
    }
}
