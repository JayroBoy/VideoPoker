
public class Creditos {

	private int valor;
	/*m�todo construtor que atribui k � quantidade de cr�ditos */
	public Creditos(int k) {
		valor = k;
	}
	/**
	 * @return taoks quantidade de creditos
	 * */
	public int getCreditos(){
		return valor;
	}
	/**
	 * @param j Os creditos recebem +j ao que ja tinha
	 * */
	public void setCreditos(int j) {
		valor= j;
	}
	
}
