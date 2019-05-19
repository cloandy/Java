/*
 * 飞机大战游戏
 * @author 王永坤
 * 2019-5-17 17:29:30
 */

/*导入包*/
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.util.ArrayList;

/*继承JFrame类，JFrame类是java.swing 中的主要类*/
/*我们画的窗口都需要继承JFrame类*/
public class MyGameFrame extends JFrame {
	/*图片资源路径*/
	 Image bgImg = GameUtil.getImage("image/bg.jpg");
	 Image planeImg = GameUtil.getImage("image/plane.png");
	 /*创建飞机对象*/
	 Plane plane3 = new Plane(planeImg, 300, 400,5);
	 /*炮弹容器*/
	 ArrayList<Shell> shellList = new ArrayList<Shell>();
	 /*爆炸对象*/
	 Explode bao;
	 /*双缓冲技术*/
	 private Image offScreenImage = null;
	 public void update(Graphics g) {
		 if(offScreenImage == null)
			 offScreenImage = this.createImage(500,500);
		 Graphics goff = offScreenImage.getGraphics();
		 paint(goff);
		 g.drawImage(offScreenImage, 0, 0,null);
	 }
	 
	/*paint()函数重写，可在窗体中显示内容或者画图，会被系统自动调用*/
	@Override
	public void paint(Graphics g) {
		
		/*绘制窗体背景*/
		g.drawImage(bgImg, 0, 0, null);
		/*画出飞机本身*/
		plane3.drawMySelf(g);

		/*炮弹输出*/
		for(int i = 0; i < shellList.size(); i++ ) {
			Shell b = shellList.get(i);
			b.draw(g);
			/*碰撞检测*/
			boolean peng = b.getRect().intersects(plane3.getRect());
			if(peng) {
				plane3.live = false;
				/*爆炸效果*/
				if(bao == null) {
					bao = new Explode(plane3.x, plane3.y);
				}
				bao.draw(g);
			}
		}
	}
	 /*内部类，线程运行*/
	 class PaintThread extends Thread{
		 
		 public void run() {
			 while(true) {
				 repaint();
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		 }
	 }
	public void launchFrame() {
		/*设置窗口左上角名称*/
		setTitle("Windows for Game");

		/*设置窗体大小*/
		setSize(500, 500);
		/*设置窗体左上角顶点位置，桌面左上角为原点*/
		setLocation(150, 150);
		/*设置窗口可显示，会自动的调用paint方法*/
		setVisible(true);
		/*Frame类无处理关闭窗口得功能，需要自己添加关闭功能*/
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("Windows Exit!");
				System.exit(0);
			}
		});
		/*加载炮弹*/
		for(int i = 0; i< 50; i++) {
			Shell b = new Shell();
			shellList.add(b);
		}
		/*开启线程*/
		new PaintThread().start();
		/*增加按键监控*/
		addKeyListener(new KeyMonitor());
	}
	/*内部类，按键的按下和松开的方法重写*/
	class KeyMonitor extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            plane3.addDirection(e);
        }
 
        @Override
        public void keyReleased(KeyEvent e) {
            plane3.minusDirection(e);
        }
	}
	public static void main(String[] args) {
        MyGameFrame f = new MyGameFrame();
        f.launchFrame();
    }
}