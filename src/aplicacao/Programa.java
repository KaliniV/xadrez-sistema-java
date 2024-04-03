package aplicacao;

import java.util.InputMismatchException;
import java.util.Scanner;

import xadrez.Partida_de_xadrez;
import xadrez.Peca_de_xadrez;
import xadrez.Posicao_xadrez;
import xadrez.XadrezException;

public class Programa {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		Partida_de_xadrez partida_de_xadrez = new Partida_de_xadrez();
		
		while(true) {
			try {
			
			UI.clearScreen();
			UI.imprimirTabuleiro(partida_de_xadrez.pegarPecas());
			System.out.println();
			System.out.print("Origem: ");
			Posicao_xadrez origem = UI.leiaAPosicaoDoXadrez(sc);
			
			System.out.println();
			System.out.print("Destino: ");
			Posicao_xadrez destino = UI.leiaAPosicaoDoXadrez(sc);
			
			Peca_de_xadrez pecaCapturada = partida_de_xadrez.executarMovimentoDeXadrez(origem, destino);
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
