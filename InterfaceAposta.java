import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InterfaceAposta extends JFrame implements ActionListener {
	JPanel jp, jp2,jp3,button;
	JButton voltar, apostar;
	JLabel label;
	JTextField valor;
	Jogador player;
	JDesktopPane desktop;
	public InterfaceAposta(Jogador player) {
		Toolkit tk = Toolkit.getDefaultToolkit();  
		jp = (JPanel) this.getContentPane();
		jp.setLayout(new BoxLayout(jp, BoxLayout.PAGE_AXIS));
		
		jp2 = new JPanel();
		
		button = new JPanel();
		button.setLayout(new FlowLayout());
		
		jp3 = new JPanel();
		jp3.setLayout(new FlowLayout());
		
		desktop = new JDesktopPane(){
	          Image im1 = (new ImageIcon("PNG\\PokerChipsExtreme.png")).getImage().getScaledInstance((int)(tk.getScreenSize().getWidth()*0.9),(int)(tk.getScreenSize().getHeight()*0.9), Image.SCALE_DEFAULT);
	          public void paintComponent(Graphics g){        
	        	  g.drawImage(im1,100,0,this);
	        	  
	          }
	      };
		
		voltar = new JButton("Voltar");
		voltar.setActionCommand("voltar");
		voltar.addActionListener(this);
		
		apostar = new JButton("Apostar");
		apostar.setActionCommand("apostar");
		apostar.addActionListener(this);
		
		label = new JLabel("Digite sua aposta (entre 0 e 200):");
		
		valor = new JTextField();
		valor.setPreferredSize(new Dimension(200,24));
		
		this.player = player;
		
		jp.add(desktop);
		
		jp3.add(label);
		jp.add(jp3);
			
		
		jp2.add(valor);
		jp.add(jp2);
		
		button.add(voltar);
		button.add(apostar);
		jp.add(button);
		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setUndecorated(true); 
		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("voltar")) {
			this.setVisible(false);
			this.dispose();
			
			InterfacePoker ant = new InterfacePoker();
			ant.setVisible(true);
		} else if(e.getActionCommand().equals("apostar")) {
			//int bet=0,aux = 1;
			
			String value = this.valor.getText();
			System.out.println(this.player.getCreditos());
			
			try {
				int bet = Integer.parseInt(value);
				player.setAposta(bet);
				//player.generateMao();
				if (bet <= 0 || bet > this.player.getCreditos()) {
					label.setText("Digite um VALOR VÁLIDO");
				} else {
					label.setText("Saldo de "+player.getCreditos());
					this.setVisible(false);
					this.dispose();
					InterfaceCartas jojo = new InterfaceCartas(this.player);
					jojo.setVisible(true);
				}
				
			} catch(Exception ex) {
				label.setText("Digite um VALOR VÁLIDO");
			}
	
			
		}
		
	}

}
