class FatherThread implements Runnable{
    public void run(){
        System.out.println("爸爸想抽烟，发现烟抽完了");
        System.out.println("爸爸让儿子去买包红塔山");
        Thread son = new Thread(new SonThread());
        son.start();
        System.out.println("爸爸等儿子买烟回来");
        try{
            son.join();
        }catch(InterruptedException e){
            e.printStackTrace();
            System.out.print("爸爸出门去找儿子，儿子去哪儿??\n");
            System.exit(1);
        }
        System.out.println("爸爸高兴的接过烟开始抽，并把零钱给了儿子");
    }
}
class SonThread implements Runnable{
    public void run() {
        System.out.println("儿子出门去买烟");
        System.out.println("儿子买烟需要10分钟");
        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println("第" + i + "分钟");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("儿子买烟回来了");
    }

}

public class TestThreadJoin {

    public static void main(String[] args){
        System.out.println("爸爸和儿子买烟的故事");
        Thread father = new Thread(new FatherThread());
        father.start();
    }

}