/**
 * 单向通信客户端
 */

import java.io.*;
import java.net.*;

public class BasicSocketClient{

    public static void main(String[] args){
        /*客户端socket套接字 */
        Socket socket = null;
        /*缓冲区写入 */
        BufferedReader br = null;

        try{
            /*绑定客户端的IP地址和端口号 */
            socket = new Socket(InetAddress.getLocalHost(),8888);
            /*获取socket的输入流，并且使用缓冲流进行包装 */
            br = new BufferedReader(new 
                                    InputStreamReader(socket.getInputStream()));
            /*接收服务器发送的信息*/
            System.out.println(br.readLine());         
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            /*关闭流和socket连接 */
            if(br != null){
                try{
                    br.close();
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