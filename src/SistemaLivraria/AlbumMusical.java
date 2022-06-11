package SistemaLivraria;

import java.util.ArrayList;
import java.util.List;

public class AlbumMusical extends Produto {
    private List<String> musicos = new ArrayList<>();
    private List<String> selos = new ArrayList<>();
    private List<GeneroMusical> generoMusicais = new ArrayList<>();

    public AlbumMusical(String nome, double preco, List<String> musicos, List<String> selos, List<GeneroMusical> generoMusicais) {
        super(nome, preco);
        this.musicos = musicos;
        this.selos = selos;
        this.generoMusicais = generoMusicais;
        this.tipoProduto = TipoProduto.ALBUM_MUSICAL;
        geradorId();
    }

    public AlbumMusical(String nome, double preco) {
        super(nome, preco);
        this.tipoProduto = TipoProduto.ALBUM_MUSICAL;
        geradorId();
    }

    @Override
    public void lerProduto() {
        System.out.println("===== ALBUM DE MÚSICA =====");
        System.out.println("Nome: " + this.nome);
        System.out.println("ID: " + this.id);
        System.out.println("Preço: R$" + this.preco);

        if (!this.musicos.isEmpty()) {
            System.out.println("Músicos:");
            for (String musico : this.musicos) {
                System.out.println(musico);
            }
        }

        if (!this.generoMusicais.isEmpty()) {
            System.out.println("Gêneros:");
            for (GeneroMusical genero : this.generoMusicais) {
                System.out.println(genero);
            }
        }

        if (!this.selos.isEmpty()) {
            System.out.println("Selos:");
            for (String selo : this.selos) {
                System.out.println(selo);
            }
        }
    }

    @Override
    public void editarProduto(Produto produto) {
        if (produto instanceof AlbumMusical) {
            this.nome = produto.nome;
            this.preco = produto.preco;
            this.musicos = ((AlbumMusical) produto).musicos;
            this.generoMusicais = ((AlbumMusical) produto).generoMusicais;
            this.selos = ((AlbumMusical) produto).selos;

        } else {
            System.out.println("O produto informado não é um album de músicas");
        }

    }

}
