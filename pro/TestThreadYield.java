/**
 * 测试yield()方法
 */
class StateThread extends Thread{
    public void run(){
        for(int i = 0; i < 100; i ++){
            System.out.println(this.getName() + ": " + i);
            Thread.yield();
        }
    }
}


public class TestThreadYield{
    
    public static void main(String[] args){

        StateThread thread1 = new StateThread();
        thread1.start();
        StateThread thread2 = new StateThread();
        thread2.start();
    }
}