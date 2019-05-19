public class Bubble{

    public static void main(String[] args){

        int[] a = {1,3,5,7,9,2,4,6,8,0};
        System.out.println("********冒牌排序开始**********");
        System.out.println("排序前元素：");
        for(int x:a)
            System.out.print(x);
        OptimizeBubbleSort(a);
        System.out.println("\n排序后元素:");
        for(int x:a)
            System.out.print(x);
        System.out.println("\n********冒牌排序结束**********");

    }

    private static void BubbleSort(int[] a){
        // 外层循环：n个元素排序，则至多需要n-1趟循环
        for(int i = 1; i < a.length; i ++){
            for(int j = 0; j < a.length - i; j ++){
                if(a[j] > a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }

    private static void OptimizeBubbleSort(int[] a){
        // 外层循环：n个元素排序，则至多需要n-1趟循环
        for(int i = 1; i < a.length; i ++){
            boolean flag = true;
            for(int j = 0; j < a.length - i; j ++){
                if(a[j] > a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag = false;
                }
            }
            if(flag)
                break;

        }
    }
    //增加标志位的作用是减少外层循环数

}