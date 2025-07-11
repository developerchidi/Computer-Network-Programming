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

            System.out.print("Nhap so nguyen: ");
            int n = scanner.nextInt();
            out.println(n);
            String response = in.readLine();
            System.out.println("Ket qua tu server: " + response);
        } catch (Exception e) {
            System.out.println("Loi ket noi server: " + e.getMessage());
        }
    }
}