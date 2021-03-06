import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/*
 <applet code="HelloCircle" width="700" height="700">
 </applet>
 */



public class HelloCircle extends Applet implements Runnable{

	int x,y,w,h;
	Thread t;
	
	public void init(){
		
		setBackground(Color.gray);
		x=40;
		y=100;
		w=75;
		h=75;
		t=new Thread(this);
		t.start();
		addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent me){
				t.suspend();
			}
			public void mouseExited(MouseEvent me){
				t.resume();
			}
			
		});
	}
	
	public void run(){
		for(int i=21;i<=680;i++){
			x=i;
			repaint();
			if(x==680){
				i=21;
				y=y+70;
			}
			try{
				Thread.sleep(10);
			}
			catch(InterruptedException ie){}
		}
		
	}
	public void paint(Graphics g){
		
		g.drawString("Hello!",200,200);
		g.setColor(Color.white);
		g.drawOval(x,y,w,h);
	}
}

