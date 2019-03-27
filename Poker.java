import java.io.IOException;

public class Poker {
	/*
	 * função que limpa o terminal
	 */
	public static void clearScreen() throws IOException {
		System.out.flush();  
	   }
	/*main*/
	public static void main (String args[]) throws Exception {
	
		String enter;
		Jogador player = new Jogador();
		int aposta=-1, vez = 2, b = 0;
		Dealer dealer = new Dealer();
		Carta[] auxiliar = new Carta[5];
		

		System.out.println("Bem vindo ao Video poker. Digite show para iniciar a rodada, ou qualquer outra tecla para sair");
		
		enter = EntradaTeclado.leString();
		
		/*se o usuario digitar show, entra no loop que é o jogo*/
		while (enter.equals("show") && player.getCreditos() > 0) {
			/*o dealer da as cartas para o jogador*/
			for(int i = 0; i < 5; i++) {
				auxiliar[i] = dealer.getCard();
			}
			player.setMao(auxiliar);
			aposta = -1;
			vez = 2;
			System.out.println("Voce tem "+player.getCreditos()+" créditos");
			
			System.out.println("Faça sua aposta (entre 1 e 200)");
			
			/*este loop representa o tanto de de vezes que o jogador pode trocar as cartas, sendo também a partida*/
			while(vez > 0) {
				
				/*se a aposta for invalida, fica nesse loop até o jogador digitar um valor válido*/
				while(aposta < 1 || aposta > player.money.getCreditos()) {
					aposta = EntradaTeclado.leInt();
				
					if (aposta <= 0 || aposta > player.money.getCreditos()) {
						System.out.println("Insira uma aposta válida!");
						aposta = EntradaTeclado.leInt();					
					}
					player.setAposta(aposta);
				}
				
				/*limpa o terminal*/
				clearScreen();
				
				/*mostra as cartas do jogador*/
				player.toString();
				
				System.out.println("Você pode trocar de carta "+vez+" vez(es). Deseja trocá-la? (S/N)");
				
				enter = EntradaTeclado.leString();
				/*se o jogador digitar um opção inválida, fica nesse loop até digitar s/S ou n/N*/
				while(!enter.equals("s") && !enter.equals("S") && !enter.equals("N") && !enter.equals("n")) {
					System.out.println("Insira uma opçao válida!(S/N)");
					enter = EntradaTeclado.leString();
				}
				
				/*caso o jogador opte por trocar as cartas, ele escolhe quais cartas serao trocadas*/
				if(enter.equals("S") || enter.equals("s")) {
					
					System.out.println("Quais cartas deseja trocar? Digite 1, 2, 3, 4, ou 5");
					String s = EntradaTeclado.leString();
					
					int a, count = 0;
					
					for(int i = 0; i < s.length() && count < 5; i++) {
						a = Character.getNumericValue(s.charAt(i));

						/*caracteres que nao indicam cartas serao desconsiderados*/
						if(a == 1) {
							auxiliar[0] = dealer.getCard();
							count++;
						}
						else if(a == 2) {
							auxiliar[1] = dealer.getCard();
							count++;
						}
						else if(a == 3) {
							auxiliar[2] = dealer.getCard();
							count++;
						}
						else if(a == 4) {
							auxiliar[3] = dealer.getCard();
							count++;
						}
						else if(a == 5) {
							auxiliar[4] = dealer.getCard();
							count++;
						}
					}
					
					/*atualiza a mao do jogador*/
					player.setMao(auxiliar);
					
					/*caso o usuario digite mais de 5 cartas, apenas as 5 primeiras sao consideradas*/
					if(count == 6) System.out.println("Apenas as 5 primeiras cartas foram embaralhadas");
				}
				
				/*caso o jogador nao opte por trocar as cartas, acaba a partida*/
				else if(enter.equals("N") || enter.equals("n")) {
					break;
				}
					
				/*diminui as vezes que o jogador pode trocar cartas*/
				vez--;
			}		
			/*mostra a mao do jogador*/
			player.toString();
			b = player.getCreditos();
			
			/*atualiza o saldo*/
			player.cashIn();
			
			System.out.println("Você ganhou "+ (player.getCreditos() - b)  +" fichas");
			System.out.println("Seu saldo atual é de " + player.getCreditos() + " fichas"  );
			
			System.out.println("Deseja jogar novamente? Se sim digite show, caso contrário pressione qualquer outra tecla");
			enter = EntradaTeclado.leString();
		}
	}
}