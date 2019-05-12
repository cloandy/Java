public class SelectSort{
    public static void main(String[] args){

        int array[] = new int[]{1,3,5,7,9,0,2,4,6,8,10};
        System.out.print("-直接选择排序的数组元素为-：\n");
        for(int x : array)
            System.out.print(x + "\t");

        System.out.print("\n-------直接选择排序开始----------：\n");
        //每一次的索引值为0
        //每一次得到的最大数向后放
        int index = 0;
        for(int i =  0;  i < array.length; i ++){
            index = 0;
            for(int j = 1; j < array.length - i; j ++){
                if(array[j] > array[index])
                    index = j;
            }
            
            int temp = array[array.length - 1 - i];
            array[array.length - 1 - i] = array[index];
            array[index] = temp;
        }

        for(int x : array)
            System.out.print(x + "\t");

            System.out.print("\n-------直接选择排序结束----------!\n");

    }
}