package InterfaceVersusClasseAbstrata;


import java.util.*;

public class RepositorioDeCartas {
    private List<Carta> cartasSimples = new ArrayList<>();
    private List<CartaDeAtaque> cartasAtaque = new ArrayList<>();
    private List<CartaDeAtaqueEspecial> cartasEspeciais = new ArrayList<>();
    public List <Carta> baralhoDeCartaSimples = new ArrayList<>();

    Random random = new Random();

    public void cartasDoJogo() {
        for (int i=0; i<40; i++) {
            geradorDeCartasSimples();
        }

        for (int i=0; i<25; i++) {
            geradorDeCartasAtaque();
        }

        for (int i=0; i<15; i++) {
            geradorDeCartasEspeciais();
        }
        Collections.shuffle(baralhoDeCartaSimples);
        Collections.shuffle(baralhoDeCartaSimples);
    }

    private void geradorDeCartasSimples() {

        String nome = geradorDeNome();
        TipoDeCartas tipo = geradorDeTipo();
        int custo = geradorDeCusto();
        Carta carta = new Carta(nome, tipo, custo);
        cartasSimples.add(carta);
        baralhoDeCartaSimples.add(carta);
    }

    private void geradorDeCartasAtaque() {
        String nome = geradorDeNome();
        TipoDeCartas tipo = geradorDeTipo();
        int custo = geradorDeCusto();
        int ataque = geradorPontosDeAtaque();
        int vida = geradorPontosDeVida();
        CartaDeAtaque cartaAtaque = new CartaDeAtaque(nome, tipo, custo, ataque, vida);
        cartasAtaque.add(cartaAtaque);
        baralhoDeCartaSimples.add(cartaAtaque);
    }

    private void geradorDeCartasEspeciais() {
        String nome = geradorDeNome();
        TipoDeCartas tipo = geradorDeTipo();
        int custo = geradorDeCusto();
        int ataque = geradorPontosDeAtaque();
        int vida = geradorPontosDeVida();
        TipoDeEfeito efeito = geradorDeEfeito();
        CartaDeAtaqueEspecial cartaDeAtaqueEspecial = new CartaDeAtaqueEspecial(nome, tipo, custo, ataque, vida, efeito);
        cartasEspeciais.add(cartaDeAtaqueEspecial);
        baralhoDeCartaSimples.add(cartaDeAtaqueEspecial);
    }

    private String geradorDeNome() {
        return Integer.toHexString(random.nextInt(1000000));
    }

    private TipoDeCartas geradorDeTipo() {
        int tipo = random.nextInt(3) + 1;
        TipoDeCartas tipoDeCartas;
        if (tipo == 1) {
            tipoDeCartas = TipoDeCartas.CRIATURA;
        } else if (tipo == 2) {
            tipoDeCartas = TipoDeCartas.FEITICO;
        } else {
            tipoDeCartas = TipoDeCartas.ARMA;
        }
        return tipoDeCartas;
    }

    private int geradorDeCusto() {
        return random.nextInt(15) + 11;
    }

    private int geradorPontosDeAtaque() {
        return random.nextInt(10) + 1;
    }

    private  int geradorPontosDeVida() {
        return random.nextInt(20) + 1;
    }

    private TipoDeEfeito geradorDeEfeito() {
        int efeito = random.nextInt(4) + 1;
        TipoDeEfeito tipoDeEfeito = null;
        switch (efeito) {
            case 1 -> tipoDeEfeito = TipoDeEfeito.BENCAO;
            case 2 -> tipoDeEfeito = TipoDeEfeito.SOPRO_DA_MORTE;
            case 3 -> tipoDeEfeito = TipoDeEfeito.POLIMORFIA;
            case 4 -> tipoDeEfeito = TipoDeEfeito.CURA;
        }
        return tipoDeEfeito;
    }

}
