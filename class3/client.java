import java.io.*;
import java.net.*;
import java.util.Random;
import java.uti.Scanner;

public class TCPClient{
	public static void main(String[] args){
		int port = 5000;
		String serverAddress = "127.0.0.1";
		try(Socket socket = new Socket(serverAddress){\
			BufferReader in = new BufferReader(
				new  InputStreamReader(socket.getInput
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
		}
	}
}
