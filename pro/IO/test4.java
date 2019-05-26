/**
 * 使用缓冲字节流来提高效率
 * 不需要定义缓冲数组
 * 默认缓冲区为8192
 */
import java.io.*;

public class test4{
    public static void main(String[] args){

        FileInputStream fsrc = null;
        BufferedInputStream ffsrc = null;

        FileOutputStream fdst = null;
        BufferedOutputStream ffdst = null;
        int temp = 0;
        try{

            fsrc = new FileInputStream("D:/a.txt");
            ffsrc = new BufferedInputStream(fsrc);

            fdst = new FileOutputStream("D:/b.txt");
            ffdst = new BufferedOutputStream(fdst);

            while((temp = ffsrc.read()) != -1){
                ffdst.write(temp);
            }

        }catch(Exception e){
            e.printStackTrace();
        } finally{
            
            try{
                if(ffdst != null){
                    ffdst.close();
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

            try{
                if(ffsrc != null){
                    ffsrc.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }

            try{
                if(fsrc != null){
                    fsrc.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        
        
        
        }
    }



}