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
	JButton trocar, encerrar, continuar;
	JButton[] c = new JButton[5];
	JLabel label;
	Jogador jog;
	Dealer dealer = new Dealer();
	Carta [] aux = new Carta[5];
	
	int vez = 2;
	int[] cartas = new int[5];

	public InterfaceCartas(Jogador player) {
		dealer.reshuffleDeck();
		jog = player;
		jog.bet.refresh();
		for(int i = 0; i < 5; i++) {
			aux[i] = dealer.getCard();
		}
		jog.setMao(aux);	
		//vetor para indicar se a carta pode ser trocada ou nao
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
		
		String nome1, nome2, nome, comm;
		ImageIcon icon;
		Image img, imgc1;
		
		for(int i = 0; i < 5; i++) {
			nome1 =  String.valueOf(aux[i].getNumero());
			nome2 =  String.valueOf(aux[i].getNaipe());
			nome = nome1+nome2;
		
			icon = new ImageIcon("src\\PNG\\"+nome+".png");
			img = icon.getImage() ;
			//Redimensionando a imagem
			imgc1 = img.getScaledInstance( 232, 400,  java.awt.Image.SCALE_SMOOTH ) ;  
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
		
		continuar = new JButton("Continuar");
		continuar.setActionCommand("continuar");
		continuar.addActionListener(this);

		//Verso das cartas
		ImageIcon iconBack = new ImageIcon("src\\PNG\\BackExtreme.png");
		Image imgA = iconBack.getImage() ;  
		Image imgbc = imgA.getScaledInstance( 232, 400,  java.awt.Image.SCALE_SMOOTH ) ;  
		iconBack = new ImageIcon(imgbc);
		for(int i  = 0; i < 5; i++) {
			comm = String.valueOf(i);
			if(cartas[i] == 1) {
				c[i] = new JButton(iconBack);
				c[i].setActionCommand("c" + comm);
				c[i].addActionListener(this);
			}
		}
		
		
		label = new JLabel("Você pode trocar de carta "+vez+" vez(es)");
		
		for(int i = 0; i <5; i++) {
			cards.add(c[i]);
		}
		lab.add(label);
		jp.add(lab);
		jp.add(cards);
		botoes.add(encerrar);
		botoes.add(trocar);
		botoes.add(continuar);
		jp.add(botoes);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setUndecorated(true); 
		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub	

		//Verso das cartas
		ImageIcon iconBack = new ImageIcon("src\\PNG\\BackExtreme.png");
		Image imgA = iconBack.getImage() ;  
		Image imgbc = imgA.getScaledInstance( 232, 400,  java.awt.Image.SCALE_SMOOTH ) ;  
		iconBack = new ImageIcon(imgbc);
		
		String nome1, nome2, nome;
		ImageIcon icon;
		Image img, imgc1;
		
		//se clicar na primeira carta, vira-a e deixa-a selecionada para trocar
		if(e.getActionCommand().equals("c0")) {
			cartas[0]*=-1;
			c[0].setVisible(false);
			if(cartas[0] == 1) {
				c[0].setIcon(iconBack);
			}else {
				nome1 =  String.valueOf(aux[0].getNumero());
				nome2 =  String.valueOf(aux[0].getNaipe());
				nome = nome1+nome2;
			
				icon = new ImageIcon("src\\PNG\\"+nome+".png");
				img = icon.getImage() ;  
				imgc1 = img.getScaledInstance( 232, 400,  java.awt.Image.SCALE_SMOOTH ) ;  
				icon = new ImageIcon( imgc1 );
				c[0].setIcon(icon);
			}
			c[0].setVisible(true);
		}
		//se clicar na segunda carta, vira-a e deixa-a selecionada para trocar
		else if(e.getActionCommand().equals("c1")) {
			cartas[1]*=-1;
			c[1].setVisible(false);
			if(cartas[1] == 1) {
				c[1].setIcon(iconBack);
			}else {
				nome1 =  String.valueOf(aux[1].getNumero());
				nome2 =  String.valueOf(aux[1].getNaipe());
				nome = nome1+nome2;
			
				icon = new ImageIcon("src\\PNG\\"+nome+".png");
				img = icon.getImage() ;  
				imgc1 = img.getScaledInstance( 232, 400,  java.awt.Image.SCALE_SMOOTH ) ;  
				icon = new ImageIcon( imgc1 );
				c[1].setIcon(icon);
			}
			c[1].setVisible(true);

		}
		//se clicar na terceira carta, vira-a e deixa-a selecionada para trocar
		else if(e.getActionCommand().equals("c2")) {
			cartas[2]*=-1;
			c[2].setVisible(false);
			if(cartas[2] == 1) {
				c[2].setIcon(iconBack);
			}else {
				nome1 =  String.valueOf(aux[2].getNumero());
				nome2 =  String.valueOf(aux[2].getNaipe());
				nome = nome1+nome2;
			
				icon = new ImageIcon("src\\PNG\\"+nome+".png");
				img = icon.getImage() ;  
				imgc1 = img.getScaledInstance( 232, 400,  java.awt.Image.SCALE_SMOOTH ) ;  
				icon = new ImageIcon( imgc1 );
				c[2].setIcon(icon);
			}
			c[2].setVisible(true);

		}
		//se clicar na quarta carta, vira-a e deixa-a selecionada para trocar
		else if(e.getActionCommand().equals("c3")) {
			cartas[3]*=-1;
			c[3].setVisible(false);
			if(cartas[3] == 1) {
				c[3].setIcon(iconBack);
			}else {
				nome1 =  String.valueOf(aux[3].getNumero());
				nome2 =  String.valueOf(aux[3].getNaipe());
				nome = nome1+nome2;
			
				icon = new ImageIcon("src\\PNG\\"+nome+".png");
				img = icon.getImage() ;  
				imgc1 = img.getScaledInstance( 232, 400,  java.awt.Image.SCALE_SMOOTH ) ;  
				icon = new ImageIcon( imgc1 );
				c[3].setIcon(icon);
			}
			c[3].setVisible(true);

		}
		//se clicar na quinta carta, vira-a e deixa-a selecionada para trocar
		else if(e.getActionCommand().equals("c4")) {
			cartas[4]*=-1;
			c[4].setVisible(false);
			if(cartas[4] == 1) {
				c[4].setIcon(iconBack);
			}else {
				nome1 =  String.valueOf(aux[4].getNumero());
				nome2 =  String.valueOf(aux[4].getNaipe());
				nome = nome1+nome2;
			
				icon = new ImageIcon("src\\PNG\\"+nome+".png");
				img = icon.getImage() ;  
				imgc1 = img.getScaledInstance( 232, 400,  java.awt.Image.SCALE_SMOOTH ) ;  
				icon = new ImageIcon( imgc1 );
				c[4].setIcon(icon);
			}
			c[4].setVisible(true);

		}
		//se clicar no botao encerrar, finaliza o pporgrama
		else if(e.getActionCommand().equals("encerrar")) {
			System.exit(0);
		}
		//se clicar no botão trocar, troca as cartas selecionadas
		else if(e.getActionCommand().equals("trocar") && (vez > 0)) {
			label.setVisible(false);
			vez--;
			label.setText("Você pode trocar de carta "+vez+" vez(es)");
			label.setVisible(true);
			for(int i = 0; i < 5; i++) {
				if(cartas[i] == 1) {
					c[i].setVisible(false);
					aux[i] = dealer.getCard();
					
					nome1 =  String.valueOf(aux[i].getNumero());
					nome2 =  String.valueOf(aux[i].getNaipe());
					nome = nome1+nome2;
				
					icon = new ImageIcon("src\\PNG\\"+nome+".png");
					img = icon.getImage() ;  
					imgc1 = img.getScaledInstance( 232, 400,  java.awt.Image.SCALE_SMOOTH ) ;  
					icon = new ImageIcon( imgc1 );
					c[i].setIcon(icon);
					c[i].setVisible(true);
					cartas[i]*=-1;
				}
			}
		}
		//se clicar em continuar, vai para a tela de resultados
		else if(e.getActionCommand().equals("continuar")) {
			jog.setMao(aux);
			jog.cashIn();
			this.setVisible(false);
			this.dispose();				
			Continue continuar = new Continue(jog);
			continuar.setVisible(true);
		}
		
	}

}
