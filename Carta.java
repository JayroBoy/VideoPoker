
public class Carta {
	
	int naipe, numero;
	//Naipe: Paus, Copas, Espadas, Ouros;
	//Numero: 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A
	public Carta() {
		naipe = 0;
		numero = 0;
	}

	/**
	 * @return the naipe
	 */
	public int getNaipe() {
		return naipe;
	}

	/**
	 * @param naipe the naipe to set
	 */
	public void setNaipe(int naipe) {
		this.naipe = naipe;
	}

	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	private String getNumber(int n) {
		if(n < 9) {
			return Integer.toString(n);
		}
		if(n == 9) {
			return "0";
		}
		switch(n%9) {
			case 1:
				return "J";
			case 2:
				return "Q";
			case 3:
				return "K";
			case 4:
				return "A";
		}
		return "";
	}
	
	private String getSymbol(int n) {
		switch(n) {
		case 0:
			return "@";
		case 1:
			return "#";
		case 2:
			return "$";
		case 3:
			return "%";
			
		}
		return "";
	}
	public void getLine1() {
		System.out.print("+-----+");
	}
	public void getLine2() {
		System.out.print("|  " + getNumber(numero) + "  |");
	}
	public void getLine3() {
		System.out.print("|  " + getSymbol(naipe) +"  |");
	}
	public void getLine4() {
		System.out.print("|     |");
	}
	public void getLine5() {
		System.out.print("+-----+");
	}
	
	@Override
	public java.lang.String toString() {
		getLine1();
		System.out.println();
		getLine2();
		System.out.println();
		getLine3();
		System.out.println();
		getLine4();
		System.out.println();
		getLine5();
		
		return "";
	}
	
}
