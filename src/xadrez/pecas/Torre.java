package xadrez.pecas;

import jogo_de_tabuleiro.Posicao;
import jogo_de_tabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.Peca_de_xadrez;

public class Torre extends Peca_de_xadrez{

	public Torre(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}
	@Override 
	public String toString() {
		return "T";
	}
	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] matriz = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		
		Posicao aux = new Posicao(0, 0);
		
		//Verificar acima da peça
		
		aux.definirValores(posicao.getLinha() - 1, posicao.getColuna());
		while (getTabuleiro().posicaoExistente(aux) && !getTabuleiro().temAPeca(aux)){
			matriz [aux.getLinha()][aux.getColuna()] = true;
			aux.setLinha(aux.getLinha() - 1);
		}
		if (getTabuleiro().posicaoExistente(aux) && existePecaDoOponente(aux)) {
			matriz [aux.getLinha()][aux.getColuna()] = true;
		}
		
		
		//Verificar a esquerda da peça
		
		aux.definirValores(posicao.getLinha(), posicao.getColuna()- 1);
		while (getTabuleiro().posicaoExistente(aux) && !getTabuleiro().temAPeca(aux)){
		   	matriz [aux.getLinha()][aux.getColuna()] = true;
			aux.setColuna(aux.getColuna() - 1);
		}
		if (getTabuleiro().posicaoExistente(aux) && existePecaDoOponente(aux)) {
			matriz [aux.getLinha()][aux.getColuna()] = true;
		}
		
		//Verificar a direita da peça
		
		aux.definirValores(posicao.getLinha(), posicao.getColuna()+1);
		while (getTabuleiro().posicaoExistente(aux) && !getTabuleiro().temAPeca(aux)){
		 	matriz [aux.getLinha()][aux.getColuna()] = true;
			aux.setColuna(aux.getColuna() + 1);
		}
		if (getTabuleiro().posicaoExistente(aux) && existePecaDoOponente(aux)) {
			matriz [aux.getLinha()][aux.getColuna()] = true;
		}
				
		//Verificar abaixo  da peça
		
		aux.definirValores(posicao.getLinha() + 1, posicao.getColuna());
		while (getTabuleiro().posicaoExistente(aux) && !getTabuleiro().temAPeca(aux)){
			matriz [aux.getLinha()][aux.getColuna()] = true;
			aux.setLinha(aux.getLinha() + 1);
		}
		if (getTabuleiro().posicaoExistente(aux) && existePecaDoOponente(aux)) {
			matriz [aux.getLinha()][aux.getColuna()] = true;
		}
		
		
		
		
		
		return matriz;
	}


}
