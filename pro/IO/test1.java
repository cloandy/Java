/**
 * 使用本程序写入数据到文件
 * 此程序属于源设备
 * 文件内容为源设备的输出流
 */
import java.io.*;

public class test1{
    public static void main(String[] args){

        FileOutputStream fp = null;
        String string = "Java 欢迎您！";

        try{
            /*这是文件追加方式 */
            /*怎么修改文件写入方式 */
            /*true表示文件追加方式，false 表示文件重写 */
            fp = new FileOutputStream("D:/a.txt",true);
            fp.write(string.getBytes());
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