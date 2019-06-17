package com.wyk.www;
/*
 * 未实现效果
 * */
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


/**
  * 目标：返回响应协议
  * 步骤：1.创建SeverSocket
  *      2.建立连接获取ClientSocket
  *      3.通过输入流获取请求协议GET and POST
  **/

public class server03 {

	private ServerSocket serverSocket;
	public static void main(String[] args) {
		server01 server = new server01();
		server.start();
		
	}
	/*启动服务*/
	public void start() {
		try {
			serverSocket = new ServerSocket(8888);
			received();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("服务器启动失败...");
		}
		
		
	}
	/*接收数据*/
	public void received() {
		try {
			Socket socket = serverSocket.accept();
			System.out.println("一个客户端建立连接...");
			//获取请求协议
			InputStream inputStream = socket.getInputStream();
			byte[] datasBytes = new byte[1024*1024];
			int len = inputStream.read(datasBytes);
			String requestInfo = new String(datasBytes,0,len);
			System.out.println(requestInfo);
			
			/*为什么用StringBuild：便于添加内容*/
			StringBuilder content = new StringBuilder();
			content.append("<html>");
			content.append("<head>");
			content.append("<title>");
			content.append("服务器响应成功...");
			content.append("</title>");
			content.append("</head>");
			content.append("<body>");
			content.append("终于回来了...");
			content.append("</body>");
			content.append("</html>");
			
			int size = content.toString().getBytes().length;
			
			StringBuilder responseInfo = new StringBuilder();
			String blank = " ";
			String CRLF = "\r\n";
			
			/*返回*/
			/**
			 * 1. 响应状态行： HTTP/1.1 200 OK
			 */
			responseInfo.append("HTTP/1.1 200 OK").append(CRLF);
		
			/**
			 *  2. 响应头(最后一行有空行)
			 **/
			responseInfo.append("Date:").append(new Date()).append(CRLF);
			responseInfo.append("Server:").append("Server/0.0.1;charset=GBK").append(CRLF);
			responseInfo.append("Content-type:text/html").append(CRLF);
			responseInfo.append("Content-length").append(size).append(CRLF);
			responseInfo.append(CRLF);
			
			/**
			 *3. 正文 
			 **/
			responseInfo.append(content.toString());
			
			/**
			 * 写出到客户端
			 * */
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			bw.write(responseInfo.toString());
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("客户端错误...");
		}
	}
	/*结束服务*/
	public void end() {
		
	}

}
