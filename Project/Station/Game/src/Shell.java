

import java.awt.Color;
import java.awt.Graphics;


public class Shell extends GameObject{
	
	double degree;
	
	public Shell() {
		
		degree = Math.random() * Math.PI * 2 ;
		x = 200;
		y = 200;
		width = 10;
		height = 10;
		speed = 3;
	}
	
	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.yellow);
		
		g.fillOval(x, y, width, height);
		
		x += (int)(speed*Math.cos(degree));
		y += (int)(speed*Math.sin(degree));
		
		if(y > (500 - 10) || y < 30) {
			degree = -degree;
		}
		
		if(x < 0 || x > (500 -10)) {
			degree = Math.PI -degree;
		}
		
		g.setColor(c);
	}

}
