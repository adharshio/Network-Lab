import java.io.*;
import java.net.*;
import java.util.Random;
import java.util.Scanner;

public class TCPClient{
	public static void main(String[] args) throws Exception{
		Socket s = new Socket("localhost",5000);
		DataInputStream dis =  new DataInputStream(s.getInputStream());
		DataOutputStream dos =  new DataOutputStream(s.getOutputStream());
		Scanner c = new Scanner(System.in);
		System.out.println("Enter the order of Matrix:");
		int n = c.nextInt();
		dos.writeInt(n);
		System.out.println("Enter the matrix:");
		int[][] matrix = new int[n][n];
		for(int i =0;i < n ;i++){
			for(int j = 0;j < n;j++){
				
				matrix[i][j] = c.nextInt() ;
			}
		}
		for(int i =0;i < n ;i++){
			for(int j = 0;j < n;j++){
				
				dos.writeInt(matrix[i][j]) ;
			}
		}
		String result = dis.readUTF();
		System.out.println(result);
		dis.close();
		dos.close();
	}
}
