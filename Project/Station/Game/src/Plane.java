

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

/**
 * 飞机类：
 * 	继承了游戏目标类，具有童颜的属性
 * 重写绘画类
 * */
public class Plane extends GameObject {

	boolean left,right,up,down;
	boolean live =true; //飞机是死还是活
	public void addDirection(KeyEvent e) {
		switch(e.getKeyCode()) {
		
		case KeyEvent.VK_LEFT:
			left = true;
			break;
		case KeyEvent.VK_RIGHT:
			right = true;
			break;
		case KeyEvent.VK_UP:
			up = true;
			break;
		case KeyEvent.VK_DOWN:
			down = true;
			break;
		default:
			break;
			
		}
	}
	
	public void minusDirection(KeyEvent e) {
		switch(e.getKeyCode()) {
		
		case KeyEvent.VK_LEFT:
			left = false;
			break;
		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		case KeyEvent.VK_UP:
			up = false;
			break;
		case KeyEvent.VK_DOWN:
			down = false;
			break;
		default:
			break;
			
		}
	}
	@Override
	public void drawMySelf(Graphics g) {
		if(live) {
			super.drawMySelf(g);
			if(left) {
				x -= speed;
				if(x <= 10)
					x = 10;
			}
			if(right) {
				x += speed;
				if(x >= 460)
					x = 460;
			}
			if(up) {
				y -= speed;
				if(y <= 10)
					y = 10;
			}
			if(down) {
				y += speed;
				if(y >= 460)
					y = 460;
			}
		}
	}
	
	public Plane(Image img, int x, int y,int speed) {
		super(img,x,y);
		this.speed = speed;
	}
	
}
