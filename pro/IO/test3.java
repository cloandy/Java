/**
 * 使用字符流实现文件的复制操作
 */
import java.io.*;

public class test3{
    public static void main(String[] args){
        FileWriter fdst = null; //数据输出到文件
        FileReader  fsrc = null; //数据输入到程序
        char[] buffer = new char[1024];
        int temp = 0;
        try{
            /*得到源文件和目标文件的地址 */
            fsrc = new FileReader("D:/a.txt");
            fdst = new FileWriter("D:/b.txt",false);
            /**将从文件中读取到的字符存放到buffer数组中 */
            while((temp = fsrc.read(buffer)) != -1){
                /**将数组元素写入到文件中 */
                fdst.write(buffer,0,temp);
            }



        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(fsrc != null){
                    fsrc.close();
                }
            }catch(IOException e){
                    e.printStackTrace();
            }

             try{
                if(fdst != null){
                    fdst.close();
                }
            }catch(IOException e){
                    e.printStackTrace();
            }

        }
    }


}