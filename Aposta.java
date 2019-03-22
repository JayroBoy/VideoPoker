
public class Aposta {

	private int mult, numero, naipe, par, trinca, quadra;
	private int[] freqnumero;
	private int[] freqnaipe;
	private int aposta;
	/*
	 * Método Construtor que inicia todas as variaveis da classe com 0, e a aposta
	 * com o que foi apostado
	 * */
	public Aposta(int bet){
		aposta = bet;	//guarda a quantia q foi apostada
		mult = 0;	//guarda o multiplicador da aposta 
		par = 0;	//indica pares
		trinca = 0;	//indica trinca
		quadra = 0;	//indica quadra
		freqnumero = new int[13];	//vetor para contar frequencia de cada número
		freqnaipe = new int[4]; 	//vetor para contar frequencia de cada naipe
		for(int i = 0; i < 13; i++) {
			freqnumero[i] = 0;
		}
		for(int i = 0; i < 4; i++) {
			freqnaipe[i] = 0;
		}
		
	}
	/**
	 * @param aposta a ser atribuida 
	 */
	public void setAposta(int k) {
		aposta = k;
	}
	/**
	 * @return a aposta
	 */
	public int getAposta() {
		return aposta;
	}
	/*Método que calcula a pontuação dado a sequencia de cartas que o 
	 * jogador tem
	 * @param Carta[] card tor com as 5 cartas que o jogador tem
	 * @return O valor da aposta
	 * */
	public int calcular( Carta[] card) {
		//percorre o vetor de cartas para indicar quais cartas estao na mao do jogador
		for(int i = 0; i < 5; i++) {
			naipe = card[i].getNaipe();
			numero = card[i].getNumero();
			/*o vetor de frequencias do naipe é tem cada posição incrementada conforme aparece determinado naipe no vetor de cartas*/
			switch(naipe) {
				case 0
					freqnaipe[0] +=1;
				break;
				case 1
					freqnaipe[1] +=1;
					break;
				case 2
					freqnaipe[2] +=1;
					break;
				case 3
					freqnaipe[3] +=1;
					break;
				default
					break;
				}
				/*o vetor de frequencias dos numeros  tem cada posição incrementada conforme aparecem no vetor de cartas*/		
				switch(numero) {
				case 0
					freqnumero[0] +=1;
				break;
				case 1
					freqnumero[1] +=1;
					break;
				case 2
					freqnumero[2] +=1;
					break;
				case 3
					freqnumero[3] +=1;
					break;
				case 4
					freqnumero[4] +=1;
					break;
				case 5
					freqnumero[5] +=1;
					break;
				case 6
					freqnumero[6] +=1;
					break;
				case 7
					freqnumero[7] +=1;
					break;
				case 8
					freqnumero[8] +=1;
					break;
				case 9
					freqnumero[9] +=1;
					break;
				case 10
					freqnumero[10] +=1;
					break;
				case 11
					freqnumero[11] +=1;
					break;
				case 12
					freqnumero[12] +=1;
				default
					break;
				}
			}
		//zera as variaveis para reutilizá-las
		numero = 0; //indica sequencia
		naipe = 0;	//indica naipe
		
		//percorre o vetor de numeros para procurar as combinações que premiam o jogador
		for(int i = 0; i < 13; i++) {
			if(freqnumero[i] == 2) par++;
			if(freqnumero[i] == 3) trinca++;
			else if(freqnumero[i] == 4) quadra++;
			else if(freqnumero[i] == 1 && (freqnumero[i-1] == 1 || i-1<0)) numero++;
		}
		//percorre o vetor de naipes para procurar as combinações que premiam o jogador
		for(int i = 0; i <4; i++) {
			if(freqnaipe[i] == 1 && (freqnaipe[i-1] == 1 || i-1<0)) naipe ++;
		}
		
		//atribui a pontuação de acordo com as combinações 
		if (par == 2) mult = 1;	//dois pares
		if (naipe == 5) mult = 10; //flush
		else if (trinca == 1) { 
			if(par == 1) mult = 20; //full hand
			else if (par == 0) mult = 2; //trinca
		}
		else if(quadra == 1) mult = 50; //quadra
		else if(numero == 5) {
			if(naipe == 5) {
				if(freqnumero[12] == 1) mult = 200; //royal straight flush
				else mult = 100;//straight flush
			}	
			else if(naipe < 5) mult = 5; //straight
		}
		
		return mult * aposta;
		
	}
