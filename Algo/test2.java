/**
 * 判断101 - 200之间的素数
 * 素数的判断：只能被一和它本身所整除的数
 * 程序判断：遍历依次除以2到本身-1
 * 或者遍历：依次除以2到本身的开方
 */
public class test2{
    public static void main(String[] args){
        System.out.println("判断101 ~ 200 之间的素数");
        for(int i = 101; i < 200; i++){
            if(IsRightNumner(i))
                System.out.println(i + "是素数");
        }
    }
    public static boolean IsRightNumner(int number){
        for(int j = 2; j < number; j ++ ){
            if((number%j) == 0)
                return false;
        }
        return true;
    }
}