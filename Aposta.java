
public class Aposta {

	private int mult, numero, naipe, par;
	private int[] freqnumero;
	private int[] freqnaipe;
	private int aposta;
	/**
	 * Método Construtor que inicia todas as variaveis da classe com 0
	 */
	public Aposta(int bet){
		aposta = bet;
		freqnumero = new int[13];
		freqnaipe = new int[4];
		refresh();

	}
	/**
	 *@param int k, o tanto que vale a aposta 
	 */
	public void setAposta(int k) {
		aposta = k;
	}
	
	/**
	 *@return a aposta 
	 */
	public int getAposta() {
		return aposta;
	}
	
	public void refresh() {
		mult = 0;
		par = 0;
		for(int i = 0; i < 13; i++) {
			freqnumero[i] = 0;
		}
		for(int i = 0; i < 4; i++) {
			freqnaipe[i] = 0;
		}
	}
	
	/**Método que calcula a pontuação dado a sequencia de cartas que o 
	 * jogador tem
	 * @param Carta[] card tor com as 5 cartas que o jogador tem
	 * @return o tanto de fichas ganhas com a aposta
	 * */
	public int calcular( Carta[] card) {
		boolean doisPares, trinca, fullHouse, quadra, flush, straightB;
		int straight;
		/*percorre o vetor de cartas para indicar quais cartas estao na mao do jogador*/
		for(int i = 0; i < 5; i++) {
			naipe = card[i].getNaipe();
			numero = card[i].getNumero();
			/*o vetor de frequencias do naipe é incrementado conforme aparece determinado naipe no vetor de cartas*/
			switch(naipe) {
				case 0:
					freqnaipe[0]++;
					break;
				case 1:
					freqnaipe[1]++;
					break;
				case 2:
					freqnaipe[2]++;
					break;
				case 3:
					freqnaipe[3]++;
					break;
				default:
					break;
				}
			/*o vetor de frequencias dos numeros é incrementado conforme aparecem no vetor de cartas*/	
				switch(numero) {
					case 0:
						freqnumero[0]++;
						break;
					case 1:
						freqnumero[1]++;
						break;
					case 2:
						freqnumero[2]++;
						break;
					case 3:
						freqnumero[3]++;
						break;
					case 4:
						freqnumero[4]++;
						break;
					case 5:
						freqnumero[5]++;
						break;
					case 6:
						freqnumero[6]++;
						break;
					case 7:
						freqnumero[7]++;
						break;
					case 8:
						freqnumero[8]++;
						break;
					case 9:
						freqnumero[9]++;
						break;
					case 10:
						freqnumero[10]++;
						break;
					case 11:
						freqnumero[11]++;
						break;
					case 12:
						freqnumero[12]++;
						break;
					default:
						break;
				}
			}
		
		//Iniciando as variáveis

		flush = false;
		straightB = false;
		trinca = false;
		quadra = false;
		doisPares = false;
		fullHouse = false;
		straight = 0;
		
		/*percorre o vetor de numeros para procurar as combinações que premiam o jogador*/
		for(int i = 0; i < 13; i++) {
			if(freqnumero[i] == 2) {
				par++;
			}
			if(freqnumero[i] == 3) {
				trinca = true;
			}
			if(freqnumero[i] == 4) {
				quadra = true;
			}
			if(i > 0) {
				if((freqnumero[i] == freqnumero[i-1] && freqnumero[i] == 1)) {
					straight++;
				}
			}
		}
		
		if(par == 2) {
			doisPares = true;
		}else if(par == 1 && trinca) {
			fullHouse = true;
		}
		
		if(straight > 3) {
			straightB = true;
		}
		
		//percorre o vetor de naipes para procurar as combinações que premiam o jogador

		
		for(int i = 0; i < 4; i++) {
			if(freqnaipe[i] == 5) {
				flush = true;
			}
		}
		
		mult = 0;
		/*atribuir a pontuação de acordo com as combinações */
		
		
		if (doisPares) {
			mult = 1;	//dois pares
			System.out.println("Dois Pares!");
		}if(trinca && !fullHouse) {
			mult = 2; //trinca
			System.out.println("Trinca!");
		}if (flush && !straightB) {
			mult = 10; //flush
			System.out.println("Flush!");
		}if (fullHouse) { 
			mult = 20; //full hand
			System.out.println("Full House!");
		}if(quadra) {
			mult = 50; //quadra
			System.out.println("Quadra!");
		}if(straightB) {
			if(!flush) {
				mult = 5; //straight
				System.out.println("Straight!");
			}else{
				if(freqnumero[12] == 0) {
					mult = 100;//straight flush
					System.out.println("Straight Flush!");
				}else {
					mult = 200; //royal straight flush
					System.out.println("Royal Flush!");
				}

			}
		}
		
		return mult * aposta;
		
	}
}

