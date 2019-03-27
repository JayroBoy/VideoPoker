
public class Creditos {

	private int valor;
	/**
	*método construtor que atribui k à quantidade de créditos
	*/
	public Creditos(int k) {
		valor = k;
	}
	/**
	 * @return quantidade de creditos
	 * */
	public int getCreditos(){
		return valor;
	}
	/**
	 * @param j - creditos 
	 * */
	public void setCreditos(int j) {
		valor= j;
	}
	
}
