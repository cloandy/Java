/**
 * 反转排序：
 * 将数组从中间截开，第一个和最后一个交换，。。。。
*/
public class ReverseSort{

    public static void main(String[] args){

        int array[] = new int[]{1,3,5,7,9,0,2,4,6,8,10};
        System.out.print("-反转排序的数组元素为-：\n");
        for(int x : array)
            System.out.print(x + "\t");

        System.out.print("\n-------反转排序开始----------：\n");

        for(int i = 0; i < array.length / 2; i ++){
            int temp = array[array.length - 1 - i ];
            array[array.length - 1 - i ] = array[i];
            array[i] = temp;
        }

        for(int x : array)
            System.out.print(x + "\t");

            System.out.print("\n-------反转选择排序结束----------!\n");


    }
}