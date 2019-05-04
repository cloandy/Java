
public class BubbleSort{
    public static void main(String[] args){

        int array[] = new int[]{1,3,5,7,9,0,2,4,6,8,10};
        System.out.print("-冒泡排序的数组元素为-：\n");
        for(int x : array)
            System.out.print(x + "\t");

        System.out.print("\n-------冒泡排序开始----------：\n");

        for(int i = 1; i < array.length; i ++){ //外层循环，每执行一次就会有一个数下沉，只需要执行(array.length -1 )次，就将数排列好了
            for(int j = 0; j < array.length - i; j ++){
                if(array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        for(int x : array)
            System.out.print(x + "\t");

            System.out.print("\n-------冒泡排序结束----------!\n");

    }

}