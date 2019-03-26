
public class Creditos {

	private int anterior, acrescimo;
	/*método construtor que atribui k à quantidade de créditos */
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
