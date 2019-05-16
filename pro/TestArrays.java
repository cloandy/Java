import java.util.*;
public class TestArrays{
    public static void main(String[] args){
        //两种初始化方式
            //一种指定行数和列数
            //一种只指定行数，不指定列数
        int[][] a = new int[2][2];
        int[][] b = new int[2][]; //可指名行，不指名列
        b[0] = new int[1];
        b[1] = new int[3];
        //二维数组的静态初始化
        int[][] c = {{1,2},{3,4}};
        //二维数组的动态初始化
        int[][] d = new int[3][];
        d[0] = new int[]{1,2};
        d[1] = new int[]{3,4};
        d[2] = new int[]{5,6};
        System.out.println(Arrays.toString(d[0]));
        System.out.println(Arrays.toString(d[1]));
        System.out.println(Arrays.toString(d[2]));

    }
}