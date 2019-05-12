public class class10{
    public static void main(String[] args){
    }
}

public class Test{

    public Test(){
        System.out.println("构造的类Test!");
    }
    protected void doSomething(){
        System.out.println("doSomething!");
    }
    protected Test dolt(){
        System.out.println("dolt!");
        return new Test(); 
    } 
}

public class Test2 extends Test{  //继承父类

    public Test2(){               //构造函数
        super();                  //调用父类构造方法
        super.doSomething();      //调用父类成员方法
    }
    protected void doSomethingnew(){ //新增方法
        System.out.println("doSomethingnew!");
    }
    protected void doSomething(){    //重写父类方法
        System.out.println(" 重写 doSomething!");
    }
    protected Test2 dolt(){         //重写父类方法，方法的返回值为Test2类型
        System.out.println("dolt!");
        return new Test2(); 
    } 
}