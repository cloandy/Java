/**
 * 对象的转型操作
 */
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

public class casting {
    public static void main(String[] args){
        Animal an1 = new Animal();
        Animalshout(an1);
        //父类引用指向子类对象
        Animal an2 = new Dog();//向上转型，自动类型转化
        Animalshout(an2);

        Dog an4 = (Dog)an2; //向下转型，需要强制类型转化
        an4.seeDoor();


        Animal an3 = new Cat();
        Animalshout(an3);




    }

    static void Animalshout(Animal an){
        an.shout();
    }
}