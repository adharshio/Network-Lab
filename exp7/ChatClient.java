import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient{
	public static void main(String[] args){
	
		String serverAddress = "localhost";
		int port = 8080;
		
		try(Socket socket = new Socket(serverAddress,port);
		Scanner consoleInput = new Scanner(System.in);
		PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))){
			System.out.println("Connected to chat! Enter you username:");
			String name = consoleInput.nextLine();
			Thread listenerThread = new Thread(()->{
				try{
					String incomingMessage;
					while((incomingMessage = in.readLine()) != null){
						System.out.println(incomingMessage);
					}
				}catch (IOException e){
					System.out.println("Connection to server closed.");
				}
			});
			listenerThread.start();	
			System.out.println("You can now start typing messages(type 'exit' to quit):");
			while(true){
				String message = consoleInput.nextLine();
				if(message.equalsIgnoreCase("exit")){
					break;
				}
				out.println(name +":"+message);
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}}}
