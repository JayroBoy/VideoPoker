import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
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

public class InterfaceCartas extends JFrame implements ActionListener {
	JPanel jp, cards,botoes,lab;
	JButton trocar, encerrar;
	JButton[] c = new JButton[5];
	JLabel label;
	Dealer dealer = new Dealer();
	Carta [] aux = new Carta[5];
	
	int vez = 2;
	int[] cartas = new int[5];

	public InterfaceCartas(Jogador player) {
		
		for(int i = 0; i < 5; i++) {
			aux[i] = dealer.getCard();
			//System.out.println(aux[i]);
		}
		player.setMao(aux);	
		for(int i = 0; i < 5; i++) {
			cartas[i] = -1;
		}//-1 == false, 1 == true
		
		jp = (JPanel) this.getContentPane();
		jp.setLayout(new BoxLayout(jp, BoxLayout.PAGE_AXIS));
		
		cards =  new JPanel();
		cards.setLayout(new FlowLayout());
		
		lab =  new JPanel();
		lab.setLayout(new FlowLayout());
		
		botoes = new JPanel();
		botoes.setLayout(new FlowLayout());
		
		//Verso das cartas
		
		
		String nome1, nome2, nome, comm;
		ImageIcon icon;
		Image img, imgc1;
		
		for(int i = 0; i < 5; i++) {
			nome1 =  String.valueOf(aux[i].getNumero());
			nome2 =  String.valueOf(aux[i].getNaipe());
			nome = nome1+nome2;
		
			icon = new ImageIcon("PNG\\"+nome+".png");
			img = icon.getImage() ;  
			imgc1 = img.getScaledInstance( 131, 200,  java.awt.Image.SCALE_SMOOTH ) ;  
			icon = new ImageIcon( imgc1 );
			comm = String.valueOf(i);
			
			c[i] = new JButton(icon);
			c[i].setActionCommand("c" + comm);
			c[i].addActionListener(this);
		}
		
		encerrar = new JButton("Encerrar");
		encerrar.setActionCommand("encerrar");
		encerrar.addActionListener(this);
		
		trocar = new JButton("Trocar");
		trocar.setActionCommand("trocar");
		trocar.addActionListener(this);
		
		ImageIcon iconBack = new ImageIcon("PNG\\BackExtreme.png");
		Image imgA = iconBack.getImage() ;  
		Image imgbc = imgA.getScaledInstance( 131, 200,  java.awt.Image.SCALE_SMOOTH ) ;  
		iconBack = new ImageIcon(imgbc);
		for(int i  = 0; i < 5; i++) {
			comm = String.valueOf(i);
			if(cartas[i] == 1) {
				c[i] = new JButton(iconBack);
				c[i].setActionCommand("c" + comm);
				c[i].addActionListener(this);
			}
		}
		
		
		label = new JLabel("Você pode trocar de carta "+vez--+" vez(es)");
		
		for(int i = 0; i <5; i++) {
			cards.add(c[i]);
		}
		lab.add(label);
		jp.add(lab);
		jp.add(cards);
		botoes.add(encerrar);
		botoes.add(trocar);
		jp.add(botoes);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setUndecorated(true); 
		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub		
		ImageIcon iconBack = new ImageIcon("PNG\\BackExtreme.png");
		Image imgA = iconBack.getImage() ;  
		Image imgbc = imgA.getScaledInstance( 131, 200,  java.awt.Image.SCALE_SMOOTH ) ;  
		iconBack = new ImageIcon(imgbc);
		
		String nome1, nome2, nome;
		ImageIcon icon;
		Image img, imgc1;
		
		
		if(e.getActionCommand().equals("c0")) {
			cartas[0]*=-1;
			c[0].setVisible(false);
			if(cartas[0] == 1) {
				c[0].setIcon(iconBack);
			}else {
				nome1 =  String.valueOf(aux[0].getNumero());
				nome2 =  String.valueOf(aux[0].getNaipe());
				nome = nome1+nome2;
			
				icon = new ImageIcon("PNG\\"+nome+".png");
				img = icon.getImage() ;  
				imgc1 = img.getScaledInstance( 131, 200,  java.awt.Image.SCALE_SMOOTH ) ;  
				icon = new ImageIcon( imgc1 );
				c[0].setIcon(icon);
			}
			c[0].setVisible(true);
		}else if(e.getActionCommand().equals("c1")) {
			cartas[1]*=-1;
			c[1].setVisible(false);
			if(cartas[1] == 1) {
				c[1].setIcon(iconBack);
			}else {
				nome1 =  String.valueOf(aux[1].getNumero());
				nome2 =  String.valueOf(aux[1].getNaipe());
				nome = nome1+nome2;
			
				icon = new ImageIcon("PNG\\"+nome+".png");
				img = icon.getImage() ;  
				imgc1 = img.getScaledInstance( 131, 200,  java.awt.Image.SCALE_SMOOTH ) ;  
				icon = new ImageIcon( imgc1 );
				c[1].setIcon(icon);
			}
			c[1].setVisible(true);

		}else if(e.getActionCommand().equals("c2")) {
			cartas[2]*=-1;
			c[2].setVisible(false);
			if(cartas[2] == 1) {
				c[2].setIcon(iconBack);
			}else {
				nome1 =  String.valueOf(aux[2].getNumero());
				nome2 =  String.valueOf(aux[2].getNaipe());
				nome = nome1+nome2;
			
				icon = new ImageIcon("PNG\\"+nome+".png");
				img = icon.getImage() ;  
				imgc1 = img.getScaledInstance( 131, 200,  java.awt.Image.SCALE_SMOOTH ) ;  
				icon = new ImageIcon( imgc1 );
				c[2].setIcon(icon);
			}
			c[2].setVisible(true);

		}else if(e.getActionCommand().equals("c3")) {
			cartas[3]*=-1;
			c[3].setVisible(false);
			if(cartas[3] == 1) {
				c[3].setIcon(iconBack);
			}else {
				nome1 =  String.valueOf(aux[3].getNumero());
				nome2 =  String.valueOf(aux[3].getNaipe());
				nome = nome1+nome2;
			
				icon = new ImageIcon("PNG\\"+nome+".png");
				img = icon.getImage() ;  
				imgc1 = img.getScaledInstance( 131, 200,  java.awt.Image.SCALE_SMOOTH ) ;  
				icon = new ImageIcon( imgc1 );
				c[3].setIcon(icon);
			}
			c[3].setVisible(true);

		}else if(e.getActionCommand().equals("c4")) {
			cartas[4]*=-1;
			c[4].setVisible(false);
			if(cartas[4] == 1) {
				c[4].setIcon(iconBack);
			}else {
				nome1 =  String.valueOf(aux[4].getNumero());
				nome2 =  String.valueOf(aux[4].getNaipe());
				nome = nome1+nome2;
			
				icon = new ImageIcon("PNG\\"+nome+".png");
				img = icon.getImage() ;  
				imgc1 = img.getScaledInstance( 131, 200,  java.awt.Image.SCALE_SMOOTH ) ;  
				icon = new ImageIcon( imgc1 );
				c[4].setIcon(icon);
			}
			c[4].setVisible(true);

		}else if(e.getActionCommand().equals("encerrar")) {
			System.exit(0);
		}else if(e.getActionCommand().equals("trocar")) {
			for(int i = 0; i < 5; i++) {
				if(cartas[i] == 1) {
					c[i].setVisible(false);
					Carta aux = new Carta();
					aux = dealer.getCard();
					
					nome1 =  String.valueOf(aux.getNumero());
					nome2 =  String.valueOf(aux.getNaipe());
					nome = nome1+nome2;
				
					icon = new ImageIcon("PNG\\"+nome+".png");
					img = icon.getImage() ;  
					imgc1 = img.getScaledInstance( 131, 200,  java.awt.Image.SCALE_SMOOTH ) ;  
					icon = new ImageIcon( imgc1 );
					c[i].setIcon(icon);
					c[i].setVisible(true);
					cartas[i]*=-1;
				}
			}
		}
		
	}

}
