import java.util.Scanner;

public class PrintRhombus{

    public static void main(String[] args){
        System.out.println("--------开始打印菱形------");

        /*
            1. 先打印直角空格，输入x，第一行：x -1 第二行：x-2
            2. 使用while循环来打印*
        */ 
        System.out.print("请输入你需要打印的三角行数：\t");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        System.out.println("\n你需要打印的三角行数为：" + number);
        int cnt = 0;
        for(int i = 1; i <= number; i ++){          //外层循环控制行数
            for(int j = number - i; j > 0 ; j --){
                System.out.print("-");
            }
            while(cnt != (i * 2 - 1)){              //第一行：1； 第二行：3 第number行：(2*i - 1)
                cnt++;
                System.out.print("*");
            }
            cnt = 0;
            System.out.print("\n");
        }

        for(int i = number - 1; i > 0; i --){          //将三角倒置只需要改变其最外层循环
            for(int j = number - i; j > 0 ; j --){
                System.out.print("-");
            }
            while(cnt != (i * 2 - 1)){
                cnt++;
                System.out.print("*");
            }
            cnt = 0;
            System.out.print("\n");
        }


    }

}