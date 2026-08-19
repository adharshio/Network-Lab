import java.io.*;
import java.net.*;

public class FileClient{
	public static void main(String[] a) throws Exception{
		Socket s =  new Socket("localhost",6000);
		BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(s.getOutputStream());
		BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		System.out.print("Enter a file name:");
		out.println(kb.readLine());
		String line;
		while((line = in.readLine()) != null)
			System.out.println(line);
			s.close();
	}
}
