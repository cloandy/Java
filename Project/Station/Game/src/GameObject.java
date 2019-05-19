

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

/**
 * ��ϷĿ���ࣺ
 * ����:
 * 	ͼƬ·��
 * 	����x,y
 *  ���������ȺͿ��
 * ������
 * 	���췽��
 *  ���ƾ��ζ��󣬽��з���ײ���
 *  �ڻ����ϻ��ƶ���
 * */


/*��ϷĿ����*/
public class GameObject {
	/*ͼƬ��Դ*/
	Image img;
	/*ͼƬ����*/
	int x,y;
	/*�����ٶ�*/
	int speed;
	/*����Ŀ�Ⱥͳ���*/
	int width,height;
	
	public GameObject(Image img, int x, int y) {
		
		this.img = img;
		this.x = x;
		this.y = y;
		if(img != null) {
			/*�õ�������ĳ��ȺͿ��*/
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
