/**
 * 双相通信服务器端
 */
import java.io.*;
import java.net.*;

public class Server{

    public static void main(String[] args){
        /*1. 创建socket套接字*/
        Socket socket = null;
        /*2. 创建读写缓冲区 */
        BufferedWriter out = null; //服务器写入，信息发送
        BufferedReader in = null;  //服务器读入，信息接收

        BufferedReader br = null;  //读取服务器写入的信息，回显

        try{
            /*创建服务器端的socket套接字，服务器端口号为8888 */
            ServerSocket serverSocket = new ServerSocket(8888);
            /*启动客户端监听程序，查看是否有客户端连接 */
            System.out.println("Server Listen ...");
            /*监听，等待客户端请求，并表示愿意接受此请求 */
            socket = serverSocket.accept();
            /*获取socket客户端的输出流，并使用缓冲流进行包装 */
            /*服务器输出数据 */
            out = new BufferedWriter( new 
                                    OutputStreamWriter( socket.getOutputStream() ) );
            /*服务器接收数据 */
            in = new BufferedReader( new 
                                    InputStreamReader( socket.getInputStream() ) );
            /* 服务器数据要发送的数据 */
            br = new BufferedReader(new 
                                    InputStreamReader(System.in));
            while(true){
                /*接收客户端数据 */
                String str = in.readLine();
                System.out.println("Server Says: " + str);
                
                if(str.equals("end")){
                    break;
                }
                /*发送数据*/
                String str2 = "";
                str2 = br.readLine();
                out.write(str2 + '\n');
                out.flush();
            }
        } catch(IOException e){
            e.printStackTrace();
        } finally{
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