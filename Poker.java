public class Poker {

	public static void main (String args[]) throws Exception {
	
		String enter;
		Jogador player = new Jogador();
		int aposta=-1, vez = 2;
		Dealer dealer = new Dealer();
		Carta[] auxiliar = new Carta[4];
		
		for(int i = 0; i <4; i++) {
			auxiliar[i] = dealer.getCard();
		}
		//TEM Q PEDIR PRA DIGITAR ALGUMA COISA Q N SEJA \N PQ O ENTRADATECLADO N SABE LIDAR	
		System.out.println("Bem vindo ao Video poker. Digite show para iniciar a rodada, ou X para sair");
		
		enter = EntradaTeclado.leString();
		
		while (enter.equals("show") || player.getCreditos() <= 0) {
			
			System.out.println("Voce tem "+player.getCreditos()+" créditos");
			
			//o toString ta na Carta e nao no player, por isso printa endereço
			//n sei resolver isso
			System.out.println(player.mao.toString());
			
			while(vez > 0) {
				System.out.println("Faça sua aposta (entre 0 e 200)");
				
				while(aposta < 0 || aposta >200) {
					aposta = EntradaTeclado.leInt();
				
					if (aposta < 0 || aposta > 200) {
						System.out.println("Insira uma aposta válida!");
						aposta = EntradaTeclado.leInt();
					}
				}
				
				System.out.println("Você pode trocar de carta"+vez+" vez(es). Deseja trocá-la? (S/N)");
				
				enter = EntradaTeclado.leString();
				
				if(enter.equals("S")) {
					System.out.println("Quais cartas deseja trocar? Digite 1, 2, 3, 4, ou 5");
					String s = EntradaTeclado.leString();
					int a, count = 0;
					for(int i = 0; i < s.length() || count >= 5; i++) {
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
					if(count == 5) System.out.println("Apenas as 5 primeiras cartas foram embaralhadas");
				}
					
				else if(enter.equals("N")) {
					break;
				}
					
				else {
					System.out.println("Insira uma opção válida!");
				}
			}		
			//sempre ta ganhando 0 taoks
			System.out.println("Você ganhou "+player.cashIn()+" fichas");
			System.out.println("Deseja jogar novamente? Se sim digite show, caso contrário digite X");
			enter = EntradaTeclado.leString();
		}
	}
}