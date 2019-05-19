
public class xiaofeizhe extends Thread {

	SyncStack ssStack = null;
	public xiaofeizhe(SyncStack ssStack) {
		this.ssStack = ssStack;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i ++) {
			ssStack.pop();
			System.out.println("Ïû·ÑÂøÍ·£º" + i);
		}
	}
}
