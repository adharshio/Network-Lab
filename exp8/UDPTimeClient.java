import java.net.*;
 public class UDPTimeClient{
 	public static void main(String a[]) throws Exception{
 	DatagramSocket ds = new DatagramSocket();
 	InetAddress ip = InetAddress.getByName("localhost");
 	byte[] out = "TIME_REQUEST".getBytes();
 	ds.send(new DatagramPacket(out,out.length,ip,9876));
 	byte[] buf = new byte[1024];
 	DatagramPacket resp = new DatagramPacket(buf,buf.length);
 	ds.receive(resp);
 	String time = new String (resp.getData(),0,resp.getLength());
 	System.out.println("Server Time:"+time);
 	ds.close();
 	}
 }
