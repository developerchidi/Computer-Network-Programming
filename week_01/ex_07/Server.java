import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int port = 12345;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server dang chay tren cong " + port);
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    String input = in.readLine();
                    String[] parts = input.split(",");
                    int n = Integer.parseInt(parts[0].trim());
                    int base = Integer.parseInt(parts[1].trim());
                    String result;
                    if (base == 2) {
                        result = n + " trong he 2 la: " + Integer.toBinaryString(n);
                    } else if (base == 8) {
                        result = n + " trong he 8 la: " + Integer.toOctalString(n);
                    } else if (base == 16) {
                        result = n + " trong he 16 la: " + Integer.toHexString(n).toUpperCase();
                    } else {
                        result = "He dem khong hop le";
                    }
                    System.out.println("Nhan: " + n + ", he " + base + "\nTra ve: " + result);
                    out.println(result);
                } catch (Exception e) {
                    System.out.println("Loi xu ly client: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Khong the khoi dong server: " + e.getMessage());
        }
    }
} 