/**
 * 数据流实现文件的读取
 */
import java.io.*;

public class test7{
    public static void main(String[] args){
        /**文件读取数据 */
        DataInputStream Dfsrc = null;
        FileInputStream fsrc = null;
        /**文件写入数据 */
        DataOutputStream Dfdst = null;
        FileOutputStream fdst = null;

        try{
            fsrc = new FileInputStream("D:/a.txt");
            Dfsrc = new DataInputStream(new BufferedInputStream(fsrc));

            fdst = new FileOutputStream("D:/a.txt");
            Dfdst = new DataOutputStream(new BufferedOutputStream(fdst));

            Dfdst.writeChar('v');
            Dfdst.writeInt(20);
            Dfdst.writeDouble(Math.random());
            Dfdst.writeBoolean(true);
            /**手动刷新缓冲区，将流中数据写入到文件中 */
            Dfdst.flush();

            System.out.println("char   : " + Dfsrc.readChar());
            System.out.println("Int    : " + Dfsrc.readInt());
            System.out.println("Double : " + Dfsrc.readDouble());
            System.out.println("Boolean: " + Dfsrc.readBoolean());

        }catch(IOException e){
            e.printStackTrace();
        } finally{
            try{

                if(Dfdst != null){
                    Dfdst.close();
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

                if(Dfsrc != null){
                    Dfsrc.close();
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