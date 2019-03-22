
public class Jogador {
	Creditos money;
	Aposta bet;
	Carta[] mao;
	/*M�todo construtor que cria um vetor de cartas, placar e cr�ditos */
	public Jogador() {
		mao = new Carta[5];
		bet = new Aposta(0);
		money = new Creditos(200);
		this.generateMao();
	}
	/*inicializa cada carta do jogador*/
	public void generateMao() {
		for(int i = 0; i < 5; i++) {
			mao[i] = new Carta();
		}
	}
	/**
	 * @return Carta[] - retorna cada carta que tem na mao do usuario	 *
	 */
	public Carta[] getMao() {
		return this.mao;
	}
	/**
	 * @param Carta[] dealer - recebe as cartas que estao na mesa e as entrega ao jogador
	 */
	public void setMao(Carta[] dealer) {
		mao = dealer;
	}
	/**
	 * @return - retorna a quantidade de creditor atual do jogador 
	 * */
	public int getCreditos() {
		return money.getCreditos();
	}
	/**
	 *@param k - atribui o valor k aos cr�ditos
	 */
	public void setCreditos(int k) {
		money.setCreditos(k);
	}
	/**
	 *@param k - atribui o valor k a aposta
	 */
	public void setAposta(int k) {
		bet.setAposta(k);
	}
	/**
	 *@return k - return o valor da aposta
	 */
	public int getAposta() {
		return bet.getAposta();
	}
	
	
	/**
	*Altera o numero de creditos para o que tenho na carteira + a aposta * o multiplicador
	*@return o tanto de creditos que o jogador ganhou
	*/
	public void cashIn() {
		this.money.setCreditos(this.bet.calcular(mao) + money.getCreditos());
	}
	
	@Override
	public java.lang.String toString(){
		for(int i  = 0; i < 5; i ++) {
			mao[i].getLine1();
			System.out.print("   ");
		}
		System.out.println();
		for(int i  = 0; i < 5; i ++) {
			mao[i].getLine2();
			System.out.print("   ");
		}
		System.out.println();
		for(int i  = 0; i < 5; i ++) {
			mao[i].getLine3();
			System.out.print("   ");
		}
		System.out.println();
		for(int i  = 0; i < 5; i ++) {
			mao[i].getLine4();
			System.out.print("   ");
		}
		System.out.println();
		for(int i  = 0; i < 5; i ++) {
			mao[i].getLine5();
			System.out.print("   ");
		}
		System.out.println();
		return"";
	}
	
}
