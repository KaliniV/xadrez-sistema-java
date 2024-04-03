package xadrez;

import jogo_de_tabuleiro.Peca;
import jogo_de_tabuleiro.Posicao;
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
	
	public boolean[][] movimentosPossiveis (Posicao_xadrez posicaoOrigem) {
		Posicao posicao = posicaoOrigem.posicionar();
		validarPosicaoDeOrigem(posicao);
		return  tabuleiro.peca(posicao).movimentosPossiveis();
	}
	
	
	public Peca_de_xadrez executarMovimentoDeXadrez(Posicao_xadrez posicaoDeOrigem, Posicao_xadrez posicaoDeDestino) {
		Posicao origem = posicaoDeOrigem.posicionar();
		Posicao destino = posicaoDeDestino.posicionar();
		validarPosicaoDeOrigem(origem);
		validarPosicaoDeDestino(origem, destino);
		Peca pecaCapturada = FazerMover(origem, destino);
		return (Peca_de_xadrez) pecaCapturada;
	}
	private Peca FazerMover(Posicao origem, Posicao destino) {
		Peca p = tabuleiro.removerPeca(origem);
		Peca pecaCapturada = tabuleiro.removerPeca(destino);
		tabuleiro.lugarDaPeca(p, destino);
		return pecaCapturada;
	}
	
	private void validarPosicaoDeOrigem (Posicao posicao) {
		if (!tabuleiro.temAPeca(posicao)) {
			throw new XadrezException("Não há nenhuma peça na posição de origem");
		}
		if(!tabuleiro.peca(posicao).existeAlgumMovimentoPossivel()) {
			throw new XadrezException("Não há movimentos possíveis para a peça escolhida");	
		}
	}
	
	private void validarPosicaoDeDestino(Posicao origem, Posicao destino) {
		if (!tabuleiro.peca(origem).movimentoPossivel(destino)) {
			throw new XadrezException ("A peça escolhida não pode se mover para a posição de destino.");
		}
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