import java.net.*;
import java.io.*;

public class TCPServer{

	public static void main(String[] args){
		int port = 5000;
		try(ServerSocket ss = new ServerSocket(port)){
			System.out.println("Server Listening on : " + port);
			while (true){
				Socket socket = ss.accept();
				System.out.println("Client connected");
				BufferedReader in = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
				PrintWriter out = new PrintWriter(
					socket.getOutputStream(),true);
						
					
				int n = Integer.parseInt(in.readline());
				int[][] matrix = new int[n][n];
				for(int i = 0;i < n ;i++){
					String[] row = in.readline().trim().split("\\s+");
					for(int j = 0;j < n; j++){
						matrix[i][j] = Integer.parseInt(row[j]);
					}
				}
				String.result = classifymatrix(matrix,n);
				out.println(result);
				socket.close();
				System.out.println("connection closed");
				}
				}//try end bracket
				catch (IOException e){
					e.printStackTrace();
				}
				
		}
		private static String classifyMatrix(int[][] mat,int n){
			boolean isUpper = true;
			boolean isLower = true;
			for(int i = 0;i<n;i++){
				for(int j = 0;j<n;j++){
					if (i > j && mat[i][j] != 0)
						isUpper = false;
					if(i < j && mat[i][j] != 0)
						isLower = false;
						
						
						
				}
			}
			if(isUpper && isLower) return "Diagonal Matrix";
			else if (isUpper) return "Upper Triangluar matrix";
			else if (isLower) return "Lower Triangular matrix";
			else return "Not upper or lower or diagonal matrix";
			
		}
		
		
	}
