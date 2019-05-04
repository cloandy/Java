
public class Print_args{
    public static void main(String[] args){
        for(int i= 0; i < args.length ; i ++)
            System.out.println("参数args["+ i + "]的值为：" + args[i]);

    }

}
/** 
 *cd "c:\Users\asdw1\Desktop\JAVA\pro\" ; if ($?) { javac -encoding UTF-8 Print_args.java } ; if ($?) { java Print_args 1 23 4 5 6 }
 * 参数args[0]的值为：1
 * 参数args[1]的值为：2
 * 参数args[2]的值为：3
 * 参数args[3]的值为：4
 * 参数args[4]的值为：5
 * 参数args[4]的值为：6
 * 
*/