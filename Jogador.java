
public class Jogador {
	Creditos money;
	Multiplicador mult;
	Carta[] mao;
	/*Método construtor que cria um vetor de cartas, placar e créditos */
	public Jogador() {
		mao = new Carta[5];
		mult = new Multiplicador();
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
	 * manda as cartas para o placar e ele devolve o multiplicador
	 * @return o multiplicador
	 */
	public int cashIn() {
		return this.mult.calcular(mao);
	}
	
	
	
}
