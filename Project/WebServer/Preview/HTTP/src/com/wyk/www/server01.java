package com.wyk.www;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
  * Ŀ�꣺ʹ��ServerSocket����������������ӣ���ȡ����Э��
  * ���裺1.����SeverSocket
  *      2.�������ӻ�ȡClientSocket
  *      3.ͨ����������ȡ����Э��GET and POST
  **/

public class server01 {

	private ServerSocket serverSocket;
	public static void main(String[] args) {
		server01 server = new server01();
		server.start();
		
	}
	/*��������*/
	public void start() {
		try {
			serverSocket = new ServerSocket(8888);
			received();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("����������ʧ��...");
		}
		
		
	}
	/*��������*/
	public void received() {
		try {
			Socket socket = serverSocket.accept();
			System.out.println("һ���ͻ��˽�������...");
			//��ȡ����Э��
			InputStream inputStream = socket.getInputStream();
			byte[] datasBytes = new byte[1024*1024];
			int len = inputStream.read(datasBytes);
			String requestInfo = new String(datasBytes,0,len);
			System.out.println(requestInfo);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�ͻ��˴���...");
		}
	}
	/*��������*/
	public void end() {
		
	}

}
