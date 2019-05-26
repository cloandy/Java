/**
 * 装饰器模式
 */

import java.io.*;

public class test11{
    public static void main(String[] args){
        Iphone iPhone = new Iphone("iPhone3.0");
        iPhone.show();
        System.out.println("********装饰后********");
        TouYingIPhone touYingIPhone = new TouYingIPhone(iPhone);
        touYingIPhone.Show();
    }
}
/**手机类 */
class Iphone {
    private String name;
    public Iphone(String name) {
        this.name = name;
    }
    public void show() {
        System.out.println("我是" + name + ",可以在屏幕上显示");
    }
}
/*装饰器模式*/
class TouYingIPhone{
    public Iphone iphone;
    public TouYingIPhone(Iphone iphone){
        this.iphone = iphone;
    }

    public void Show(){
        iphone.show();
        System.out.println("还可以投影，在墙壁上显示");
    }

}