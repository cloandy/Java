/**
 * 测试数组的三种初始化方式
 */
public class TestArray{

    public static void main(String[] args){


        int[] array1;
        array1 = new int[10]; //默认初始化为0
        for(int x : array1)
            System.out.print(x + "\t");
        System.out.print("\n");

        int array2[] = {1,2,3,4,54,};
        for(int x : array2)
            System.out.print(x + "\t");
        System.out.print("\n");
        int array3[];
        array3 = new int[10]; //默认初始化为0
        for(int x : array3)
            System.out.print(x + "\t");
        System.out.print("\n");
    }
}