import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 12345;
        try (Socket socket = new Socket(host, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Nhap danh sach so thuc (cach nhau bang dau phay): ");
            String input = scanner.nextLine();
            out.println(input);
            String response = in.readLine();
            // Tách và in từng phần theo dấu |
            if (response != null) {
                System.out.println("Ket qua tu server: ");
                String[] parts = response.split("\\|");
                for (String part : parts) {
                    System.out.println(part.trim());
                }
            }
        } catch (Exception e) {
            System.out.println("Loi ket noi server: " + e.getMessage());
        }
    }
} 