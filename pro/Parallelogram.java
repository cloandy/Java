class Quadrangle{ //四边形类
    public Quadrangle(){
        System.out.println("构造Quadrangle类的一个实例");
    }
    public static void draw(Quadrangle q){
          
    }
}

class Square extends Quadrangle{ //正方形类
    public Square(){
    System.out.println("构造Square类的一个实例");
    }
}
class Anything{         //其他类

}

public class Parallelogram extends Quadrangle{    //平行四边形类,继承四边形类
    public static void main(String[] args){
        Quadrangle q = new Quadrangle(); //实例化父类对象
        if(q instanceof Parallelogram){  // 判断父类对象是否为Parallelogram子类的一个实例
            Parallelogram p = (Parallelogram)q; //向下转型操作
        }

        if(q instanceof Square){
            Square s = (Square)q;
        }

//        System.out.println(q instanceof Anything);

    }
}