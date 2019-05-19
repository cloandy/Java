
import java.awt.Graphics;
import java.awt.Image;;

public class Explode  {

	int x,y;
	static Image[] imgs = new Image[16];
	static {
		for(int i = 0; i < 16; i ++) {
			imgs[i] = GameUtil.getImage("explode/e" + (i+1)+".gif");
			imgs[i].getWidth(null);
		}
	}
	
	int cnt;
	
	public void draw(Graphics g) {
		if (cnt <= 15) {
			g.drawImage(imgs[cnt], x, y, null);
			cnt ++;
		}
	}
	
	
	public Explode(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
