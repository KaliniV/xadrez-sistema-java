package xadrez;

import jogo_de_tabuleiro.TabuleiroException;

public class XadrezException extends TabuleiroException {
	private static final long serialVersionUID = 225521922405223788L;

	public XadrezException (String mensagem) {
		super(mensagem);
		
	}
}
