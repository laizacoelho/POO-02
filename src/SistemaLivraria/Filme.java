package SistemaLivraria;

import java.util.ArrayList;
import java.util.List;

public class Filme extends Produto {
    private String estudio;
    private List<String> diretores = new ArrayList<>();
    private List<Genero> generos = new ArrayList<>();
    private List<String> produtores = new ArrayList<>();

    public Filme(String nome, double preco, String estudio, List<String> diretores, List<Genero> generos, List<String> produtores) {
        super(nome, preco);
        this.estudio = estudio;
        this.diretores = diretores;
        this.generos = generos;
        this.produtores = produtores;
        this.tipoProduto = TipoProduto.FILME;
        geradorId();
    }

    public Filme(String nome, String estudio, List<String> diretores, List<Genero> generos, List<String> produtores) {
        super(nome);
        this.estudio = estudio;
        this.diretores = diretores;
        this.generos = generos;
        this.produtores = produtores;
        this.tipoProduto = TipoProduto.FILME;
        geradorId();
    }

    @Override
    public void lerProduto() {
        System.out.println("===== FILME =====");
        System.out.println("Nome: " + this.nome);
        System.out.println("ID: "+ this.id);
        System.out.println("Preço: R$" + this.preco);
        System.out.println("Estúdio: " + this.estudio);

        if (!this.diretores.isEmpty()) {
            System.out.println("Diretores:");
            for (String diretor : this.diretores) {
                System.out.println(diretor);
            }
        }

        if (!this.generos.isEmpty()) {
            System.out.println("Gêneros:");
            for (Genero genero : this.generos) {
                System.out.println(genero);
            }
        }

        if (!this.produtores.isEmpty()) {
            System.out.println("Produtores:");
            for (String produtor : this.produtores) {
                System.out.println(produtor);
            }
        }
    }

    @Override
    public void editarProduto(Produto produto) {
        if (produto instanceof Filme) {
            produto.id = this.id;
            this.nome = produto.nome;
            this.preco = produto.preco;
            this.estudio = ((Filme) produto).estudio;
            this.diretores = ((Filme) produto).diretores;
            this.generos = ((Filme) produto).generos;
            this.produtores = ((Filme) produto).produtores;

        } else {
            System.out.println("O produto informado não é um filme");
        }
    }

    @Override
    public boolean isProdutoParaAdulto() {
        return false;
    }
}
