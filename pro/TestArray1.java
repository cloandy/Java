/**
 * 测试数组的引用类型
 */
class Man{
    private int age;
    private int id;
    public Man(int id,int age) {
        super();
        this.age = age;
        this.id = id;
    }
}
public class TestArray1{
    public static void main(String[] args){

        Man[] mans1; //声明引用类型数组
        mans1 = new Man[10];  //在堆上创建Man引用类型数组对象，共10个成员

        Man mans2 = new Man(1,11); 
        Man mans3 = new Man(2,22);

        mans1[0] = mans2; //引用类型对象的成员0和mans2的引用类型 引用相同的对象
        mans1[1] = mans3;

    }
}