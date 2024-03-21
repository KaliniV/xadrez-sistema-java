package aplicacao;

import xadrez.Partida_de_xadrez;

public class Programa {

	public static void main(String[] args) {
		Partida_de_xadrez partida_de_xadrez = new Partida_de_xadrez();
		UI.imprimirTabuleiro(partida_de_xadrez.pegarPecas());
		
		
	}

}
