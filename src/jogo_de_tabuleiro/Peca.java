package jogo_de_tabuleiro;

public abstract class Peca {

	protected Posicao posicao;
	private Tabuleiro tabuleiro;
	
	public Peca(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		posicao = null;
	}
	
	protected Tabuleiro getTabuleiro() {
		return tabuleiro;
	} 

	public abstract boolean[][] movimentosPossiveis();
	
	public boolean movimentoPossivel(Posicao posicao) {
		return movimentosPossiveis()[posicao.getLinha()][posicao.getColuna()]; 
	}
	
	public boolean existeAlgumMovimentoPossivel() {
		boolean[][] matriz = movimentosPossiveis();
		for (int linha=0; linha<matriz.length; linha++) {
			for (int coluna=0; coluna< matriz.length; coluna++) {
				if(matriz [linha][coluna] ) {
					return true;
					
				}
			}
		
		}
		return false;
	
	}
}
