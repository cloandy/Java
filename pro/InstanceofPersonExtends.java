/**
 * instanceof 的用法
 */
class Person{
    String name;
    int age;
    int height;

    public void rest(){
        System.out.println("休息一会！");
    }
}
//派生类
class Student extends Person{

    String major;

    public Student(String name, int age, int height,String major){

        this.name = name;
        this.age = age;
        this.height = height;
        this.major = major; 
    }

    public void study(){
        System.out.println("学习Java!");
    }
}


public class InstanceofPersonExtends{
    public static void main(String[] args){

        Student Stu1 = new Student("wyk",24,175,"automation");
        Stu1.study();
        Stu1.rest();
        Stu1.study();

        System.out.println( Stu1 instanceof Student );
        System.out.println( Stu1 instanceof Person );

    }
}