package pack;
/**
 * 以后必须创建包名
 * 反射：把Java的各种结构映射成一个个Java对象
 * 1、获取Class对象
 * 	1.1 有了一个对象，可以直接得到
 *  1.2有了一个对象的模型类，可以得到其结构
 *  1.3模型类需要寻找，寻找后，可以得到其结构
 *	三种方式：Class.forName("完整路径");
 * 2、动态创建对象 
 *  推荐写法
 *  clz.getConstructor().newInstance();
 */

public class test {

	public static void main(String[] args) throws Exception {
		//1.三种方式获得class对象
		//1.1提供对象，对象.getClass
		Class clz = new phone().getClass();
		
		//1.2.类.Class()
		clz = phone.class;
		
		//1.3. Class.forName("phone");
		clz = Class.forName("pack.phone");
		//2 创建动态对象，降低了耦合度
		phone phone1 = (phone)clz.getConstructor().newInstance();
		System.out.println(phone1);
		
	}
}

class phone{
	public phone() {
		
	}
}
