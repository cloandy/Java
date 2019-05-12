class Computer{
	String brand;
}
//未初始化的成员变量，整型初始化为0，String类型初始化为null
public class SxtStu{
    int id;
    String name;
    int age;
    Computer comp;
    SxtStu(){
    }
    void study(){
    	int a = 0;	//局部变量
        System.out.println("我正在学习！使用我们的电脑，"+comp.brand);
    }
    
    public static void main(String[] args){
        SxtStu stu1 = new SxtStu(); 
        stu1.name = "张三";
        Computer comp1 = new Computer();
        comp1.brand = "联想";
        stu1.comp = comp1;
        stu1.study();
        
    }
    
}