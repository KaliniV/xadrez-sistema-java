package xadrez.pecas;

import jogo_de_tabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.Peca_de_xadrez;

public class Rei extends Peca_de_xadrez {

	public Rei(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}
	@Override 
	public String toString() {
		if(getCor() == Cor.BRANCO)  {
			return "♔";
		}
		else {
		return "♚";
		}
	}

}
