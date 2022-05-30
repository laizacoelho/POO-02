package InterfaceVersusClasseAbstrata;

public enum TipoDeCartas {
    CRIATURA(1),
    FEITICO(2),
    ARMA(3);

    public final int VALOR;

    TipoDeCartas(int valor) {
        this.VALOR = valor;
    }
}
