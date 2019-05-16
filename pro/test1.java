
public class test1{

    public static void  testBasicType(int m){
        System.out.println("testBasicType is m=" + m);//50
        m = 100;
        System.out.println("testBasicType is m=" + m);//100
    }
    
    public static void add(StringBuffer s) {  
  
        s.append("_add");  
  
    }  
    public static void changeRef(StringBuffer s) {  
  
        s = new StringBuffer("Java");  
  
    }  


    public static void main(String[] args){
        int m = 50;  
  
        testBasicType(m);  
  
        System.out.println("main is m = " + m);//i=50  验证Java的按值传递
  
        StringBuffer sMain = new StringBuffer("init");  
  
        System.out.println("sMain=" + sMain.toString());//sMain=init  
  
        add(sMain);  
  
        System.out.println("sMain=" + sMain.toString());//sMain=init_add  
  
        changeRef(sMain);  
  
        System.out.println("sMain=" + sMain.toString());//sMain=init_add  
    }
}