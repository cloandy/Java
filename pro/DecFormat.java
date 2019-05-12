import java.text.DecimalFormat;

public class DecFormat{

    static public void SimpleFormat(String pattern, double value){
        DecimalFormat myFormat = new DecimalFormat(pattern);
        String output = myFormat.format(value);
        System.out.print(value + " " + pattern + " " + output + "\n");
    }
    static public void UseApplySimpleFormat(String pattern, double value){
        DecimalFormat myFormat = new DecimalFormat(pattern);
        myFormat.applyPattern(pattern);

        System.out.print(value + " " + pattern + " " + myFormat.format(value) + "\n");
    }

    public static void main(String[] args){
        SimpleFormat("###,###.###",123456.789);
        SimpleFormat("000000000.###Kg",123456.789);
        UseApplySimpleFormat("#.###%",0.789);
        UseApplySimpleFormat("###.##",123456.789);
        UseApplySimpleFormat("0.00\u2030",0.789);
    }
}