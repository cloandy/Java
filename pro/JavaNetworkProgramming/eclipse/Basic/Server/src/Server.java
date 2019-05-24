/**
 *  Java Server Setting
 */

import java.io.*;
import java.net.*;

import org.omg.CORBA.Request;


public class Server {

	public static void main(String[] args) {
		Socket socket = null;
		BufferedWriter Output = null;	//Sever Output
		try {
			// Bind Server Port
			ServerSocket serverSocket = new ServerSocket(8888);
			
			//Start Listening ...
			//Will ServerSocket`s Listen given Client socket...
			System.out.println("Start Listening...");
			socket = serverSocket.accept();
			System.out.println("IP Address Online ...");
			
			Output = new BufferedWriter(new 
										OutputStreamWriter(socket.getOutputStream()));
			Output.write("Transmit:This is Client!");
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(Output != null ) {
				try {
					Output.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
			if(socket != null ) {
				try {
					socket.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
