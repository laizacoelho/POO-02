package SistemaLivraria;

import java.util.ArrayList;
import java.util.List;

public class Jogo extends Produto{
    private String distribuidora;
    private List<Genero> generos = new ArrayList<>();
    private String estudio;

    public Jogo(String nome, double preco, String distribuidora, List<Genero> generos, String estudio) {
        super(nome, preco);
        this.distribuidora = distribuidora;
        this.generos = generos;
        this.estudio = estudio;
        this.tipoProduto = TipoProduto.JOGO;
        geradorId();
    }

    public Jogo(String nome, double preco) {
        super(nome, preco);
        this.tipoProduto = TipoProduto.JOGO;
        geradorId();
    }

    @Override
    public void lerProduto() {
        System.out.println("===== JOGO =====");
        System.out.println("Nome: " + this.nome);
        System.out.println("ID: "+ this.id);
        System.out.println("Preço: R$" + this.preco);
        System.out.println("Distribuidora: " + this.distribuidora);
        System.out.println("Estúdio: " + this.estudio);

        if (!this.generos.isEmpty()) {
            System.out.println("Gêneros:");
            for (Genero genero : this.generos) {
                System.out.println(generos);
            }
        }
    }

    @Override
    public void editarProduto(Produto produto) {
        if (produto instanceof Jogo) {
            produto.id = this.id;
            this.nome = produto.nome;
            this.preco = produto.preco;
            this.distribuidora = ((Jogo) produto).distribuidora;
            this.estudio = ((Jogo) produto).estudio;
            generos = ((Jogo) produto).generos;

        } else {
            System.out.println("O produto informado não é um jogo");
        }
    }
}
