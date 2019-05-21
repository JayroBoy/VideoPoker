import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Instrucoes extends JFrame implements ActionListener{
	JPanel jp;
	JButton voltar;
	JLabel instr;
	public Instrucoes() {
		jp = (JPanel) this.getContentPane();
		jp.setLayout(new BoxLayout(jp, BoxLayout.PAGE_AXIS));
		
		voltar = new JButton("Voltar");
		voltar.setActionCommand("voltar");
		voltar.addActionListener(this);
		
		instr = new JLabel("<html>Bem-vindo ao VideoPoker EXTREME!<br>" + 
				"As regras do jogo s�o simples<br>" + 
				"1 - Voc� faz uma aposta<br>" + 
				"2 - Voc� pode trocar de cartas duas vezes.<br>" + 
				"3 - Voc� recebe um pr�mio relativo � sua aposta.<br>" + 
				 "Cada combina��o de cartas multiplica a sua aposta por um valor espec�fico:<br>" + 
				"*Dois Pares .................. 1<br>" + 
				"*Trinca....................... 2<br>" + 
				"*Straight..................... 5<br>" + 
				"*Flush....................... 10<br>" + 
				"*Full House.................. 20<br>" + 
				"*Quadra...................... 50<br>" + 
				"*Straight Flush............. 100<br>" + 
				"*Royal Flush................ 200</html>");
		
		jp.add(instr);
		jp.add(voltar);
		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setUndecorated(true); 
		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		Instrucoes frame = new Instrucoes();
		frame.setSize(900, 600);     
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("voltar")) {
			this.setVisible(false);
			this.dispose();
			
			InterfacePoker ant = new InterfacePoker();
			ant.setVisible(true);
		}
		
	}

}
