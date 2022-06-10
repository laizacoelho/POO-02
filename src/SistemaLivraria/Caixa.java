package SistemaLivraria;


public class Caixa {
    private static double saldoCaixa;

    public Caixa(double saldoCaixa) {
        this.saldoCaixa = saldoCaixa;
    }


    public double getSaldoCaixa() {
        return saldoCaixa;
    }

    public void setSaldoCaixa(double saldoCaixa) {
        this.saldoCaixa = saldoCaixa;
    }

    public static void receberCompra (double valorCompra) {
        saldoCaixa += valorCompra;
    }

}
