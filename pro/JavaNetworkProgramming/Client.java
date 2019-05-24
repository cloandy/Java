/**
 * 双相通信客户端
 */

import java.io.*;
import java.net.*;

public class Client{

    public static void main(String[] args){
        /*客户端socket套接字 */
        Socket socket = null;
        /*缓冲区写入 */
        BufferedWriter out = null; //客户端输出数据
        BufferedReader in = null; //客户端输入数据
        BufferedReader br = null; //客户端输出数据回显
        try{
            /*绑定客户端的IP地址和端口号 */
            socket = new Socket(InetAddress.getLocalHost(),8888);
            /*获取socket的输入流，并且使用缓冲流进行包装 */
            /*客户端输出数据 */
            out = new BufferedWriter(new 
                                    OutputStreamWriter(socket.getOutputStream()));
            /*客户端输入数据 */
            in = new BufferedReader(new 
                                    InputStreamReader(socket.getInputStream()));
            br = new BufferedReader(new 
                                    InputStreamReader(System.in));
            /*接收服务器发送的信息*/
            while(true){
                String str = br.readLine();
                out.write(str + '\n');
                out.flush();
                if(str.equals("end")){
                    break;
                }
                System.out.println("Server Says: " + in.readLine());
            }         
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            /*关闭流及其socket连接 */
            if(in != null){
                try{
                    in.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            if(out != null){
                try{
                    out.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
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