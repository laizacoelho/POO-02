package InterfaceVersusClasseAbstrata;


public class Carta {
    protected String nome;
    protected TipoDeCartas tipo;
    protected int custo;

    public Carta(String nome, TipoDeCartas tipo, int custo) {
        this.nome = nome;
        this.tipo = tipo;
        this.custo = custo;
    }

    public void ExbibirNome(){
        System.out.println("Nome: " + nome);
    }

    public void ExbibirTipo(){
        System.out.println("Tipo: " + tipo);
    }

    public void ExbibirCusto(){
        System.out.println("Custo: " + custo);
    }

    public void exibirCarta() {
        System.out.println();
        System.out.println("===== Carta =====");
        System.out.println("Nome: " + nome);
        System.out.println("Tipo: " + tipo);
        System.out.println("Custo: " + custo);
    }

}
