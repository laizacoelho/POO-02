package SistemaLivraria;

public enum TipoProduto {
    LIVRO (1),
    JOGO(2),
    FILME(3),
    BRINQUEDO(4),
    ALBUM_MUSICAL(5);

    Integer indice;

    TipoProduto(Integer indice) {
        this.indice = indice;
    }
}
