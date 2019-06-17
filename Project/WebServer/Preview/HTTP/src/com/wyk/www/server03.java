package com.wyk.www;
/*
 * δʵ��Ч��
 * */
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


/**
  * Ŀ�꣺������ӦЭ��
  * ���裺1.����SeverSocket
  *      2.�������ӻ�ȡClientSocket
  *      3.ͨ����������ȡ����Э��GET and POST
  **/

public class server03 {

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
			
			/*Ϊʲô��StringBuild�������������*/
			StringBuilder content = new StringBuilder();
			content.append("<html>");
			content.append("<head>");
			content.append("<title>");
			content.append("��������Ӧ�ɹ�...");
			content.append("</title>");
			content.append("</head>");
			content.append("<body>");
			content.append("���ڻ�����...");
			content.append("</body>");
			content.append("</html>");
			
			int size = content.toString().getBytes().length;
			
			StringBuilder responseInfo = new StringBuilder();
			String blank = " ";
			String CRLF = "\r\n";
			
			/*����*/
			/**
			 * 1. ��Ӧ״̬�У� HTTP/1.1 200 OK
			 */
			responseInfo.append("HTTP/1.1 200 OK").append(CRLF);
		
			/**
			 *  2. ��Ӧͷ(���һ���п���)
			 **/
			responseInfo.append("Date:").append(new Date()).append(CRLF);
			responseInfo.append("Server:").append("Server/0.0.1;charset=GBK").append(CRLF);
			responseInfo.append("Content-type:text/html").append(CRLF);
			responseInfo.append("Content-length").append(size).append(CRLF);
			responseInfo.append(CRLF);
			
			/**
			 *3. ���� 
			 **/
			responseInfo.append(content.toString());
			
			/**
			 * д�����ͻ���
			 * */
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			bw.write(responseInfo.toString());
			bw.flush();
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
