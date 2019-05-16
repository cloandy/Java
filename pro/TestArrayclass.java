import java.util.Arrays;
/**
 * Test java.util.Arrays class
 */
public class TestArrayclass{
    public static void main(String[] args){

        int[] a = {1,3,5,7,9,2,4,6,8,0};
        System.out.println(a);
        System.out.println(a.toString());
        System.out.println(Arrays.toString(a));
        //此时的Array.toString()方法是Arrays的静态方法
        //输出a,相当于调用a.toString()方法，属于Object类的方法
        //不是说静态方法不能必须调用静态方法吗?这里好像不符合？？

        Arrays.sort(a);//排序算法
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.binarySearch(a, 3)); //二分查找，先排序
        Arrays.fill(a, 2,4,100); //数组填充
        System.out.println(Arrays.toString(a));
    }
}