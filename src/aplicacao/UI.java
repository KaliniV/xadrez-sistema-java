package aplicacao;

import xadrez.Peca_de_xadrez;

public class UI {
	
	public static void imprimirTabuleiro(Peca_de_xadrez[][] pecas) {
		
		for (int linha=0; linha <pecas.length; linha++) {
			System.out.print((8-linha) + " ");
			
			for(int coluna=0; coluna < pecas.length; coluna++) {
				imprimirPeca(pecas[linha][coluna]);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}
	private static void imprimirPeca(Peca_de_xadrez peca) {
		if (peca == null) {
			System.out.print("▪");
		}
		else {
			System.out.print(peca);
		}
		System.out.print(" ");
	}
}