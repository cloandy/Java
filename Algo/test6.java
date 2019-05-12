/**
 * 题目：输入两个正整数number1和number2，求其最大公约数和最小公倍数。
 * 这里最重要的就是求最大公约数：使用碾转相除法。求法如下 :
 *(1)用大的数对小的数求余
 *(2)把小的数赋值给大的数，把求余获得的结果赋值给小的数，
 *(3)循环上一步的操作，直到求余的结果为零
 *(4)上一步被求余的数就是我们要的最大公约数，不信的话，你可以动手试试
 * 
 *1、先求最大公约数bigDivisor
 *2、就可以很方便获得最小公倍数multiple=input1*input2/bigDIvisor
 * 
 */



import java.util.Scanner;

public class test6{

    public static void main(String[] args){

        System.out.println("求其最大公约数和最小公倍数");
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入第一个数：");
        int number1 = sc.nextInt();
        System.out.print("\n");
        System.out.print("请输入第二个数：");
        int number2 = sc.nextInt();
        System.out.print("\n");

        int mutil = number1 * number2;

        if(number1 < number2){
            int temp = number1;
            number1 = number2;
            number2 = temp;
        }
        int remanider = number1 % number2;
        while(remanider != 0){
            number1 = number2;
            number2 = remanider;
            remanider = number1 % number2;
        }
        System.out.println("最大公约数为：\t" + number2);
        System.out.print("最小公倍数为：\t" + mutil / number2);
        

        sc.close();




    }

}