package pack;
/**
 * �Ժ���봴������
 * ���䣺��Java�ĸ��ֽṹӳ���һ����Java����
 * 1����ȡClass����
 * 	1.1 ����һ�����󣬿���ֱ�ӵõ�
 *  1.2����һ�������ģ���࣬���Եõ���ṹ
 *  1.3ģ������ҪѰ�ң�Ѱ�Һ󣬿��Եõ���ṹ
 *	���ַ�ʽ��Class.forName("����·��");
 * 2����̬�������� 
 *  �Ƽ�д��
 *  clz.getConstructor().newInstance();
 */

public class test {

	public static void main(String[] args) throws Exception {
		//1.���ַ�ʽ���class����
		//1.1�ṩ���󣬶���.getClass
		Class clz = new phone().getClass();
		
		//1.2.��.Class()
		clz = phone.class;
		
		//1.3. Class.forName("phone");
		clz = Class.forName("pack.phone");
		//2 ������̬���󣬽�������϶�
		phone phone1 = (phone)clz.getConstructor().newInstance();
		System.out.println(phone1);
		
	}
}

class phone{
	public phone() {
		
	}
}
