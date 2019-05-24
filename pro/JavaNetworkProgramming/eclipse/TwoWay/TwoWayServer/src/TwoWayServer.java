
import java.io.*;
import java.net.*;

public class TwoWayServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket socket = null;
		BufferedWriter Output= null; 	//Server Transmit 
		BufferedReader input= null;		//Server Receive
		BufferedReader br = null;		//Get Keyboard Information
		
		try {
			ServerSocket serverSocket = new ServerSocket(8888);
			
			System.out.println("Start Listen...");
			socket = serverSocket.accept();
			System.out.println("An IP Address Online!");
			Output = new BufferedWriter(new
										OutputStreamWriter(socket.getOutputStream()));
			input = new BufferedReader(new
										InputStreamReader(socket.getInputStream()));
			br    = new BufferedReader(new
										InputStreamReader(System.in));
			//Output.write("This is a Server!");
			//System.out.println("End Init! Start Speaking...");
			
			while(true) {
				String str = input.readLine();
				System.out.println("Client Says : " + str);
				if(str.equals("end")) {
					break;
				}
				
				String str1 = br.readLine();
				Output.write(str1 + '\n');
				Output.flush();
				
				
			}
			
			
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(Output != null) {
				try {
					Output.close();
				}catch (IOException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			
			if(input != null) {
				try {
					input.close();
				}catch (IOException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			
			if(br != null) {
				try {
					br.close();
				}catch (IOException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			
			if(socket != null) {
				try {
					socket.close();
				}catch (IOException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
	}

}

/*
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
 
public class TwoWayServer {
    public static void main(String[] args){
        Socket socket = null;
        BufferedReader in = null;
        BufferedWriter out = null;
        BufferedReader br = null;
        try {
            //�������������׽��֣�ָ�������˿�
            ServerSocket server = new ServerSocket(8888);
            //�����ͻ��˵�����
            socket = server.accept();
            //��ȡsocket��������������պͷ�����Ϣ
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new 
                                   OutputStreamWriter(socket.getOutputStream()));
            br = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                //���տͻ��˷��͵���Ϣ
                String str = in.readLine();
                System.out.println("�ͻ���˵��" + str);
                String str2 = "";
                //����ͻ��˷��͵��ǡ�end������ֹ���� 
                if (str.equals("end")){
                    break;
                }
                //���򣬷��ͷ�����Ϣ
                str2 = br.readLine(); // ����\nΪֹ�����һ��Ҫ���뻻�з���
                out.write(str2 + "\n");
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //�ر���Դ
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

*/