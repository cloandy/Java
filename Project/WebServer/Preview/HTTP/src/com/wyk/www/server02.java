package com.wyk.www;
/*
 * ��Ӧ����ʹ��Rester����
 * */

import java.io.*;
import java.net.*;

public class server02 {
	
	private ServerSocket serverSocket;
	
	public static void main(String[] args) {
		server02 server = new server02();
		server.Start();
	}
	
	public void Start() {
		try {
			serverSocket = new ServerSocket(8888);
			System.out.println("�����������ɹ�...");
			this.Deal();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("����������ʧ��...");
		}
	}
	
	public void Deal() {
		Socket socket;
		try {
			socket = serverSocket.accept();
			System.out.println("һ���ͻ����Ѿ�����");
			
			//��ȡ����Э��
			InputStream inputStream = socket.getInputStream();
			byte[] databytes = new byte[1024*1024];
			int len = inputStream.read(databytes);
			String requestInfo = new String(databytes,0,len);
			System.out.println(requestInfo);
			
			PrintWriter pw=new PrintWriter(socket.getOutputStream());
			  
			pw.println("HTTP/1.1 200 OK");
			pw.println("Content-type:text/html");
			pw.println();
			pw.println("<html><h1>Hdsadsa</h1></html>");
			  
			pw.flush();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
