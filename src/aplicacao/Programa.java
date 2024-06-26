package aplicacao;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import xadrez.Partida_de_xadrez;
import xadrez.Peca_de_xadrez;
import xadrez.Posicao_xadrez;
import xadrez.XadrezException;

public class Programa {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		Partida_de_xadrez partida_de_xadrez = new Partida_de_xadrez();
		List<Peca_de_xadrez> capturadas = new ArrayList<>();
		
		
		while(true) {
			try {
			
			UI.clearScreen();
			UI.imprimirPartida(partida_de_xadrez, capturadas);
			System.out.println();
			System.out.print("Origem: ");
			Posicao_xadrez origem = UI.leiaAPosicaoDoXadrez(sc);
			
			boolean [][] movimentosPossiveis = partida_de_xadrez.movimentosPossiveis(origem);
		
			UI.clearScreen();
			UI.imprimirTabuleiro(partida_de_xadrez.pegarPecas(), movimentosPossiveis);
			
			System.out.println();
			System.out.print("Destino: ");
			Posicao_xadrez destino = UI.leiaAPosicaoDoXadrez(sc);
			
			Peca_de_xadrez pecaCapturada = partida_de_xadrez.executarMovimentoDeXadrez(origem, destino);
			
			if (pecaCapturada != null) {
				capturadas.add(pecaCapturada);
			}
			}
			catch(XadrezException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
	}
}
