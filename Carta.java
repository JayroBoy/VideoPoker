public class Carta {
	
	int naipe, numero;
	//Naipe: Paus = @, Copas = #, Espadas = $, Ouros = %;
	//Numero: 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A
	
	/**
	* Método construtor
	*/
	public Carta() {
		naipe = -1;
		numero = -1;
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
	/**
	 * @param n - integer a ser convertido pra string
	 * @return - pode ser a string aquivalente ao numero n ou vazio
	 * */
	private String getNumber(int n) {
		if(n < 8) {
			return Integer.toString(n + 2);
		}
		if(n == 8) {
			return "0";
		}
		switch(n%8) {
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
	/**
	 * @param n - indica o naipe
	 * @return - naipe em caracter
	 * */
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
	
	/**
	 * função auxiliar para mostrar a Carta
	 */
	public void getLine1() {
		System.out.print("+-----+");
	}
	
	/**
	 * função auxiliar para mostrar a Carta
	 */
	public void getLine2() {
		System.out.print("|  " + getNumber(numero) + "  |");
	}
	
	/**
	 * função auxiliar para mostrar a Carta
	 */
	public void getLine3() {
		System.out.print("|  " + getSymbol(naipe) +"  |");
	}
	
	/**
	 * função auxiliar para mostrar a Carta
	 */
	public void getLine4() {
		System.out.print("|     |");
	}
	
	/**
	 * função auxiliar para mostrar a Carta
	 */
	public void getLine5() {
		System.out.print("+-----+");
	}
	
	@Override
	
	/**
	 * função que imprime uma carta
	 */
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
