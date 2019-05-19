/**
 * 测试线程的死亡
 */

 public class TestThreadStop implements Runnable{

    String name;
    boolean live = true;

    public TestThreadStop(String name){
        super();
        this.name = name;
    }

    public void run(){
        int i = 0;
        while(live){
            System.out.println(name + (++i));
        }
    }

    public void terminate(){
        live = false;
    }

    public static void main(String[] args){
        TestThreadStop ts1 = new TestThreadStop("线程A");
        Thread t1 = new Thread(ts1);
        t1.start();

        for(int i = 0; i < 10; i++){
            System.out.println("主线程" + i);
        }

        ts1.terminate();
        System.out.println("ts1 stop!");
        
    }

 }