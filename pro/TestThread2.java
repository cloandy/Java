/**
 * TestThread
 * 使用Runnable接口
 */

public class TestThread2 implements Runnable{
   
    public void run(){
        for(int i = 0; i < 10; i++)
        System.out.println(this.getName() + ": " + i);
    }
    public static void main(String[] args){

        TestThread th1 = new TestThread();
        th1.start();

        TestThread th2 = new TestThread();
        th2.start();
    }
}