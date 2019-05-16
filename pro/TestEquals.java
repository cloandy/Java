/**
 * 测试`==`和 equals()方法
 * 重写equals()方法
 */

public class TestEquals{

    public static void main(String[] args){
        Object obj;
        

        Person p1 = new Person(100,"wyk1",22);
        Person p2 = new Person(100,"wyk2",22);

        System.out.println(p1 == p2);
        System.out.println(p1.equals(p2));

        String str1 = new String("111");
        String str2 = new String("111");
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));

    } 
}

class Person{
    int id;
    String name;
    int age;

    Person(int id, String name, int age){
        super();
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) { //强制转型
        Person other = (Person)obj;
        return this.id == other.id;
    }

}