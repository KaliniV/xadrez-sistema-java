package jogo_de_tabuleiro;

public class Tabuleiro {

	private int linhas;
	private int colunas;
	
	private Peca [][] pecas;

	public Tabuleiro(int linhas, int colunas) {
		
		if(linhas < 1 || colunas < 1) {
			throw new TabuleiroException("Erro ao criar o tabuleiro: deve haver pelo menos 1 linha e 1 coluna.");
		}
		
		this.linhas = linhas;
		this.colunas = colunas;
		pecas = new Peca [linhas][colunas];
	}

	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}
	
	public Peca peca(int linha, int coluna) {
		
		if (!posicaoExistente(linha, coluna)) {
			throw new TabuleiroException("Posição fora do tabuleiro.");
		}
		
		return pecas[linha][coluna];
	}
	public Peca peca(Posicao posicao) {		
		if (!posicaoExistente(posicao)) {
			throw new TabuleiroException("Posição fora do tabuleiro.");
		}
		
		return pecas[posicao.getLinha()][posicao.getColuna()];
	}
	
	public void lugarDaPeca (Peca peca, Posicao posicao) {
		
		if (temAPeca(posicao)) {
			throw new TabuleiroException("Já existe uma peça nesta posição " + posicao);
		}
		
		pecas [posicao.getLinha()][posicao.getColuna()] = peca;
		peca.posicao = posicao;
	}
	
	public boolean posicaoExistente(int linha, int coluna) {
			return linha >=0 && linha < linhas && coluna >= 0 && coluna < colunas;
		}
	
	public boolean posicaoExistente(Posicao posicao) {
		return posicaoExistente (posicao.getLinha(), posicao.getColuna());
	}
	
	public boolean temAPeca(Posicao posicao) {
		if (!posicaoExistente(posicao)) {
			throw new TabuleiroException("Posição fora do tabuleiro.");
		}
		return peca(posicao) != null;
	}
}
