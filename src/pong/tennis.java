package pong;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class tennis extends Applet implements Runnable,KeyListener {
	final int width = 700,HEIGHT= 500;
	Thread thread;
	humanpaddle p1;
	ball b1;
	aipaddle p2;
	Image img;
	Graphics gfx;
	boolean gameStart;
	public void init () {
		this.resize(width,HEIGHT);
		gameStart = false;
				
		this.addKeyListener(this);
		
		p1=new humanpaddle(1);
		b1= new ball();
		p2=new aipaddle(2, b1);
		img = createImage(width, HEIGHT);
		gfx=img.getGraphics();
		thread=new Thread(this);
		thread.start();
	}
	public void paint (Graphics g) {
		gfx.setColor(Color.black);
		gfx.fillRect(0, 0, width, HEIGHT);
		
		if(b1.getX()<-10||b1.getY()>710) {
			g.setColor(Color.red);
			g.drawString("game over", 350, 250);
		}else {
		
		p1.draw(gfx);
		b1.draw(gfx);
		p2.draw(gfx);
		}
		if(!gameStart) {
			gfx.setColor(Color.white);
			gfx.drawString("Tennis ", 340, 100);
			gfx.drawString("Press ENTER to begin", 310, 130);
		}
		g.drawImage(img, 0, 0, this);
		}
	public void update (Graphics g) {
		paint(g);
	}
	@Override
	public void run() {
		for(;;) {
			
			if(gameStart) {
			p1.move();
			p2.move();
			b1.move();
			b1.checkpaddle(p1, p2);
			}
			repaint();
			try {
				Thread.sleep(10);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode()==KeyEvent.VK_UP) {
		p1.setUpaccel(true);
		}else if(arg0.getKeyCode()==KeyEvent.VK_DOWN) {
		p1.setDownaccel(true);
		}else if(arg0.getKeyCode()==KeyEvent.VK_ENTER) {
			gameStart = true;
		}
		
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		if(arg0.getKeyCode()==KeyEvent.VK_UP) {
			p1.setUpaccel(false);
		}else if(arg0.getKeyCode()==KeyEvent.VK_DOWN) {
			p1.setDownaccel(false);
		}
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
