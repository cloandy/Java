/**
 * 将一个数分解质因数
 * 90 = 2*3*3*5
 * 遍历找见能被整除的数字，得到的商在进行遍历操作
 */

 import java.util.Scanner;

 public class test4{
     public static void main(String[] args){
        System.out.print("请输入你想要寻找质因数的Number：\t");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int numberBackup = number;
        
        for(int i = 2; i <= numberBackup; i++){

            while(((numberBackup%i) == 0)&&(i != number)){
                numberBackup = numberBackup / i;
                System.out.println(i);
            }
        }

        if(number == numberBackup){
            System.out.println("您输入的数已经是一个质数，无法再次进行分解！");
        }
        sc.close();
     }
 }