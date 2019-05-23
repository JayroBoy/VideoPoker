import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Continue extends JFrame implements ActionListener{
	
	JPanel jp1, jp2,jp3;
	JButton continuar, encerrar, menu;
	JLabel lucro;
	Jogador J;
	
	public Continue(Jogador jog) {
		jp1 = (JPanel)this.getContentPane();
		jp1.setLayout(new BoxLayout(jp1, BoxLayout.PAGE_AXIS));
		
		jp2 = new JPanel();
		jp2.setLayout(new FlowLayout());
		
		jp3 = new JPanel();
		jp3.setLayout(new FlowLayout());
		
		continuar = new JButton("Continuar");
		continuar.setActionCommand("continuar");
		continuar.addActionListener(this);
		
		encerrar = new JButton("Encerrar");
		encerrar.setActionCommand("encerrar");
		encerrar.addActionListener(this);
		
		menu = new JButton("Menu");
		menu.setActionCommand("menu");
		menu.addActionListener(this);
		
		lucro = new JLabel("Seu saldo é de "+jog.getCreditos()+" créditos.");
		this.J = jog;
		jp3.add(lucro);
		
		//O jogo não permite novas apostas caso o jogador zere o seu saldo
		if(jog.getCreditos() > 0) {
			jp2.add(continuar);
		}
		jp2.add(encerrar);
		jp2.add(menu);
		
		jp1.add(jp3);
		jp1.add(jp2);
		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setUndecorated(true); 
		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//se clicar em continuar, o jogo segue com o saldo atual
		if(e.getActionCommand().equals("continuar")) {
			this.setVisible(false);
			this.dispose();
			
			InterfaceAposta ant = new InterfaceAposta(J);
			ant.setVisible(true);
		}
		//se clicar em encerrar, finaliza o programa
		else if(e.getActionCommand().equals("encerrar")) {
			System.exit(0);

		}
		//se clicar em menu, vai para o menu, reininciano o jogo
		else if(e.getActionCommand().equals("menu")) {
			this.setVisible(false);
			this.dispose();
			
			InterfacePoker ant = new InterfacePoker();
			ant.setVisible(true);
		}
	}
	
}
