/**
 * 题目：输入一行字符，分别统计出其英文字母、空格、数字和其它字符的个数。
 */

 import java.util.Scanner;

public class test7{
    public static void main(String[] args){

        System.out.println("输入一行字符，分别统计出其英文字母、空格、数字和其它字符的个数");

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        System.out.println("你输入的字符串为：" + str);
        char[] strarray = str.toCharArray();       //把referance 类型转换为字符数组类型，数组里面存储的数据为ASCII数字
        
        //使用new默认初始化为0
        int[] cnt = new int[5] ;
        for(int i = 0; i < strarray.length; i++){
            if(((char)strarray[i] >= '0') && ((char)strarray[i] <= '9'))
                cnt[0] ++;
            else if(((char)strarray[i] >= 'a') && ((char)strarray[i] <= 'z'))
                cnt[1] ++;
            else if(((char)strarray[i] >= 'A') && ((char)strarray[i] <= 'Z'))
                cnt[2] ++;
            else if((char)strarray[i] == ' ' )
                cnt[3] ++;
            else 
                cnt[4] ++;
        }
        System.out.println("你输入的数字字符个数为：    "    + cnt[0]);
        System.out.println("你输入的小写英文字符个数为："    + cnt[1]);
        System.out.println("你输入的大写英文字符个数为："   + cnt[2]);
        System.out.println("你输入的空格字符个数为：    "    + cnt[2]);
        System.out.println("你输入的其他字符个数为：   " + cnt[3]);

        sc.close();
    }
}