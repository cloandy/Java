
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        SyncStack sStack = new SyncStack(); //定义缓冲区
        shengchanzhe sc = new shengchanzhe(sStack);//定义生产者线程
        xiaofeizhe xf = new xiaofeizhe(sStack);//定义消费者线程
        sc.start();//启动生产者线程
        xf.start();//启动消费者线程
	}

}
