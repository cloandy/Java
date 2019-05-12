/**
 * 例子：定义一个“点”(Point)类用来表示二维空间中的点(有两个坐标)。要求如下： 
 * 可以生成具有特定坐标的点对象。 
 * 提供可以设置坐标的方法。 
 * 提供可以计算该“点”距另外一点距离的方法。 
 */

 public class point{

    int Point_x;
    int Point_y;
    point(int x,int y){
        Point_x = x;
        Point_y = y;
        System.out.println("x = " + Point_x + " y = " + Point_y);
    }

    public boolean SetPoint(int x, int y){
        Point_x = x;
        Point_y = y;
        System.out.println("x = " + Point_x + " y = " + Point_y);
        return true;
    }

    public double Distance(int Start_x, int Start_y, int End_x, int End_y){

        int Distance_x = End_x - Start_x;
        int Distance_y = End_y - Start_y;

        return Math.sqrt(Distance_x * Distance_x + Distance_y * Distance_x);
    }

    public static void main(String[] args){

        point pt = new point(10,10);
        pt.SetPoint(100, 200);
        System.out.println("(100,200)点距离(0,0)点的距离为" + pt.Distance(0, 0, 100, 200));
    }
 }