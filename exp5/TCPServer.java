import java.net.*;
import java.io.*;

public class TCPServer{

	public static void main(String[] args) throws Exception{
		int port = 5000;
		ServerSocket ss = new ServerSocket(5000);
		System.out.println("Server Listening on : " + port);
		
		Socket socket = ss.accept();
		System.out.println("Client connected");
		DataInputStream in =  new DataInputStream(socket.getInputStream());
		DataOutputStream out =  new DataOutputStream(socket.getOutputStream());
		
		int n = in.readInt();
		int[][] mat = new int[n][n];	
			
		for(int i = 0;i<n;i++){
			for(int j = 0;j<n;j++){
				mat[i][j] = in.readInt();		
			}
			}
			
		boolean isUpper = true;
		boolean isLower = true;
		boolean isDiagonal = true;
		for(int i = 0;i<n;i++){
			for(int j = 0;j<n;j++){
				if (i > j && mat[i][j] != 0)
					isUpper = false;
				if(i < j && mat[i][j] != 0)
					isLower = false;	
				if ( i != j && mat[i][j] !=0)
					isDiagonal = false;	
			}
			}
			if(isDiagonal)
				out.writeUTF("diagonal");
			else if (isUpper) 
				out.writeUTF("Upper");
			else if (isLower)
				out.writeUTF("lower");
			else
				out.writeUTF("normal matrix");
		
		
		in.close();
		socket.close();
		ss.close();
	}
}
