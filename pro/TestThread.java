/**
 * TestThread
 * 缺点：无法再次继承别的类了
 */

public class TestThread extends Thread{
   
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