package SistemaLivraria;

import java.util.List;

public class JogoAdulto extends Jogo{
    private boolean maiorDeIdade;

    public JogoAdulto(String nome, double preco, String distribuidora, List<Genero> generos, String estudio) {
        super(nome, preco, distribuidora, generos, estudio);
        this.maiorDeIdade = true;
        this.tipoProduto = TipoProduto.JOGO;
        geradorId();
    }

    public JogoAdulto(String nome, double preco) {
        super(nome, preco);
        this.maiorDeIdade = true;
        this.tipoProduto = TipoProduto.JOGO;
        geradorId();
    }
}
