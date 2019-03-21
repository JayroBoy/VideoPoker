public class Poker {

	public static void main (String args[]) throws Exception {
	
		String enter;
		Jogador player = new Jogador();
		int aposta=-1, vez = 2;
		Dealer dealer = new Dealer();
		Carta[] auxiliar = new Carta[5];
		
		for(int i = 0; i <5; i++) {
			auxiliar[i] = dealer.getCard();
		}
			
		System.out.println("Bem vindo ao Video poker. Digite ENTER para iniciar a rodada, ou X para sair");
		
		enter = EntradaTeclado.leString();
		
		while (enter == "\n" || player.getCreditos() <= 0) {
			
			System.out.println("Voce tem"+player.getCreditos()+"cr�ditos");
			
			System.out.println(player.toString());
			
			while(vez > 0) {
				System.out.println("Fa�a sua aposta (entre 0 e 200)");
				
				while(aposta < 0 || aposta >200) {
					aposta = EntradaTeclado.leInt();
				
					if (aposta < 0 || aposta > 200) {
						System.out.println("Insira uma aposta v�lida!");
						aposta = EntradaTeclado.leInt();
					}
				}
				
				System.out.println("Voc� pode trocar de carta"+vez+" vez(es). Deseja troc�-la? (S/N)");
				
				enter = EntradaTeclado.leString();
				
				if(enter == "S") {
					System.out.println("Quais cartas deseja trocar? Digite 1, 2, 3, 4, ou 5");
					String s = EntradaTeclado.leString();
					
				}
					
				else if(enter == "N") {
					break;
				}
					
				else {
					System.out.println("Insira uma op��o v�lida!");
				}
			}		
			System.out.println("Voc� ganhou"+player.cashIn()+"fichas");
			System.out.println("Deseja jogar novamente? Se sim digite ENTER, caso contr�rio digite X");
			enter = EntradaTeclado.leString();
		}
	}
}