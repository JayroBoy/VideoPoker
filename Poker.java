import java.io.IOException;

public class Poker {

	public static void clearScreen() throws IOException {
		System.out.flush();  
	   }
	
	public static void main (String args[]) throws Exception {
	
		String enter;
		Jogador player = new Jogador();
		int aposta=-1, vez = 2, b = 0;
		Dealer dealer = new Dealer();
		Carta[] auxiliar = new Carta[5];
		

		//TEM Q PEDIR PRA DIGITAR ALGUMA COISA Q N SEJA \N PQ O ENTRADATECLADO N SABE LIDAR	
		System.out.println("Bem vindo ao Video poker. Digite show para iniciar a rodada, ou qualquer outra tecla para sair");
		
		enter = EntradaTeclado.leString();
		
		while (enter.equals("show") && player.getCreditos() > 0) {
			for(int i = 0; i < 5; i++) {
				auxiliar[i] = dealer.getCard();
			}
			player.setMao(auxiliar);
			aposta = -1;
			vez = 2;
			System.out.println("Voce tem "+player.getCreditos()+" créditos");
			
			System.out.println("Faça sua aposta (entre 1 e 200)");
			while(vez > 0) {
				
				
				while(aposta < 1 || aposta > player.money.getCreditos()) {
					aposta = EntradaTeclado.leInt();
				
					if (aposta <= 0 || aposta > player.money.getCreditos()) {
						System.out.println("Insira uma aposta válida!");
						aposta = EntradaTeclado.leInt();					
					}
					player.setAposta(aposta);
				}
				clearScreen();
				player.toString();
				System.out.println("Você pode trocar de carta "+vez+" vez(es). Deseja trocá-la? (S/N)");
				
				enter = EntradaTeclado.leString();
				
				while(!enter.equals("s") && !enter.equals("S") && !enter.equals("N") && !enter.equals("n")) {
					System.out.println("Insira uma opçao válida!(S/N)");
					enter = EntradaTeclado.leString();
				}
				
				if(enter.equals("S") || enter.equals("s")) {
					System.out.println("Quais cartas deseja trocar? Digite 1, 2, 3, 4, ou 5");
					String s = EntradaTeclado.leString();
					int a, count = 0;
					for(int i = 0; i < s.length() && count < 5; i++) {
						//System.out.print(i + " ");
						a = Character.getNumericValue(s.charAt(i));
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
					player.setMao(auxiliar);
					if(count == 6) System.out.println("Apenas as 5 primeiras cartas foram embaralhadas");
				}
					
				else if(enter.equals("N") || enter.equals("n")) {
					break;
				}
					
				else {
					System.out.println("Insira uma opção válida!");
				}
				vez--;
			}		
			player.toString();
			b = player.getCreditos();
			player.cashIn();
			System.out.println("Você ganhou "+ (player.getCreditos() - b)  +" fichas");
			System.out.println("Seu saldo atual é de " + player.getCreditos() + " fichas"  );
			System.out.println("Deseja jogar novamente? Se sim digite show, caso contrário pressione qualquer outra tecla");
			enter = EntradaTeclado.leString();
		}
	}
}