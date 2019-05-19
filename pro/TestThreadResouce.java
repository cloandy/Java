/**
 * 得到基本信息
 */
public class TestThreadResouce extends Thread{
    
    public void run(){
        for(int i = 0; i< 10; i++){
            System.out.println(i);
        }
    }
    public static void main(String[] args){

        TestThreadResouce t = new TestThreadResouce();
        t.start();

        System.out.println("线程名称叫做：" + t.getName());
        try{
            TestThreadResouce.currentThread().sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace();
            System.out.println("ERROR!");
        }
        
        System.out.println(t.isAlive());
        System.out.println("Over!");

    }
}