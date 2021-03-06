package SistemaLivraria;

import java.util.List;

public class AlbumMusicalAdulto extends AlbumMusical{
    private boolean maiorDeIdade;

    public AlbumMusicalAdulto(String nome, double preco, List<String> musicos, List<String> selos, List<GeneroMusical> generoMusicais) {
        super(nome, preco, musicos, selos, generoMusicais);
        this.maiorDeIdade = true;
        this.tipoProduto = TipoProduto.ALBUM_MUSICAL;
        geradorId();

    }

    public AlbumMusicalAdulto(String nome, double preco) {
        super(nome, preco);
        this.maiorDeIdade = true;
        this.tipoProduto = TipoProduto.ALBUM_MUSICAL;
        geradorId();
    }
}
