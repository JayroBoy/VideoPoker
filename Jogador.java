
public class Jogador {
	Creditos money;
	Placar pontos;
	Carta[] mao;
	int aposta;
	
	public Jogador() {
		mao = new Carta[5];
		pontos = new Placar();
		money = new Creditos(200);
		aposta = 0;
		this.generateMao();
	}
	
	public void generateMao() {
		for(int i = 0; i < 5; i++) {
			mao[i] = new Carta();
		}
	}
	
	public Carta[] getMao() {
		return this.mao;
	}
	
	public void setMao(Carta[] dealer) {
		mao = dealer;
	}
	
	public int getCreditos() {
		return money.getCreditos();
	}
	
	public void setCreditos(int k) {
		money.setCreditos(k);
	}
	
	public int getAposta() {
		return aposta;
	}
	
	public void setAposta(int k) {
		aposta = k;
	}
	
	public int cashIn() {
		return this.pontos.calcular(mao);
	}
	
	@Override
	public java.lang.String toString(){

		return"";
	}
	
}
