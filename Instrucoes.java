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

public class Instrucoes extends JFrame implements ActionListener{
	JPanel jp, botao;
	JButton voltar;
	JLabel instr;
	JDesktopPane desktop;
	public Instrucoes() {
		jp = (JPanel) this.getContentPane();
		jp.setLayout(new BoxLayout(jp, BoxLayout.PAGE_AXIS));
		
		botao = new JPanel();
		botao.setLayout(new FlowLayout());
		
		voltar = new JButton("Voltar");
		voltar.setActionCommand("voltar");
		voltar.addActionListener(this);
		//ajusta a imagem
		desktop = new JDesktopPane(){
			 Toolkit tk = Toolkit.getDefaultToolkit();  
	          Image im1 = (new ImageIcon("src\\PNG\\Instrucoes16x9.png")).getImage().getScaledInstance((int)tk.getScreenSize().getWidth(),(int)tk.getScreenSize().getHeight(), Image.SCALE_DEFAULT);
	          public void paintComponent(Graphics g){        
	        	  g.drawImage(im1,0,0,this);
	        	  
	          }
	      };
	      
	    jp.add(desktop);
		botao.add(voltar);
		jp.add(botao);
		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setUndecorated(true); 
		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//se clicar em voltar, volta para o menu
		if(e.getActionCommand().equals("voltar")) {
			this.setVisible(false);
			this.dispose();
			
			InterfacePoker ant = new InterfacePoker();
			ant.setVisible(true);
		}
		
	}

}
