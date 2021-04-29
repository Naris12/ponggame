package pong;

import java.awt.Color;
import java.awt.Graphics;

public class humanpaddle implements paddle {
	double y,yVel;
	boolean upaccel,downaccel;
	int player,x;
	final double gravity=0.94;
	public humanpaddle(int player) {
		upaccel=false;downaccel=false;
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
		if(upaccel)
		{
			yVel-=2;
		}else if (downaccel) {
			yVel+=2;
		}else if(!upaccel&&!downaccel) {
			yVel*= gravity;
		}
		if(yVel>=5)
			yVel=5;
		else if(yVel<=-5)
			yVel=-5;
		
		y+=yVel;
		
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
