package bird;

import java.awt.Color;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class bir {

	/*main frame*/static JFrame frame=new JFrame();
	/*main panel*/static JPanel mainpanel = new JPanel();
	/*player panel*/static JPanel panel = new JPanel();
	
	//green panels
	static JPanel p1 = new JPanel();
	static JPanel p2 = new JPanel();
	static JPanel p3 = new JPanel();
	static JPanel p4 = new JPanel();
	
	static JDialog dl=new JDialog();
	static JLabel l= new JLabel();
	static int score=0;
	
	static int cp1=0,cp2=0;
	
	static int x=200,y=250,up=0,cpt=0,Y=250;
	static int z1=400,w1=290,w2=200,z2=500,cpt2=0;
	static int touch=0;
	static int sleep=9;
	
	public static void main(String [] args) {
		//main frame settings
		frame.setBounds(100, 100, 600, 500);
		frame.setVisible(true);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//dialog
		dl.setBounds(100, 100, 200, 100);
		dl.setLayout(null);
		dl.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		l.setBounds(10, 10, 100, 50);
		dl.add(l);
		
		//main panel settings
		mainpanel.setBackground(Color.black);
		mainpanel.setBounds(0, 0, 600, 500);
		mainpanel.setLayout(null);
		frame.add(mainpanel);
		
		//green panels settings
		p1.setBackground(Color.red);
		p1.setBounds(z1, 0, 30, 200);
		mainpanel.add(p1);

		p2.setBackground(Color.red);
		p2.setBounds(z1, w1, 30, 211);
		mainpanel.add(p2);
		
		p3.setBackground(Color.red);
		p3.setBounds(z2, 0, 0, 100);
		mainpanel.add(p3);

		p4.setBackground(Color.red);
		p4.setBounds(z2, w2, 0, 270);
		mainpanel.add(p4);
		
		//player panel settings
		panel.setBackground(Color.green);
		panel.setBounds(x, y, 30, 30);
		mainpanel.add(panel);
		
		
		//to start playing
		frame.addKeyListener(new KeyListener() {
			@Override public void keyTyped(KeyEvent e) {}  @Override public void keyReleased(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_UP) {
					up=1;cpt=0;
					Y=y;
					y=y-2;
					panel.setBounds(x, y, 30, 30);
				}
			}
		});
		
		
		
		//player panel movement update
		panel.addComponentListener(new ComponentListener() {
			@Override public void componentResized(ComponentEvent e) {}  @Override  public void componentHidden(ComponentEvent e) {}  @Override public void componentShown(ComponentEvent e) {}
			@Override
			public void componentMoved(ComponentEvent e) {
				
				try {
					Thread.sleep(sleep);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//go to up
				if(up==1) {
				 while(sleep>7) {sleep--;}
					cpt++;
					if(cpt<20) {
						Y=y;
						y=y-1;
						panel.setBounds(x, y, 30, 30);
					}
					else if(cpt>=20) {up=0;}
				}
				//go t down
				if(up==0) {
					
					Y=y;
					y=y+1;
					panel.setBounds(x, y, 30, 30);
				}
				/////////////////////////////////////////////////////////////////////////
				if(cpt2==0) {
					
					z1=z1-1;
					p1.setBounds(z1, 0, 30, 200);
					p2.setBounds(z1, w1, 30, 211);
					
					if(panel.getX()>p1.getX()) {
						score++;
						z2=z2-1;
						p3.setBounds(z2, 0, 30, 100);
						p4.setBounds(z2, w2, 30, 270);
					}
					if(panel.getX()>p3.getX()) {
						score++;
						z1=400;
						cpt2=1;
					}
					
				}
				////////////////////////////////////////////////////////////////////////
				if(cpt2==1) {
					if(panel.getX()==p3.getX()) {z1=400;}
					if(panel.getX()==p1.getX()) {z2=500;}
					if(panel.getX()>p3.getX()) {
						score++;
						z1=z1-1;
						p1.setBounds(z1, 0, 30, 200);
						p2.setBounds(z1, w1, 30, 211);
						
						z2=z2-1;
						p3.setBounds(z2, 0, 30, 100);
						p4.setBounds(z2, w2, 30, 270);
					}
					
					
					if(panel.getX()>p1.getX()) {
						score++;
						z2=z2-1;
						p3.setBounds(z2, 0, 30, 100);
						p4.setBounds(z2, w2, 30, 270);
						
						z1=z1-1;
						p1.setBounds(z1, 0, 30, 200);
						p2.setBounds(z1, w1, 30, 211);
					}
				}
				////////////////////////////////////////////////////////////////////////////////
				
				if(x+30-p1.getX()<=30 && x+30-p1.getX()>0 && y-200<=0 ) {touch=1;}
				if(x+30-z1<=30 && x+30-z1>0 && y+30>=w1 ) {touch=1;}
				if( x+30-p3.getX()<=30 && x+30-p3.getX()>0 && y-100<=0) {touch=1;}
				if(x+30-z2<=30 && x+30-z2>0 && y+30>=w2 ) {touch=1;}
				
				/////////////////////////////////////////////////////////////////////////////////
				if(touch ==1) {
					if(Y<y) {y=y-1;}
					if(Y>y) {y=y+1;}
					l.setText("your score is "+score);
					dl.setVisible(true);
				}
			}

		});
	}
}
