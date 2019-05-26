/**
 * 转换流
 */
import java.io.*;

public class test9{
    public static void main(String[] args){
        /**创建字符流引用 */
        BufferedReader br = null;
        BufferedWriter bw = null;
        try{
            /**创建字符流对象 */
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            /**使用字符输入和输出流 */
            String string = br.readLine();
            while(!"exit".equals(string)){
                bw.write(string);
                bw.newLine();
                bw.flush();
                string = br.readLine();
            }

        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(bw != null){
                    bw.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }

            try{
                if(br != null){
                    br.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }

    
    }
}