import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer{
	private static int PORT = 8080;
	private static Set<PrintWriter>clientWriters = new HashSet<>();
	
	public static void main(String[] args){
		System.out.println("Chat Server is running on port"+PORT+"..");
		try(ServerSocket serverSocket = new ServerSocket(PORT)){
			while(true){
				Socket clientSocket = serverSocket.accept();
				System.out.println("A new user connected:");
				new ClientHandler(clientSocket).start();
				}
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
		private static class ClientHandler extends Thread{
			private Socket socket;
			private PrintWriter out;
			private BufferedReader in;
			
			public ClientHandler(Socket socket){
				this.socket = socket;
				}public void run(){
				try{
					in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					out = new PrintWriter(socket.getOutputStream(),true);
					synchronized(clientWriters){
						clientWriters.add(out);
					}
					String message;
					while((message = in.readLine()) != null){
						System.out.println("Log" + message);
						
						synchronized (clientWriters){
							for(PrintWriter writer : clientWriters){
								writer.println(message);
							}}}
							}
							catch(IOException e){
								System.out.println("A user disconnected unexpectedly.");
							}
							finally{
								if(out!=null){
									synchronized(clientWriters){
										clientWriters.remove(out);
									}
								}
								
								try{socket.close();}catch(IOException e){}
								}}}}


