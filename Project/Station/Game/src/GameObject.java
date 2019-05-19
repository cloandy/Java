

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

/**
 * 游戏目标类：
 * 属性:
 * 	图片路径
 * 	坐标x,y
 *  物体自身长度和宽度
 * 方法：
 * 	构造方法
 *  绘制矩形对象，进行防碰撞检测
 *  在画布上绘制对象
 * */


/*游戏目标类*/
public class GameObject {
	/*图片资源*/
	Image img;
	/*图片坐标*/
	int x,y;
	/*运行速度*/
	int speed;
	/*物体的宽度和长度*/
	int width,height;
	
	public GameObject(Image img, int x, int y) {
		
		this.img = img;
		this.x = x;
		this.y = y;
		if(img != null) {
			/*得到其自身的长度和宽度*/
			this.width = img.getWidth(null);
			this.height = img.getHeight(null);
		}
	}
	
	public GameObject(Image img, int x, int y, int speed, int width, int height ) {
		
		this.img = img;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public GameObject() {
		
	}
	
	public Rectangle getRect() {
		return new Rectangle(x, y, width, height);
	}
	
	
	public void drawMySelf(Graphics g) {
		g.drawImage(img, x, y, null);
	}
}
