/**
 * 使用文件流读取文件内容
 * 此程序属于目标设备
 * 文件内容为目标设备的输入流
 */
import java.io.*;

public class test{
    public static void main(String[] args){

        FileInputStream fp = null;

        try{
            fp = new FileInputStream("D:/a.txt");
            /*可变的字符串序列 */
            StringBuilder sb = new StringBuilder();
            int temp = 0;

            while((temp = fp.read()) != -1){
                sb.append((char)temp);
            }
            System.out.println(sb);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(fp != null){
                    fp.close();
                }
             } catch(IOException e){
                    e.printStackTrace();
                }
        }
    }
}