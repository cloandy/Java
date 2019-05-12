import java.util.Scanner;

/**
 * 题目：打印出所有的"水仙花数"，所谓"水仙花数"是指一个三位数，其各位数字立方和等于该数本身
 */
public class test3{

    public static void main(String[] args){
        System.out.print("请输入打印的水仙花数的范围(最大范围在1000以内，不包括1000):\t");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        System.out.print("打印的水仙花数的范围为：100 ~" + number + "\n");

        for(int i = 100; i <= number; i ++){
            int a = i%10;           
            int b = (i/10)%10;
            int c = i /100;
            int sum = a*a*a + b*b*b + c*c*c;
            if(sum == i)
                System.out.print(i + "\n");
        }
        sc.close();
    }
}

//3位数的水仙花数为4个