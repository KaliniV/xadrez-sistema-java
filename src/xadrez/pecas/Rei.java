package xadrez.pecas;

import jogo_de_tabuleiro.Posicao;
import jogo_de_tabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.Peca_de_xadrez;

public class Rei extends Peca_de_xadrez {

	public Rei(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}
	@Override 
	public String toString() {
		return "R";
	}
	private boolean podeMover(Posicao posicao) {
		Peca_de_xadrez peca = (Peca_de_xadrez) getTabuleiro().peca(posicao);
		return peca == null || peca.getCor() != getCor();
	}
	
	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] matriz = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		
		Posicao aux = new Posicao(0, 0);
		
		// acima
		aux.definirValores(posicao.getLinha() - 1, posicao.getColuna());
		if(getTabuleiro().posicaoExistente(aux) && podeMover(aux)) {
			matriz [aux.getLinha()][aux.getColuna()] = true;
		}
		
		// abaixo
		aux.definirValores(posicao.getLinha() + 1, posicao.getColuna());
		if(getTabuleiro().posicaoExistente(aux) && podeMover(aux)) {
			matriz [aux.getLinha()][aux.getColuna()] = true;
		}
		
		// esquerda
		aux.definirValores(posicao.getLinha(), posicao.getColuna() - 1);
		if(getTabuleiro().posicaoExistente(aux) && podeMover(aux)) {
			matriz [aux.getLinha()][aux.getColuna()] = true;
		}
		
		// direita
		aux.definirValores(posicao.getLinha(), posicao.getColuna() + 1);
		if(getTabuleiro().posicaoExistente(aux) && podeMover(aux)) {
			matriz [aux.getLinha()][aux.getColuna()] = true;
		}
		
		// noroeste
		aux.definirValores(posicao.getLinha() -1, posicao.getColuna() - 1);
		if(getTabuleiro().posicaoExistente(aux) && podeMover(aux)) {
			matriz [aux.getLinha()][aux.getColuna()] = true;
		}
		
		// nordeste
		aux.definirValores(posicao.getLinha() -1, posicao.getColuna() + 1);
		if(getTabuleiro().posicaoExistente(aux) && podeMover(aux)) {
			matriz [aux.getLinha()][aux.getColuna()] = true;
		}
		
		// sudoeste
		aux.definirValores(posicao.getLinha() +1, posicao.getColuna() - 1);
		if(getTabuleiro().posicaoExistente(aux) && podeMover(aux)) {
			matriz [aux.getLinha()][aux.getColuna()] = true;
		}
		
		// sudeste
		aux.definirValores(posicao.getLinha() +1, posicao.getColuna() + 1);
		if(getTabuleiro().posicaoExistente(aux) && podeMover(aux)) {
			matriz [aux.getLinha()][aux.getColuna()] = true;
		}
		
		
		return matriz;
	}

}
