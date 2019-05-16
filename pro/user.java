//构造方法

public class user {
    int id; // id
    String name; // 账户名
    String pwd; // 密码
    public user() {
        System.out.print("使用无参数构造函数\n");
    }
    public user(int id, String name) {
        super();    //构造方法的第一句总是super()
        this.id = id; //this 表示构造好的对象
        this.name = name;
        System.out.print("使用2参数构造函数\n");
    }
    //如果方法构造中形参名与属性名相同时，需要使用this关键字区分属性与形参。
    //this.id 表示属性id;id表示形参id
    public user(int id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        System.out.print("使用3参数构造函数\n");
    }
    public static void main(String[] args) {
        user u1 = new user();
        user u2 = new user(101, "wyk");
        user u3 = new user(100, "wyk", "000000");     
    }
}