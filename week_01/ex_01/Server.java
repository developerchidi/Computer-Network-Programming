import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int port = 12345;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is running on port " + port);
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                     DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream())) {

                    int a = in.readInt();
                    int b = in.readInt();
                    int sum = a + b;
                    out.writeInt(sum);
                    System.out.println("Nhan 2 so: " + a + ", " + b + " | Tra ve tong: " + sum);
                } catch (IOException e) {
                    System.out.println("Client connection error: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
} 