/**
 * 测试数组拷贝函数
 */

public class CopyArray{

    public static void main(String[] args){

        String[] str1 = {"111","222","333","444","555"};
        String[] str2 = new String[6];
        System.arraycopy(str1, 0, str2, 0, str1.length);

        for(String str : str2)
            System.out.println(str);
    }
}