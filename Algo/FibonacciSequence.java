import java.util.Scanner;

public class FibonacciSequence{

    public static void main(String[] args){
    /** 
     * F(0) = 0;
     * F(1) = 1;
     * F(2) = F(0) + F(1) = 0 + 1 = 1
     * F(N) = F(N-1) + F(N -2)
    */
    System.out.print("请输入你需要打印的Fibonacci Sequence的个数：\t");
    Scanner sc = new Scanner(System.in);
    int number = sc.nextInt(); 
    System.out.println("你需要打印的Fibonacci Sequence的个数为：\t" + number);

    long n1 = 0l;
    long n2 = 1l;
    long n3 = 1l;
    
    if(number >= 0)
        System.out.print(n1 + "\t");
    if(number >= 1)
        System.out.print(n2 + "\t");
    if(number >= 2) 
        for(int i = 2; i <= number; i ++){
            n3 = n2 + n1;
            System.out.print(n3 + "\t");
            n1 = n2;
            n2 = n3;
        }
    System.out.print("\n");
   
    }
}