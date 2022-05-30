package InterfaceVersusClasseAbstrata;

public enum TipoDeEfeito {
    BENCAO(1) {
        @Override
        public void descreverEfeito(String nome) {
            System.out.println();
            System.out.println(nome + " foi abençoado, seu custo caiu pela metade!");
        }
    },
    SOPRO_DA_MORTE(2) {
        @Override
        public void descreverEfeito(String nome) {
            System.out.println();
            System.out.println(nome + "foi abatido!");
        }
    },
    POLIMORFIA(3){
        @Override
        public void descreverEfeito(String nome) {
            System.out.println();
            System.out.println(nome + "virou uma ovelha!");
        }
    },
    CURA(4){
        @Override
        public void descreverEfeito(String nome) {
            System.out.println();
            System.out.println(nome + "foi curado!");
        }
    };

    public final int VALOR;

    TipoDeEfeito(int valor) {
        this.VALOR = valor;
    }

    public abstract void descreverEfeito(String nome);
}
