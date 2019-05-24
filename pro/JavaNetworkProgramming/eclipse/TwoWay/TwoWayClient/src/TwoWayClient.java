import java.io.*;
import java.net.*;

public class TwoWayClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket socket = null;
		BufferedWriter Output= null; 	//Server Transmit 
		BufferedReader input= null;		//Server Receive
		BufferedReader br = null;		//Get Keyboard Information
		
		try {
			socket = new Socket(InetAddress.getLocalHost(),8888);
			
			System.out.println("Connecting Server Success!!");
			Output = new BufferedWriter(new
										OutputStreamWriter(socket.getOutputStream()));
			input = new BufferedReader(new
										InputStreamReader(socket.getInputStream()));
			br    = new BufferedReader(new
										InputStreamReader(System.in));
			
			
			//System.out.println("Server Says : " + input.readLine());
			//System.out.println("End Init! Start Speaking...");
			while(true) {
				String str = br.readLine();
				Output.write(str + '\n');
				Output.flush();
				
				if(str.equals("end")) {
					break;
				}
				
				System.out.println("Client Says : " + input.readLine());
				
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


//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.net.InetAddress;
//import java.net.Socket;
//import java.net.UnknownHostException;
// 
//public class TwoWayClient {
//    public static void main(String[] args) {
//        Socket socket = null;
//        BufferedReader in = null;
//        BufferedWriter out = null;
//        BufferedReader wt = null;
//        try {
//            //创建Socket对象，指定服务器端的IP与端口
//            socket = new Socket(InetAddress.getLocalHost(), 8888);
//            //获取scoket的输入输出流接收和发送信息
//            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            out = new BufferedWriter(new 
//                                   OutputStreamWriter(socket.getOutputStream()));
//            wt = new BufferedReader(new InputStreamReader(System.in));
//            while (true) {
//                //发送信息
//                String str = wt.readLine();
//                out.write(str + "\n");
//                out.flush();
//                //如果输入的信息为“end”则终止连接
//                if (str.equals("end")) {
//                    break;
//                }
//                //否则，接收并输出服务器端信息
//                System.out.println("服务器端说：" + in.readLine());
//            }
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            // 关闭资源
//            if (out != null) {
//                try {
//                    out.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (in != null) {
//                try {
//                    in.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (wt != null) {
//                try {
//                    wt.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (socket != null) {
//                try {
//                    socket.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//}
