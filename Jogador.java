
public class Jogador {
	Creditos money;
	Aposta bet;
	Carta[] mao;
	
	public Jogador() {
		mao = new Carta[5];
		bet = new Aposta(0);
		money = new Creditos(200);
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
	
	public void setAposta(int k) {
		bet.setAposta(k);
	}
	
	public int getAposta() {
		return bet.getAposta();
	}
	
	
	//Altera o numero de creditos para o que tenho na carteira + a aposta * o multiplicador
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
