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

            System.out.print("Nhap so nguyen duong: ");
            int n = scanner.nextInt();
            System.out.print("Nhap he can chuyen doi (2, 8, 16): ");
            int base = scanner.nextInt();
            out.println(n + "," + base);
            String response = in.readLine();
            System.out.println("Ket qua tu server: " + response);
        } catch (Exception e) {
            System.out.println("Loi ket noi server: " + e.getMessage());
        }
    }
} 