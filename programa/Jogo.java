package programa;

import java.util.Scanner;
import entidades.Tabuleiro;

public class Jogo {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Tabuleiro tabuleiro = new Tabuleiro();
		
		System.out.println("Jogador 1 = X");
		System.out.println("Jogador 2 = O");
		tabuleiro.imprimirTabuleiro();
		
		while (tabuleiro.getContagemJogada() <= 9) {
			tabuleiro.jogadaValida = false;
			tabuleiro.decidirJogador();
			int linha = scan.nextInt();
			int coluna = scan.nextInt();
			tabuleiro.colocarPeca(linha-1, coluna-1);
			while (tabuleiro.jogadaValida == false) {
				System.out.println("Posição já ocupada. Entre novamente com a jogada.");
				linha = scan.nextInt();
				coluna = scan.nextInt();
				tabuleiro.jogarNovamente(linha-1, coluna-1);
			}
			tabuleiro.imprimirTabuleiro();
			tabuleiro.adicionarJogada();
			tabuleiro.testarGanhador();
			if (tabuleiro.testarGanhador() == 1) {
				System.out.println("Jogador #1 venceu!");
				break;
			}
			else if (tabuleiro.testarGanhador() == 2) {
				System.out.println("Jogador #2 venceu!");
				break;
			}
		} 
		if (tabuleiro.getContagemJogada() > 9) {
			System.out.println("Empate!");
		}
		
	scan.close();
	}

}
