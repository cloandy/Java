/**
 * 字节数组流
 */

 import java.io.*;

 public class test6{
     public static void main(String[] args){
        /**将字符串转变为字节数组 */
        byte[] b = "wyk".getBytes();
        test(b);
     }

     public static void test(byte[] b){
         ByteArrayInputStream bais = null;
         StringBuilder sb = new StringBuilder();
         int temp = 0;
         int num = 0;
         try{
              /** ByteArrayInputStream是把内存中的”某个字节数组对象”当做数据源。 */
             bais = new ByteArrayInputStream(b);
             while((temp = bais.read()) != -1){
                 sb.append((char)temp);
                 num ++;
             }
             System.out.println(sb);
             System.out.println("读取的字节数： " + num);
         }finally{
             try{
                 if(bais != null){
                     bais.close();
                 }
             }catch(IOException e){
                 e.printStackTrace();
             }
         }
     }
 }

