package jeux;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;

import javax.swing.*;




public class gam {
	
	static JDialog dl=new JDialog(); static JLabel l=new JLabel();

	static JFrame frame=new JFrame();
	static JPanel panel=new JPanel();
	static JPanel panmain=new JPanel();
	static JPanel panr=new JPanel();
	static JPanel panl=new JPanel();
	static JPanel panu=new JPanel();
	static JPanel pand=new JPanel();
	static JPanel t[]= new JPanel[24];
	static JPanel rectangle=new JPanel();
	
	static int r1=200,r2=330;
	static int x=100,y=200,X,Y;
	static int z=40,w=20;
	static int touch=0,tour,right=1,left=1,up=1,juste=0,ju=1;
	static int f=0,cpt=0;
	static int value=0;
	
	public static JPanel creatpl(int x,int y) {
		JPanel pan=new JPanel();
		pan.setBounds(x, y, 50, 30);
		pan.setBackground(Color.white);
		panmain.add(pan);
		return pan;
	}
	
	
	public static void main(String [] args) {
		frame.setBounds(100, 100, 500, 400);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		dl.setBounds(100, 100, 300, 200);
		dl.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		dl.setLayout(null);
		l.setBounds(20, 20, 200, 50);
		dl.add(l);
		
		panmain.setBounds(0, 0, 500, 400);
		panmain.setBackground(Color.black);
		panmain.setLayout(null);
		frame.add(panmain);
		
		
		panel.setBounds(x, y, 20, 20);
		panel.setBackground(Color.red);
		panmain.add(panel);
		
		panr.setBounds(0, 0, 10, 400);
		panr.setBackground(Color.yellow);
		panmain.add(panr);
		
		panl.setBounds(473, 0, 10, 400);
		panl.setBackground(Color.yellow);
		panmain.add(panl);
		
		panu.setBounds(0, 0, 500, 10);
		panu.setBackground(Color.yellow);
		panmain.add(panu);
		
		pand.setBounds(0, 350, 500, 10);
		pand.setBackground(Color.red);
		panmain.add(pand);
		
		rectangle.setBounds(r1, r2, 100, 10);
		rectangle.setBackground(Color.green);
		panmain.add(rectangle);
		
		//////////////////////////////////////
		for(int i=0;i<=2;i++) {
			for(int j=0;j<=7;j++) {
				t[f]=creatpl(z,w);
				z=z+52;
				f++;
			}
			z=40;
			w=w+32;
		}
		//////////////////////////////////////
		
		
		frame.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()== KeyEvent.VK_UP) {
					tour=1;ju=tour;
					X=x;Y=y;
					x=x-1; y=y-1;
					panel.setBounds(x, y, 20, 20);
				}
				if(e.getKeyCode()== KeyEvent.VK_RIGHT) {
					r1=r1+10;
					rectangle.setBounds(r1, r2, 100, 10);
				}
				if(e.getKeyCode()== KeyEvent.VK_LEFT) {
					r1=r1-10;
					rectangle.setBounds(r1, r2, 100, 10);
				}
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
		
		
		
		panel.addComponentListener(new ComponentListener() {
			
			@Override public void componentResized(ComponentEvent e) {}   @Override  public void componentHidden(ComponentEvent e) {}
			@Override public void componentShown(ComponentEvent e) {}
			

			@Override
			public void componentMoved(ComponentEvent e) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				/////////////////////////////////////////////////////////////////////////////////////
				if(value==24) {l.setText("you win this game"); dl.setVisible(true);}
				if(panel.getY()>500) {l.setText("you lose this game"); dl.setVisible(true);}
				
				/////////////////////////////////////////////////////////////////////////////////////
				///////////////////////////////////////////////////////////////////////////////////////////////////
				if(x<=10 ) {tour=1-tour; right=tour; /**/up=1-tour; left=1-tour; touch=0; juste=0; cpt++;}
				if(y<=10 ) {tour=1-tour; up=tour; /**/ right=1-tour; left=1-tour; touch=0; juste=0;}
				if(x>=473 ) {tour=1-tour; left=tour; /**/ right=1-tour; up=1-tour; touch=0; juste=0;}
				///////////////////////////////////////////////////////////////////////////////////////////////////////////
				//touch white panel
				for(int j=0;j<=23;j++) {
					JPanel p=new JPanel();
					p=t[j];
					
					if((panel.getY()==p.getY()+30 && panel.getX()-p.getX()<=50 &&  panel.getX()-p.getX()>0)) { ju=tour; up=1-tour; right=1-tour; left=1-tour; touch=1;  juste=0; p.setBounds(0, 0, 0, 0); value++;}
					if((panel.getX()==p.getX()+50 && panel.getY()-p.getY()<=30 && panel.getY()-p.getY()>0)) {left=tour; up=1-tour; right=1-tour; ju=1-tour; touch=1;  juste=0; p.setBounds(0, 0, 0, 0); value++;}
					if((panel.getY()+20==p.getY() && panel.getX()-p.getX()<=50 &&  panel.getX()-p.getX()>0 )) {up=tour; left=1-tour; right=1-tour; ju=1-tour; touch=1;  juste=0; p.setBounds(0, 0, 0, 0); value++;}
					if((panel.getX()+20==p.getX() && panel.getY()-p.getY()<=30 && panel.getY()-p.getY()>0)) {right=tour; up=1-tour; left=1-tour; ju=1-tour; touch=1;  juste=0; p.setBounds(0, 0, 0, 0); value++;}
				}
				/////////////////////////////////////////////////////////////////////////////////////////////////////////////
				//white panel
				
				if(touch==1 && ju==tour) {
					System.out.println("down");
					up=1-tour; right=1-tour; left=1-tour;
					if(up!=tour && left!= tour && right != tour) {
					if(panel.getX()>X) {
						X=x;Y=y;
						x=x+1; y=y+1;
						panel.setBounds(x, y, 20, 20);
					}
					else if(panel.getX()<X) {
						X=x;Y=y;
						x=x-1; y=y+1;
						panel.setBounds(x, y, 20, 20);
					}
					}
				}
				
				
				if(touch==1 && left==tour &&  juste==0) {
                	System.out.println("left");
					up=1-tour; right=1-tour;
					if(panel.getY()>Y) {
						X=x;Y=y;
						x=x+1; y=y+1;
						panel.setBounds(x, y, 20, 20);
					}
					else if(panel.getY()<Y) {
						X=x;Y=y;
						x=x+1; y=y-1;
						panel.setBounds(x, y, 20, 20);
					}
				}
				
				
				if(touch==1 && right==tour && juste==0) {
					System.out.println("righht");
					up=1-tour; left=1-tour;
					if(panel.getY()>Y) {
						X=x;Y=y;
						x=x-1; y=y+1;
						panel.setBounds(x, y, 20, 20);
					}
					else if(panel.getY()<Y) {
						X=x;Y=y;
						x=x-1; y=y-1;
						panel.setBounds(x, y, 20, 20);
					}
				}
				
				
				
				if(touch==1 && up==tour &&  juste==0) {
					System.out.println("up");
					right=1-tour; left=1-tour;
					if(panel.getX()>X) {
						X=x;Y=y;
						x=x+1; y=y-1;
						panel.setBounds(x, y, 20, 20);
					}
					else if(panel.getX()<X) {
						X=x;Y=y;
						x=x-1; y=y-1;
						panel.setBounds(x, y, 20, 20);
					}
				}
				
				
				
                
				
				
				
				
				
				
				
				/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				//panel rectangle
				if(panel.getY()+20==r2 && panel.getX()-r1<=100 && panel.getX()-r1>0) {
					juste=1; ju=1-tour;
				}
				
				if(juste==1 ) {
					if(panel.getX()>X) {
						X=x;Y=y;
						x=x+1; y=y-1;
						panel.setBounds(x, y, 20, 20);
					}
					else if(panel.getX()<X) {
						X=x;Y=y;
						x=x-1; y=y-1;
						panel.setBounds(x, y, 20, 20);
					}
					
				}
				
				
				/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				//panel right
				if(tour==right && touch==0 && juste==0) {
					up=1-tour; left=1-tour; touch=0; ju=0;
					if(cpt==0) {
						X=x;Y=y;
						x=x+1; y=y-1;
						panel.setBounds(x, y, 20, 20);
					}
					else if(cpt!=0) {
					if(panel.getY()<Y) {
						X=x;Y=y;
						x=x+1; y=y-1;
						panel.setBounds(x, y, 20, 20);
						}
					else if(panel.getY()>Y) {
						X=x;Y=y;
						x=x+1; y=y+1;
						panel.setBounds(x, y, 20, 20);
					}
					}
				}
				
				
				//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				//panel up
				if(tour==up && touch==0 && juste==0) {
					right=1-tour; left=1-tour; touch=0; ju=0;
					if(panel.getX()>X) {
						X=x;Y=y;
						x=x+1; y=y+1;
						panel.setBounds(x, y, 20, 20);
						}
					else if(panel.getX()<X) {
						X=x;Y=y;
						x=x-1; y=y+1;
						panel.setBounds(x, y, 20, 20);
					}
				}
				
				
				///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				//panel left
				if(tour==left && touch==0 && juste==0) {
					
					right=1-tour; up=1-tour; touch=0; ju=0;
					if(panel.getY()>Y) {
						X=x;Y=y;
						x=x-1; y=y+1;
						panel.setBounds(x, y, 20, 20);
						}
					else if(panel.getY()<Y) {
						X=x;Y=y;
						x=x-1; y=y-1;
						panel.setBounds(x, y, 20, 20);
					}
				}
				
				
				
			}
		});
		
	}
}
