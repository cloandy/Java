
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        SyncStack sStack = new SyncStack(); //���建����
        shengchanzhe sc = new shengchanzhe(sStack);//�����������߳�
        xiaofeizhe xf = new xiaofeizhe(sStack);//�����������߳�
        sc.start();//�����������߳�
        xf.start();//�����������߳�
	}

}
