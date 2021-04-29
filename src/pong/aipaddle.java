


package pong;

import java.awt.Color;
import java.awt.Graphics;

public class aipaddle implements paddle {
	double y,yVel;
	boolean upaccel,downaccel;
	int player,x;
	final double gravity=0.94;
	ball b1;
	public aipaddle(int player,ball b) {
		upaccel=false;downaccel=false;
		b1=b;
		y=210;yVel=0;
		if(player ==1)
			x=20;
		else
			x=660;
	}
	public void draw(Graphics g) {
	g.setColor(Color.white);
	g.fillRect(x, (int)y, 20, 80);
		
	}

	@Override
	public void move() {
		y=b1.getY()-40;
		
		if(y<0) {
			y=0;
		}
		
		if(y>420) {
			y=420;
		}
	}
	
	public void setUpaccel (boolean input) {
		upaccel = input;
	}
	
	public void setDownaccel (boolean input) {
		downaccel = input;
	}
	
	public int getY() {
		
		return (int)y;
	}

}
