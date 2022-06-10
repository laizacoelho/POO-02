package SistemaLivraria;

import java.util.List;

public class FilmeAdulto extends Filme{
    private boolean maiorDeIdade;

    public FilmeAdulto(String nome, double preco, String estudio, List<String> diretores, List<Genero> generos, List<String> produtores) {
        super(nome, preco, estudio, diretores, generos, produtores);
        this.maiorDeIdade = true;
        this.tipoProduto = TipoProduto.FILME;
        geradorId();
    }

    public FilmeAdulto(String nome, String estudio, List<String> diretores, List<Genero> generos, List<String> produtores) {
        super(nome, estudio, diretores, generos, produtores);
        this.maiorDeIdade = true;
        this.tipoProduto = TipoProduto.FILME;
        geradorId();
    }

    @Override
    public boolean isProdutoParaAdulto() {
        return false;
    }
}
