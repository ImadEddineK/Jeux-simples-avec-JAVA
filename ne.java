package snake;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ne {

	public static  JPanel creatP(int i,int u, JPanel p) {
		JPanel panel=new JPanel();
		panel.setBounds(i, u, 20, 20);
		panel.setBackground(Color.green);
		p.add(panel);
		return panel;
	}
	
	
	public static  void flp(JPanel bl,JPanel p) {
		
		int  m1=p.getX();
        int m2=p.getY();
         bl.setBounds(m1,m2,20,20) ;
		
	}
	
	
	
	
	static int x=10,y=10,z=70,w=60,cpt=0,t1=0,t2=0,n=0;
	
	static int  r=0,i,j=0;
	
	
	static JFrame frame= new JFrame();
	static JPanel p1= new JPanel();
	
	//last and before last panel
	static JPanel lp=new JPanel();
	static JPanel blp=new JPanel();
	public static void main(String[]args) {
	
		//declaring random object 
		Random random=new Random();
		
		//declaration
		
		JPanel p2= new JPanel();
		JPanel p3= new JPanel();
		
		//frames setting
		frame.setVisible(true);
		frame.setBounds(20, 20, 500, 400);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//big panel setting
		p1.setBounds(10, 10, 450, 320);
		p1.setBackground(Color.lightGray);
		p1.setLayout(null);
		frame.add(p1);
		
		//blue panel setting
		p2.setBounds(x, y, 20, 20);
		p2.setBackground(Color.blue);
		p1.add(p2);
		
		JPanel pt[]=new JPanel[80];
		pt[j]=p2;
		
		
		
		//red panel setting
				p3.setBounds(z, w, 20, 20);
				p3.setBackground(Color.red);
				p1.add(p3);
		
		frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) { }
 
            @Override
		public void keyPressed(KeyEvent e) {
        	
            if(e.getKeyCode() == KeyEvent.VK_RIGHT) {


            	if(n>0) {
            		for(i=j;i>=1;i--) {
            			flp(pt[i],pt[i-1]);
            		}
            	}
            	    
                    x=x+20;
                    p2.setBounds(x, y, 20, 20);
                  }
            
            
            if(e.getKeyCode() == KeyEvent.VK_LEFT) {

            	if(n>0) {
            		for(i=j;i>=1;i--) {
            			flp(pt[i],pt[i-1]);
            		}
            	}
            	
                x=x-20;
                p2.setBounds(x, y, 20, 20);
              }
            
            if(e.getKeyCode() == KeyEvent.VK_UP) {

            	if(n>0) {
            		for(i=j;i>=1;i--) {
            			flp(pt[i],pt[i-1]);
            		}
            	}
            	
                y=y-20;
                p2.setBounds(x, y, 20, 20);
              }
            
            if(e.getKeyCode() == KeyEvent.VK_DOWN) {

            	if(n>0) {
            		for(i=j;i>=1;i--) {
            			flp(pt[i],pt[i-1]);
            		}
            	}
            	
                y=y+20;
                p2.setBounds(x, y, 20, 20);
              }
            
            
            //eating red panel
            if(x+20>=z && y+20>=w && x<z+20 && y<w+20) {
            	n++;
            	j++;
            	pt[j]=creatP(x,y,p1);
               z=random.nextInt(220);
         	   w=random.nextInt(170);
         	   p3.setBounds(z,w,20,20);
         	   cpt++;
         	   
            }
		}
            
            @Override
            public void keyReleased(KeyEvent e) { }
		});
		
	}
}
