package xadrez;

import jogo_de_tabuleiro.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class Partida_de_xadrez {
	
	private Tabuleiro tabuleiro;
	
	public Partida_de_xadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		configuracaoInicial();
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
	private void novoLugarPeca( char coluna, int linha, Peca_de_xadrez peca) {
		tabuleiro.lugarDaPeca(peca, new Posicao_xadrez(coluna, linha).posicionar() );
	}
	
	private void configuracaoInicial() {
		novoLugarPeca('c', 1, new Torre (tabuleiro, Cor.BRANCO));
		novoLugarPeca('c', 2, new Torre (tabuleiro, Cor.BRANCO));
		novoLugarPeca('d', 2, new Torre (tabuleiro, Cor.BRANCO));
		novoLugarPeca('e', 2, new Torre (tabuleiro, Cor.BRANCO));
		novoLugarPeca('e', 1, new Torre (tabuleiro, Cor.BRANCO));
		novoLugarPeca('d', 1, new  Rei  (tabuleiro, Cor.BRANCO));
		
	
		novoLugarPeca('c', 7, new Torre (tabuleiro, Cor.PRETO));
		novoLugarPeca('c', 8, new Torre (tabuleiro, Cor.PRETO));
		novoLugarPeca('d', 7, new Torre (tabuleiro, Cor.PRETO));
		novoLugarPeca('e', 7, new Torre (tabuleiro, Cor.PRETO));
		novoLugarPeca('e', 8, new Torre (tabuleiro, Cor.PRETO));
		novoLugarPeca('d', 8, new  Rei  (tabuleiro, Cor.PRETO));
		
		
	}
}