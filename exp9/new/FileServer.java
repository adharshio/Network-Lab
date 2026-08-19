import java.io.*;
import java.net.*;

public class FileServer {
    public static void main(String[] args) {
        int port = 5000;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("File Server is running and waiting for clients...");
            
            // Infinite loop to keep accepting new clients
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected!");
                
                // Spin up a new thread for this client (Concurrency)
                new ClientHandler(clientSocket).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// A mini-program (Thread) to handle a single client's file request
class ClientHandler extends Thread {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try (
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
        ) {
            // 1. Read the requested filename from the client
            String fileName = in.readLine();
            System.out.println("Client requested file: " + fileName);

            // 2. Look for the file on the computer
            File file = new File(fileName);

            // 3. Check if file exists and is not just a folder
            if (file.exists() && !file.isDirectory()) {
                BufferedReader fileReader = new BufferedReader(new FileReader(file));
                String line;
                
                // Read the file line by line and send it to the client
                while ((line = fileReader.readLine()) != null) {
                    out.println(line);
                }
                fileReader.close();
            } else {
                // Send an appropriate message if the file doesn't exist
                out.println("Error: The requested file '" + fileName + "' does not exist on the server.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
