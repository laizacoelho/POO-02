package InterfaceVersusClasseAbstrata;

public interface IAtaque {

    void atacarCarta (CartaDeAtaque cartaAtacada);
    void atacarJogador (Jogador jogadorAtacado);
    void receberAtaque(int ataqueRecebido);
}
