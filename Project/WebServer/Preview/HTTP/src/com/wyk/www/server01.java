package com.wyk.www;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
  * 目标：使用ServerSocket建立与浏览器的连接，获取请求协议
  * 步骤：1.创建SeverSocket
  *      2.建立连接获取ClientSocket
  *      3.通过输入流获取请求协议GET and POST
  **/

public class server01 {

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
