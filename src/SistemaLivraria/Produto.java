package SistemaLivraria;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Produto implements IGeradorId, Comparable<Produto> {
    protected String nome;
    protected String id;
    protected double preco;
    protected TipoProduto tipoProduto;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public Produto(String nome) {
        this.nome = nome;
    }

    @Override
    public void geradorId() {
        Date data = new Date();
        DateFormat dataFormatada = new SimpleDateFormat("yyyyMMddHHmmsss");
        this.id = dataFormatada.format(data);
        this.id = this.id.concat(this.nome);
    }

    public abstract void lerProduto();

    public abstract void editarProduto(Produto produto);

    public abstract boolean isProdutoParaAdulto();

    @Override
    public int compareTo(Produto outroProduto) {
        if(this.tipoProduto.indice < outroProduto.tipoProduto.indice) {
            return -1;
        } else if (this.tipoProduto.indice == outroProduto.tipoProduto.indice) {
            return 0;
        } else {
            return 1;
        }
    }
}
