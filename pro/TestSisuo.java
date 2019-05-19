class Lipstick{

}
class Mirror{

}
class MakeUp extends Thread{
    int flag;
    String girl;
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    @Override
    public void run(){

        doMakeup();
    }

    void doMakeup(){
        if(flag == 0){
            synchronized(lipstick){
                System.out.println(girl + "拿着口红！");
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }

                synchronized(mirror){
                    System.out.println(girl + "拿着镜子！");
                }
            }
        } else{
            synchronized (mirror) {
                System.out.println(girl + "拿着镜子！");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lipstick) {
                    System.out.println(girl + "拿着口红！");
                }
            }

        }
    }
}

public class TestSisuo{

    public static void main(String[] args){

        MakeUp m1 = new MakeUp();
        m1.girl = "大丫";
        m1.flag = 0;

        MakeUp m2 = new MakeUp();
        m2.girl = "小丫";
        m2.flag = 1;

        m1.start();
        m2.start();

    }

}