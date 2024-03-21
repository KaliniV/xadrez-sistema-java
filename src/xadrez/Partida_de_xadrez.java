package xadrez;

import jogo_de_tabuleiro.Tabuleiro;

public class Partida_de_xadrez {
	
	private Tabuleiro tabuleiro;
	
	public Partida_de_xadrez() {
		tabuleiro = new Tabuleiro(8, 8);
	}
	
	public  Peca_de_xadrez[][] pegarPecas(){
		Peca_de_xadrez [][] matriz = new Peca_de_xadrez [tabuleiro.getLinhas()][tabuleiro.getColunas()];
		for (int linha=0; linha <tabuleiro.getLinhas(); linha++) {
			for(int coluna=0; coluna < tabuleiro.getColunas(); coluna++) {
				matriz[linha][coluna] = (Peca_de_xadrez)tabuleiro.peca(linha, coluna);
			}
		}
		return matriz;
	}
}