
public class Creditos {

	private int anterior, acrescimo;
	/*m�todo construtor que atribui k � quantidade de cr�ditos */
	public Creditos(int k) {
		anterior = k;
		acrescimo = 0;
	}
	/**
	 * @return taoks quantidade de creditos
	 * */
	public int getCreditos(){
		return anterior+acrescimo;
	}
	/**
	 * @param j Os creditos recebem +j ao que ja tinha
	 * */
	public void setCreditos(int j) {
		acrescimo = j;
	}
	
}
