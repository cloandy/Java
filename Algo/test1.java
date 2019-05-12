
 /**
  * 古典问题：
  * 有一对兔子，从出生后第3个月起每个月都生一对兔子，
  *小兔子长到第三个月后每个月又生一对兔子，
  *假如兔子都不死，问每个月的兔子对数为多少？
  */

 import java.util.Scanner;
 public class test1{
     public static void main(String[] args){

        System.out.print("请输入你想知道的兔子数目的月份：\n");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        System.out.print("\n");
        System.out.print("第" + number +"月份的兔子数目为" + func(number) + "\n");
     }

     public static int func(int number){
        if((number == 1) || (number == 2))
            return 1;
        else
            return func(number -1 ) + func(number - 2); 
     }
 }

 //静态方法只能引用静态方法
 //递归运算的关键在于要找出递归的结束条件
 //一般的数列问题：a[n] = a[n -1] + a[n -2]等这样的问题，需要使用递归运算
 //其实这是一个斐波拉契数列，有三种实现方法：循环赋值，数组，递归

 