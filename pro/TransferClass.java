public class TransferClass{
    static int i =  47;
    public void call(){
        System.out.println("调用call方法");
        for(i = 0; i < 3 ;i++){
            System.out.println(i + "\t");
            if(i == 2)
                System.out.print("\n");
        }
    }
    public TransferClass(){
        System.out.print("创建TransferClass对象\n");
    }

    public static void main(String[] srgs){
        TransferClass tc1 = new TransferClass();
        TransferClass tc2 = new TransferClass();
        tc1.i = 60;
        System.out.print("第一个实例化对象tc1调用变量i的结果为：" + tc1.i + "\n");
       // tc2.i = 30;
        System.out.print("第二个实例化对象tc1调用变量i的结果为：" + tc2.i + "\n");
        tc1.call();
        tc2.call();
    }
}

/**
非静态变量i:
创建TransferClass对象
创建TransferClass对象
第一个实例化对象tc1调用变量i的结果为：60
第二个实例化对象tc1调用变量i的结果为：30
调用call方法
0
1
2
调用call方法
0
1
2

//两个对象是独立的内存
 */