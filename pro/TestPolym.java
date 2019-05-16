import javafx.scene.AmbientLight;

/**
 * 同一个动作，不同动物的反应
 * 测试多态的三个必要条件
 */

 //继承和方法重写
class Animal {
    public void shout() {
        System.out.println("叫了一声！");
    }
}
class Dog extends Animal {
    public void shout() {
        System.out.println("旺旺旺！");
    }
    public void seeDoor() {
        System.out.println("看门中....");
    }
}
class Cat extends Animal {
    public void shout() {
        System.out.println("喵喵喵喵！");
    }
}

public class TestPolym{
    public static void main(String[] args){
        Animal an1 = new Animal();
        Animalshout(an1);
        //父类引用指向子类对象
        Animal an2 = new Dog();
        Animalshout(an2);

        Animal an3 = new Cat();
        Animalshout(an3);

    }

    static void Animalshout(Animal an){
        an.shout();
    }
}
