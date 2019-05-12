class Parent{
    public Parent(){
        System.out.println("构造父类对象Parent!");
    }
}

class SubParent extends Parent{
    public SubParent(){
        System.out.println("构造子类对象SubParent!");
    }
}

public class class110{
    public static void main(String[] args){

        SubParent sc = new SubParent(); 

    }
}