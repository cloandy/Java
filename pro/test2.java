import java.util.Arrays;

public class test2{

    public static void main(String[] args){
        Object[] a1 = {100,"w",20,"讲师","2016-01-01"};
        Object[] a2 = {102,"y",21,"副教授","2016-01-02"};
        Object[] a3 = {103,"k",22,"教授","2016-01-03"};

        Object[][] emper = new Object[3][];
        emper[0] = a1;
        emper[1] = a2;
        emper[2] = a3;

        System.out.println(Arrays.toString(emper[0]));
        System.out.println(Arrays.toString(emper[1]));
        System.out.println(Arrays.toString(emper[2]));
    }
}