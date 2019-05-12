
public class User2 {
    int id; // id
    String name; // 账户名
    String pwd; // 密码
     
    static String company = "wyk"; // 类变量
     
     
    public User2(int id, String name) {
        this.id = id;
        this.name = name;
    }
     
    public void login() {
        printCompany();
        System.out.println(company); 
        System.out.println("登录：" + name);
    }
     
    public static void printCompany() {
//         login();//调用非静态成员，编译就会报错
        System.out.println(company);
    }
     
    public static void main(String[] args) {
        User2 u = new User2(101, "wyk");
        User2.printCompany();
        User2.company = "111";
        User2.printCompany();
    }
}