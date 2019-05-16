/**
 * 测试toString方法和重写toString方法
 */
class Person{
    String name;
    int age;

    @Override
    public String toString(){
        return "姓名：" + name + "; 年龄：" + age + ".\n";
    }
}


 public class ToString{
     public static void main(String[] args){

        Person per1 = new Person();
        per1.age = 24;
        per1.name = "wyk";
        System.out.println("Info:" + per1);

        ToString str = new ToString();
        System.out.println("Info:" + str.toString());

     }
 }