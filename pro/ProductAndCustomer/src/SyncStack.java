/**
 * 	���建������
 * 	���ԣ�
 * 		����ֵ
 * 	����;
 * 		�����ߵ�push����
 * 		�����ߵ�pop����
 * 
 * */
public class SyncStack {
	/* ����������ͷ���� */
	int index = 0;
	/* ���建������ͷ����Ϊ10�� */
	Mantou[] mt = new Mantou[10];
	
	public synchronized void push(Mantou m) {
		while(index == mt.length) {
			try {
				this.wait();
			}catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		this.notify();
		//System.out.println("�����߼����̣߳�");
		mt[index] = m;
		index ++;
		
	}
	
	public synchronized Mantou pop() {
		while(index == 0) {
			try {
				this.wait();
			}catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		//System.out.println("�����߼����̣߳�");
		this.notify();
		index --;
		return mt[index];
		
	}

}
