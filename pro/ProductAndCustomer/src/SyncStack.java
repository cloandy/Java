/**
 * 	定义缓冲区类
 * 	属性：
 * 		索引值
 * 	方法;
 * 		生产者的push方法
 * 		消费者的pop方法
 * 
 * */
public class SyncStack {
	/* 缓冲区的馒头索引 */
	int index = 0;
	/* 定义缓冲区馒头个数为10个 */
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
		//System.out.println("生产者激活线程！");
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
		//System.out.println("消费者激活线程！");
		this.notify();
		index --;
		return mt[index];
		
	}

}
