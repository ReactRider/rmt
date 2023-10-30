package paket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static void main(String[] args) throws IOException {
		BufferedReader clientInputStream;
		PrintStream clientOutputStream;
		
		ServerSocket socket = new ServerSocket(10000);
		
		while(true) {
			System.out.println("Cekam na konekciju");
			Socket communicationSocket = socket.accept();
			System.out.println("Konekcija je uspostavljena!");
			
			clientInputStream = new BufferedReader(new InputStreamReader(communicationSocket.getInputStream()));
			clientOutputStream = new PrintStream(communicationSocket.getOutputStream());
			
			String input = clientInputStream.readLine();
			String result = "";
			
			for(int i = input.length() - 1; i >= 0; i--) {
				result += input.charAt(i);
			}
			
			clientOutputStream.println(result);
			
		}
	
	}

}
