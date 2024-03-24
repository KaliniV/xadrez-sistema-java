package jogo_de_tabuleiro;

public class TabuleiroException extends RuntimeException {
	private static final long serialVersionUID = -5334992803770592464L;

	public TabuleiroException (String mensagem) {
		super(mensagem);
	}
}
