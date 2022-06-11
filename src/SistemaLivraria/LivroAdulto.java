package SistemaLivraria;

import java.util.List;

public class LivroAdulto extends Livro{
    private boolean maiorDeIdade;

    public LivroAdulto(String nome, double preco, List<Genero> generos, List<String> escritores, String editora) {
        super(nome, preco, generos, escritores, editora);
        this.maiorDeIdade = true;
        this.tipoProduto = TipoProduto.LIVRO;
        geradorId();
    }

    public LivroAdulto(String nome, double preco) {
        super(nome, preco);
        this.maiorDeIdade = true;
        this.tipoProduto = TipoProduto.LIVRO;
        geradorId();
    }
}
