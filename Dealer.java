import java.util.Random;

/**Classe que gerencia o baralho. 
 * */
public class Dealer {
		boolean[][] isOnDeck;
		Random rand = new Random();
		
		/**Construtor. Inicializa o baralho.
		 * Linhas: Paus, Copas, Espadas, Ouros
		 * Colunas: 2, 3, 4, 5, 6, 7, 9, 10, J, Q, K, A 
		 * */
		public Dealer() {
			isOnDeck = new boolean[4][13];
			reshuffleDeck();
		}
		
		public void reshuffleDeck() {
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 13; j++) {
					isOnDeck[i][j] = true;
				}
			}
		}
		/**
		 * essa função da uma nova carta do baralho
		 * @return nova carta
		 * 
		 * */
		public Carta getCard(){
			int naipe, numero;
			Carta result = new Carta();
			do {
				naipe = rand.nextInt(4);
				numero = rand.nextInt(13);
			}while(isOnDeck[naipe][numero] == false);
			
			isOnDeck[naipe][numero] = false;
			
			result.setNaipe(naipe);
			result.setNumero(numero);
			
			return result;
		}
		
}
