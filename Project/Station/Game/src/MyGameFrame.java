/*
 * �ɻ���ս��Ϸ
 * @author ������
 * 2019-5-17 17:29:30
 */

/*�����*/
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.util.ArrayList;

/*�̳�JFrame�࣬JFrame����java.swing �е���Ҫ��*/
/*���ǻ��Ĵ��ڶ���Ҫ�̳�JFrame��*/
public class MyGameFrame extends JFrame {
	/*ͼƬ��Դ·��*/
	 Image bgImg = GameUtil.getImage("image/bg.jpg");
	 Image planeImg = GameUtil.getImage("image/plane.png");
	 /*�����ɻ�����*/
	 Plane plane3 = new Plane(planeImg, 300, 400,5);
	 /*�ڵ�����*/
	 ArrayList<Shell> shellList = new ArrayList<Shell>();
	 /*��ը����*/
	 Explode bao;
	 /*˫���弼��*/
	 private Image offScreenImage = null;
	 public void update(Graphics g) {
		 if(offScreenImage == null)
			 offScreenImage = this.createImage(500,500);
		 Graphics goff = offScreenImage.getGraphics();
		 paint(goff);
		 g.drawImage(offScreenImage, 0, 0,null);
	 }
	 
	/*paint()������д�����ڴ�������ʾ���ݻ��߻�ͼ���ᱻϵͳ�Զ�����*/
	@Override
	public void paint(Graphics g) {
		
		/*���ƴ��屳��*/
		g.drawImage(bgImg, 0, 0, null);
		/*�����ɻ�����*/
		plane3.drawMySelf(g);

		/*�ڵ����*/
		for(int i = 0; i < shellList.size(); i++ ) {
			Shell b = shellList.get(i);
			b.draw(g);
			/*��ײ���*/
			boolean peng = b.getRect().intersects(plane3.getRect());
			if(peng) {
				plane3.live = false;
				/*��ըЧ��*/
				if(bao == null) {
					bao = new Explode(plane3.x, plane3.y);
				}
				bao.draw(g);
			}
		}
	}
	 /*�ڲ��࣬�߳�����*/
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
		/*���ô������Ͻ�����*/
		setTitle("Windows for Game");

		/*���ô����С*/
		setSize(500, 500);
		/*���ô������ϽǶ���λ�ã��������Ͻ�Ϊԭ��*/
		setLocation(150, 150);
		/*���ô��ڿ���ʾ�����Զ��ĵ���paint����*/
		setVisible(true);
		/*Frame���޴���رմ��ڵù��ܣ���Ҫ�Լ���ӹرչ���*/
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("Windows Exit!");
				System.exit(0);
			}
		});
		/*�����ڵ�*/
		for(int i = 0; i< 50; i++) {
			Shell b = new Shell();
			shellList.add(b);
		}
		/*�����߳�*/
		new PaintThread().start();
		/*���Ӱ������*/
		addKeyListener(new KeyMonitor());
	}
	/*�ڲ��࣬�����İ��º��ɿ��ķ�����д*/
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