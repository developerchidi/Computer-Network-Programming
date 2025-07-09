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

                    String input = in.readUTF();
                    String[] parts = input.split(",");
                    double sum = 0;
                    for (String part : parts) {
                        sum += Double.parseDouble(part.trim());
                    }
                    out.writeUTF("Tong day so la: " + sum);
                    System.out.println("Nhan: " + input + "\nTra ve: Tong day so la: " + sum);
                } catch (IOException | NumberFormatException e) {
                    System.out.println("Loi ket noi client: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
} 