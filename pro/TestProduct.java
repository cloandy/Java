/**
 * 测试生产者和消费者的线程并发协同
 */
public class TestProduct{

    public static void main(String[] args){

        SyncStack sStack = new SyncStack(); //定义缓冲区
        Shengchan sc = new Shengchan(sStack);//定义生产者线程
        Xiaofei xf = new Xiaofei(sStack);//定义消费者线程
        sc.start();//启动生产者线程
        xf.start();//启动消费者线程
    }
}
/**
 * 定义馒头类
 */
class Mantou{
    int id;
    public Mantou(int id){
        this.id = id;
    }
}
/**
 * 缓冲区类：
 *  属性：缓冲区索引
 *  方法：出缓冲区
 *       入缓冲区
 */
class SyncStack{
    int index = 0;
    Mantou[] ms = new Mantou[10];
    /**生产者所采用的 */
    public synchronized void push(Mantou m){
        while(index == ms.length){
            try{
                this.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        /**唤醒当前对象等待池中的第一个线程 */
        this.notify();
        ms[index] = m;
        index ++;
    }
    /**消费者所采用的 */
    public synchronized Mantou pop(){
        while(index == 0){
            try{
                this.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }

        this.notify();
        index --;
        return ms[index];
    }
}
/**
 * 定义生产者
 */
class Shengchan extends Thread{
    SyncStack ss = null;

    public Shengchan(SyncStack ss){
        this.ss = ss;
    }

    @Override
    public void run(){

        for(int i = 0; i< 10; i ++){
            System.out.println("生产馒头：" + i);
            Mantou m = new Mantou(i);
            ss.push(m);
        }
    }
}
/**
 * 定义消费者
 */
class Xiaofei extends Thread{
    SyncStack ss = null;

    public Xiaofei(SyncStack ss){
        this.ss = ss;
    }

    @Override
    public void run(){

        for(int i = 0; i< 10; i ++){
            Mantou m = ss.pop();
            System.out.println("消费馒头：" + i);
        }
    }
}