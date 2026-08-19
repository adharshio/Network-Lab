import java.io.*;
import java.net.*;
import java.util.Scanner;

public class FileClient {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int port = 5000;

        try (
            Socket socket = new Socket(serverAddress, port);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in)
        ) {
            // 1. Ask user for the filename
            System.out.print("Enter the name of the file you want to download: ");
            String fileName = scanner.nextLine();

            // 2. Send the filename to the server
            out.println(fileName);

            System.out.println("\n--- Server Response ---");
            
            // 3. Read everything the server sends back and print it
            String response;
            while ((response = in.readLine()) != null) {
                System.out.println(response);
            }
            
            System.out.println("-----------------------");
            
        } catch (Exception e) {
            System.out.println("Error connecting to the server.");
            e.printStackTrace();
        }
    }
}