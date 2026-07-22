import java.io.*;
import java.net.*;
import java.util.Scanner;

public class client{
	public static void main(String[] args){
		throws Exception{
			Socket s = new Socket ("localhost",5000);
			
		}
	}
}

int port = 5000;
		String serverAddress = "localhost";
		try(Socket socket = new Socket(serverAddress){
			BufferReader in = new BufferReader();
				new InputStreamReader(socket.getInput
			Printwriter out = new PrintWriter(
				socket.getOutputStream(),true);
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("Enter the order of matrix:");
			int n = scanner.nextInt();
			out.println(n);
			
			int[][] matrix  = new int[n][n];
			Random rand = new Random();
			
			System.out.println("\nGenerated Matrix:");
			for(int i =0;i < n ;i++){
			StringBuilder row = new StringBuilder();
				for(int j = 0;j < n;j++){
					matrix[i][j] = rand.nextInt(50) + 1;
					row.append(matrix[i][j]).append(" ");
					}
				System.out.println(row.toString().trim(
				System.out.println(row.toString().trim());//error here
			
			}
			String response = in.readLine();
			System.out.println("\[Server Response]:" + response);
			
		}
		catch(IOException e){
			e.printStackTrace();
			
			
			
			
			
			
			try(ServerSocket ss = new ServerSocket(port)){
			System.out.println("Server Listening on : " + port);
			while (true){
				Socket socket = ss.accept();
				System.out.println("Client connected");
				BufferReader in = new BufferReader(
					new InputStreamReader(socket.getInputStream()));
					PrintWriter out = new PrintWriter(
						socket.getOutputstream(),true);
						
					
				int n = Integer.parseInt(in.readline());
				int[][] matrix = new int[n][n];
				for(int i = 0;i < n ;i++){
					String[] row = int.readline().trim().split("\\s+");
					for(int j = 0;j < n; j++){
						matrix[i][j] = Integer.parseInt(row[j]);
					}
				}
				String.result = classifymatrix(matrix,n);
				out.println(result);
				socket.close();
				System.out.println("connection closed");
				}
				catch (IOException e){
					e.printStackTrace();
				}
				
		}
