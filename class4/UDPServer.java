import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.InetAddress;
import java.util.HashMap;
import java.util.Map;

public class UDPServer{
	int port = 8080;
	public static void main(String[] args) throws Exception{
	 	DatagramSocket serverSocket = new DatagramSocket(5000);
	 	byte[] receiveData = new byte[1024];
	 	DatagramPacket receivePacket = new DatagramPacket(recieveData,recieveData.length);
	 	System.out.println("Server waiting:");
	 	serverSocket.receive(receivePacket);
	 	
	 	String sentence = new String(receivePacket.getData(),0,receivePacket.getLength());
	 	
	 	sentence = sentence.replace("tbh","to be honest");
	 	sentence = sentence.replace("idc","i don't care");
	 	
	 	byte[] sendData = sentence.getBytes();
	 	DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,receivePacket.getAddress(),receivePacket.getPort());
	 	serverSocket.send(sendPacket);
	 	serverSocket.close();
	 	
	 
	 }}
}


