package SistemaLivraria;

import java.time.LocalDate;
import java.time.Period;

public class Comprador {
    private String nome;
    private String rg;
    private String cpf;
    private LocalDate dataNascimento;

    public Comprador(String nome, String rg, String cpf, LocalDate dataNascimento) {
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public boolean verificarCompradorAdulto() {
        LocalDate hoje = LocalDate.now();
        Period periodo = Period.between(dataNascimento, hoje);
        int anos = periodo.getYears();

        if (anos < 18) {
            return false;
        } else {
            return true;
        }
    }
}
