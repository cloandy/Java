/**
 * 使用缓冲字符流来提高效率
 * 不需要定义缓冲数组
 * 默认缓冲区为8192
 */
import java.io.*;

public class test5{
    public static void main(String[] args){

        FileReader fsrc = null;
        BufferedReader ffsrc = null;

        FileWriter fdst = null;
        BufferedWriter ffdst = null;
        String string = " ";
        try{

            fsrc = new FileReader("D:/a.txt");
            ffsrc = new BufferedReader(fsrc);

            fdst = new FileWriter("D:/b.txt");
            ffdst = new BufferedWriter(fdst);

            while((string = ffsrc.readLine()) != null){
                ffdst.write(string);
                ffdst.newLine();
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