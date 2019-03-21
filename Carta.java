
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
	
	public void getLine1() {
		System.out.print("+-----+");
	}
	public void getLine2() {
		System.out.print("|  " + numero + "  |");
	}
	public void getLine3() {
		System.out.print("|  ");
		switch(naipe) {
			case 0:
				System.out.print("@");
				break;
			case 1:
				System.out.print("#");
				break;
			case 2:
				System.out.print("$");
				break;
			case 3:
				System.out.print("%");
				break;
				
		}
		System.out.print("  |");
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
