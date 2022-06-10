package SistemaLivraria;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Estoque implements IGeradorId{
    private String nome;
    private String idEstoque;
    List <Produto> produtos;
    List <Integer> quantidadeProduto;

    public Estoque(String nome) {
        this.nome = nome;
        this.produtos = new ArrayList<>();
        this.quantidadeProduto = new ArrayList<>();
        geradorId();
    }

    @Override
    public void geradorId() {
        Date data = new Date();
        DateFormat dataFormatada = new SimpleDateFormat("yyyyMMddHHmmsss");
        this.idEstoque = dataFormatada.format(data);
        this.idEstoque = this.idEstoque.concat(this.nome);
    }

    public int localizarProduto (String idProduto) {
        if (!this.produtos.isEmpty()) {
            for (Produto produto : this.produtos) {
                if (produto.id.equalsIgnoreCase(idProduto)) {
                    return this.produtos.indexOf(produto);
                }
            }
        } return -1;
    }
    public Boolean produtoCadastradoNoEstoque(String idProduto) {
        if (!this.produtos.isEmpty()) {
            for (Produto produto : this.produtos) {
                if (produto.id.equalsIgnoreCase(idProduto)) {
                    return true;
                }
            }
        } return false;
    }

    public void LerEstoque() {
        int indice;
        for (Produto produto : produtos) {
            produto.lerProduto();
            indice = produtos.indexOf(produto);
            System.out.println("Quantidade: " + quantidadeProduto.get(indice));
        }
    }

    public void LerEstoquePorCategoria(TipoProduto tipoProduto) {
        int indice;
        for (Produto produto : produtos) {
            if (produto.tipoProduto.indice == tipoProduto.indice) {
                produto.lerProduto();
                indice = produtos.indexOf(produto);
                System.out.println("Quantidade: " + quantidadeProduto.get(indice));
            }
        }
    }


    public String getNome() {
        return nome;
    }

    public String getIdEstoque() {
        return idEstoque;
    }

}
