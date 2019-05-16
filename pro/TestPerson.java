/**
 * 封装的使用细节
 */
public class TestPerson{
    public static void main(String[] args){

    }
}

class Person{
    private String name;
    private int age;
    private boolean flag;

    public String GetName(){
        return name;
    }
    public void SetName(String name){
        this.name = name;
    }

    public int GetAge(){
        return age;
    }
    public void SetAge(int age){
        this.age = age;
    }

    public boolean isFlag() {// 注意：boolean类型的属性get方法是is开头的
        return flag;
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}