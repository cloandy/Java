import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadClient {
	//Main Thread : Read Information
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket socket = null;
		BufferedReader input = null;
		
		try {
			
			socket = new Socket(InetAddress.getLocalHost(), 8888);
			new ClientThread(socket).start();
			input = new BufferedReader(new
									InputStreamReader(socket.getInputStream()));
			while(true) {
				String string = input.readLine();
				System.out.println("Server Says : " + string);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(input != null)
					input.close();
				}catch (IOException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			try {
				if(socket != null)
					socket.close();
				}catch (IOException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
	}
}

class ClientThread extends Thread {
	
	Socket socket;
	BufferedWriter output;
	BufferedReader br;
	
	public ClientThread(Socket socket) {
		this.socket = socket;
		try {
			output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			br     = new BufferedReader(new InputStreamReader(System.in));
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void run() {
		
		try {
			while(true) {
				String string = br.readLine();
				output.write(string + '\n');
				output.flush();
			}
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(output != null) {
					output.close();
				}
			}catch (IOException e) {
					// TODO: handle exception
					e.printStackTrace();
			}
			try {
				if(br != null) {
					br.close();
				}
			}catch (IOException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
		}
		
	}
}
