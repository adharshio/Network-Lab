import java.net.*;
import java.util.*;

public class UDPClient{
	public static void main(String[] args) throws Exception{
		DatagramSocket cs = new DatagramSocket();
		InetAddress ip = InetAddress.getByName("local host");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string");
		String sentence = sc.nextLine();
		byte[] sd = sentence.getBytes();
		DatagramPacket sp = new DatagramPacket(sd,sd.length,ip,5000);
		cs.send(sp);
		
		byte[] rd = new byte[1024];
		DatagramPacket rp = new DatagramPacket(rd,rd.length);
		cs.receive(rp);
		String translated = new String(rp.getData(),0,rp.getLength());
		
		System.out.println("Translated:"+translated);
		sc.close();
		cs.close();
		
	}
}
