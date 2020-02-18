package entidades;


public class Tabuleiro {
	
	private String[][] tabuleiro;
	private int linha;
	private int coluna;
	private int contagemJogada;
	public boolean jogadaValida;
	
	public Tabuleiro() {
		contagemJogada = 1;
		linha = 3;
		coluna = 3;
		tabuleiro = new String[linha][coluna];
		
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro[i].length; j++) {
				tabuleiro[i][j] = " ";
			}
		}
	}

	public int getLinha() {
		return linha;
	}

	public int getColuna() {
		return coluna;
	}

	public int getContagemJogada() {
		return contagemJogada;
	}

	public String[][] getTabuleiro() {
		return tabuleiro;
	}


	public String[][] imprimirTabuleiro() {
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro[i].length; j++) {
				System.out.print("|");
				System.out.print(" " + tabuleiro[i][j] + " ");
			}
			System.out.print("|");
			System.out.println();
		}
		return tabuleiro;
	}
	
	
	public void colocarPeca(int linha, int coluna) {
		if (contagemJogada % 2 != 0 ) {
			if (tabuleiro[linha][coluna] == " ") {
				tabuleiro[linha][coluna] = "X";
				jogadaValida = true;
			}
			else {
				jogadaValida = false;
			}
		}
		else {
			 if (tabuleiro[linha][coluna] == " ") {
				tabuleiro[linha][coluna] = "O";
				jogadaValida = true;
			}
			else {
				jogadaValida = false;
			}
		}
	}
	
	
	public void adicionarJogada() {
		contagemJogada++;
	}
	
	public void decidirJogador() {
		if (contagemJogada % 2 != 0) {
			System.out.println("Vez do jogador #1, entre com a jogada. Linha/coluna 1:3. ");
		}
		else {
			System.out.println("Vez do jogador #2, entre com a jogada. Linha/coluna 1:3. ");
		}
	}
	
	public void jogarNovamente(int linha, int coluna) {
		if (tabuleiro[linha][coluna] == " ") {
			if (contagemJogada % 2 != 0) {
				tabuleiro[linha][coluna] = "X";
				jogadaValida = true;
			}
			else {
				tabuleiro[linha][coluna] = "O";
				jogadaValida = true;
			}
		}
	}
	
	public int testarGanhador() {
		if (tabuleiro[0][0] == "X" && tabuleiro[0][1] == "X" && tabuleiro[0][2] == "X" ||
			tabuleiro[1][0] == "X" && tabuleiro[1][1] == "X" && tabuleiro[1][2] == "X" ||
			tabuleiro[2][0] == "X" && tabuleiro[2][1] == "X" && tabuleiro[2][2] == "X" ||
			//horizontal
			
			tabuleiro[0][0] == "X" && tabuleiro[1][0] == "X" && tabuleiro[2][0] == "X" ||
			tabuleiro[0][1] == "X" && tabuleiro[1][1] == "X" && tabuleiro[2][1] == "X" ||
			tabuleiro[0][2] == "X" && tabuleiro[1][2] == "X" && tabuleiro[2][2] == "X" ||
			//vertical
			
			tabuleiro[0][0] == "X" && tabuleiro[1][1] == "X" && tabuleiro[2][2] == "X" ||
			tabuleiro[0][2] == "X" && tabuleiro[1][1] == "X" && tabuleiro[2][0] == "X") {
			return 1;
		}
		else if (tabuleiro[0][0] == "O" && tabuleiro[0][1] == "O" && tabuleiro[0][2] == "O" ||
				tabuleiro[1][0] == "O" && tabuleiro[1][1] == "O" && tabuleiro[1][2] == "O" ||
				tabuleiro[2][0] == "O" && tabuleiro[2][1] == "O" && tabuleiro[2][2] == "O" ||
				//horizontal
				
				tabuleiro[0][0] == "O" && tabuleiro[1][0] == "O" && tabuleiro[2][0] == "O" ||
				tabuleiro[0][1] == "O" && tabuleiro[1][1] == "O" && tabuleiro[2][1] == "O" ||
				tabuleiro[0][2] == "O" && tabuleiro[1][2] == "O" && tabuleiro[2][2] == "O" ||
				//vertical
				
				tabuleiro[0][0] == "O" && tabuleiro[1][1] == "O" && tabuleiro[2][2] == "O" ||
				tabuleiro[0][2] == "O" && tabuleiro[1][1] == "O" && tabuleiro[2][0] == "O") {
			return 2;
		}
		return -1;
		
	}
	

}
