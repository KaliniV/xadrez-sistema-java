package xadrez.pecas;

import jogo_de_tabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.Peca_de_xadrez;

public class Torre extends Peca_de_xadrez{

	public Torre(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}
	@Override 
	public String toString() {
		return "♜";
	}

}
