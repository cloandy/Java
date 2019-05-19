
public class shengchanzhe extends Thread{
	
	SyncStack ssStack = null;
	public shengchanzhe(SyncStack ssStack) {
		this.ssStack = ssStack;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i ++) {
			System.out.println("Éú²úÂøÍ·£º" + i);
			
			Mantou mt = new Mantou(i);
			ssStack.push(mt);
		}
	}
	
}
