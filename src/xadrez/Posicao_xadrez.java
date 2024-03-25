package xadrez;

import jogo_de_tabuleiro.Posicao;

public class Posicao_xadrez {
	
	private char coluna;
	private int linha;
	
	public Posicao_xadrez(char coluna, int linha) {
		if (coluna < 'a' || coluna > 'h' || linha < 1 || linha > 8) {
			throw new XadrezException ("Erro ao instanciar Posicao_xadrez. Os valores válidos são de a1 a h8.");
		}
		this.coluna = coluna;
		this.linha = linha;
	}

	public char getColuna() {
		return coluna;
	}

	public int getLinha() {
		return linha;
	}
	 
	protected Posicao posicionar() {
		return new Posicao (8 - linha, coluna - 'a');
	} 
	protected static Posicao_xadrez daPosicao (Posicao posicao) {
		return new Posicao_xadrez ((char)('a' - posicao.getColuna()), 8 - posicao .getLinha());
	}
	@Override
	public String toString() {
		return "" + coluna + linha;
	}
}
