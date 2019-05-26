/**
 * 对象流读取文件信息
 */
import java.io.*;

public class test8{
    public static void main(String[] args) throws IOException,
    ClassNotFoundException{
        write();
        read();

    }

    public static void write(){
        OutputStream os = null;
        BufferedOutputStream bos = null;
        ObjectOutputStream oos = null;
        try{
            /**创建输出对象，增加缓冲功能，创建Object输出流 */
            os = new FileOutputStream(new File("D:/a.txt"));
            bos = new BufferedOutputStream(os);
            oos = new ObjectOutputStream(bos);

            oos.writeChar('a');
            oos.writeInt(10);
            oos.writeDouble(Math.random());
            oos.writeBoolean(true);
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(oos != null){
                    oos.close();
                }
            }catch(IOException e){
                    e.printStackTrace();
            }

            try{
                if(bos != null){
                    bos.close();
                }
            }catch(IOException e){
                    e.printStackTrace();
            }

            try{
                if(os != null){
                    os.close();
                }
            }catch(IOException e){
                    e.printStackTrace();
            }

        }
    }
    public static void read(){

        InputStream is = null;
        BufferedInputStream bis = null;
        ObjectInputStream ois = null;
        try{
            /**创建输出对象，增加缓冲功能，创建Object输出流 */
            is = new FileInputStream(new File("D:/a.txt"));
            bis = new BufferedInputStream(is);
            ois = new ObjectInputStream(bis);

           System.out.println(ois.readChar());
           System.out.println(ois.readInt());
           System.out.println(ois.readDouble());
           System.out.println(ois.readBoolean());
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(ois != null){
                    ois.close();
                }
            }catch(IOException e){
                    e.printStackTrace();
            }

            try{
                if(bis != null){
                    bis.close();
                }
            }catch(IOException e){
                    e.printStackTrace();
            }

            try{
                if(is != null){
                    is.close();
                }
            }catch(IOException e){
                    e.printStackTrace();
            }

        }
    }

}