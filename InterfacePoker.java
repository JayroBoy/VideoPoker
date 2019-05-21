import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Toolkit;

public class InterfacePoker extends JFrame implements ActionListener{
	
	JButton confirma, info,fechar; 
	JPanel jp, buttons;
	JDesktopPane desktop;
	JLabel a;
	public InterfacePoker() {
		super("VideoPoker");
		jp = (JPanel) this.getContentPane();
		jp.setLayout(new BoxLayout(jp, BoxLayout.PAGE_AXIS));
		buttons = new JPanel();
		buttons.setLayout(new GridLayout(1,3));
		desktop = new JDesktopPane(){
			 Toolkit tk = Toolkit.getDefaultToolkit();  
	          Image im1 = (new ImageIcon("PNG\\aces.png")).getImage().getScaledInstance((int)tk.getScreenSize().getWidth(),(int)tk.getScreenSize().getHeight(), Image.SCALE_DEFAULT);
	          public void paintComponent(Graphics g){        
	        	  g.drawImage(im1,0,0,this);
	        	  
	          }
	      };
	      
		confirma = new JButton("Jogar");
		confirma.setActionCommand("confirma");
		confirma.addActionListener(this);
		
		info = new JButton("Instruções");
		info.setActionCommand("info");
		info.addActionListener(this);
		
		fechar = new JButton("Fechar");
		fechar.setActionCommand("fechar");
		fechar.addActionListener(this);
		
		buttons.add(confirma);
		buttons.add(info);
		buttons.add(fechar);
		
		jp.add(desktop);
		jp.add(buttons);
		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setUndecorated(true); 
		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		InterfacePoker frame = new InterfacePoker();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("confirma")) {
			this.setVisible(false);
			this.dispose();
			Jogador j = new Jogador();
			InterfaceAposta frame = new InterfaceAposta(j);
			frame.setVisible(true);
		}
		else if(e.getActionCommand().equals("info")) {
			this.setVisible(false);
			this.dispose();
			Instrucoes frame = new Instrucoes();
			frame.setVisible(true);
		}
		else if(e.getActionCommand().equals("fechar")) {
			System.exit(0);
		}
	}

}
