package paket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		BufferedReader serverInput;
		PrintStream serverOutput;
		
		Socket socket = new Socket("localhost", 10000);
		
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		
		serverInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		serverOutput = new PrintStream(socket.getOutputStream());
		
		System.out.println("Unesite zeljenu rec: ");
		String input = console.readLine();
		
		serverOutput.println(input);
		
		String result = serverInput.readLine();
		
		System.out.println("Nasa rec: " + input + "; Rec dobijena od servera: " + result);
		
		socket.close();
		
		
	}

}
