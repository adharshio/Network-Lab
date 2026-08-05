import java.net.*;
import java.util.Date;

public class UDPTimeServer {
	public static void main(String[] a) throws Exception{
		DatagramSocket ds = new DatagramSocket(9876);
		System.out.println("UDP Time Server Started...");
		byte[] buf = new byte[1024];
		while(true){
			DatagramPacket req = new DatagramPacket(buf,buf.length);
			ds.receive(req);
			String time = new Date().toString();
			byte[] out = time.getBytes();
			DatagramPacket resp = new DatagramPacket(out,out.length,req.getAddress(),req.getPort());
			ds.send(resp);
			System.out.println("Sent time to " + req.getAddress());
		}  
	}
}
