/**
 * 静态初始化块
 */
public class User3 {
    int id;        //id
    String name;   //账户名
    String pwd;   //密码
    static String company; //公司名称
    static {
        System.out.println("执行类的初始化工作");
        company = "北京";
        printCompany();
    }  
    public static void printCompany(){
        System.out.println(company);
    }  
    public static void main(String[] args) {
        //进行类的初始化工作
        User3  u3 = null;
        //new User3 创建对象
        //()调用构造函数
    }
}