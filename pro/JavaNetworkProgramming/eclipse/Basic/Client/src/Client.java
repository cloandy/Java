/**
 *  Java Server Setting
 */

import java.io.*;
import java.net.*;


public class Client {

	public static void main(String[] args) {
		Socket socket = null;
		BufferedReader Input = null;	//Client Input
		try {
			// Bind Server Port and IP
			socket = new Socket(InetAddress.getLocalHost(),8888);
			
			
			Input = new BufferedReader(new 
										InputStreamReader(socket.getInputStream()));
			System.out.println(Input.readLine());
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(Input != null ) {
				try {
					Input.close();
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
