
public class Jogador {
	Creditos money;
	Aposta bet;
	Carta[] mao;
	/*Método construtor que cria um vetor de cartas, placar e créditos */
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
	 *@param k - atribui o valor k aos créditos
	 */
	public void setCreditos(int k) {
		money.setCreditos(k);
	}
	/**
	 *@return a aposta 
	 */
	public int getAposta() {
		return bet.getAposta();
	}
	/**
	 *@param int k, o tanto que vale a aposta
	 *set a aposta e desconta esse valor do que saldo anterior
	 */
	public void setAposta(int k) throws IllegalArgumentException{
		if(k <= this.getCreditos() ) {
			this.money.setCreditos(this.getCreditos() - k);
			this.bet.setAposta(k);
		}else throw new IllegalArgumentException("Valor não possuído");
		
	}

	@Override
	public java.lang.String toString(){
		for(int i = 0; i < 5; i++) {
			mao[i].getLine1();
			System.out.print("   ");
		}
		System.out.println("");
		for(int i = 0; i < 5; i++) {
			mao[i].getLine2();
			System.out.print("   ");
		}
		System.out.println("");
		for(int i = 0; i < 5; i++) {
			mao[i].getLine3();
			System.out.print("   ");
		}
		System.out.println("");
		for(int i = 0; i < 5; i++) {
			mao[i].getLine4();
			System.out.print("   ");
		}
		System.out.println("");
		for(int i = 0; i < 5; i++) {
			mao[i].getLine5();
			System.out.print("   ");
		}
		System.out.println("");
		return "";
	}
	/**
	 * função que atualiza o quanto o jogador tem (saldo anterior+ganho com aposta)
	 */
	public void cashIn() {
		this.money.setCreditos(this.bet.calcular(mao) + this.getCreditos());
	}
	
	
	
}
