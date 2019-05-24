/**
 * 单向通信服务器端
 */
import java.io.*;
import java.net.*;

public class BasicSocketServer{

    public static void main(String[] args){
        /*1. 创建socket套接字*/
        Socket socket = null;
        /*2. 创建写缓冲区 */
        BufferedWriter bw = null;  //服务器将信息写入到缓冲区，然后进行数据的发送，为输出流

        try{
            /*创建服务器端的socket套接字，服务器端口号为8888 */
            ServerSocket serverSocket = new ServerSocket(8888);
            /*启动客户端监听程序，查看是否有客户端连接 */
            System.out.println("Server Listen ...");
            /*监听，等待客户端请求，并表示愿意接受此请求 */
            socket = serverSocket.accept();
            /*获取socket客户端的输出流，并使用缓冲流进行包装 */
            bw = new BufferedWriter( new OutputStreamWriter( socket.getOutputStream() ) );
            /*向客户端发送反馈信息 */
            bw.write("HHH");
        } catch(IOException e){
            e.printStackTrace();
        } finally{
            /*关闭流及其socket连接 */
            if(bw != null){
                try{
                    bw.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }

            if(socket != null){
                try{
                    socket.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }

    }
}