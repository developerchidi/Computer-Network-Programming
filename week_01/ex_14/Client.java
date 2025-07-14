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

            System.out.print("Nhap van ban can ma hoa: ");
            String plain = scanner.nextLine().toUpperCase();
            out.println(plain);
            System.out.print("Nhap kich thuoc ma tran khoa (2 hoac 3): ");
            int n = scanner.nextInt();
            out.println(n);
            scanner.nextLine();
            for (int i = 0; i < n; i++) {
                System.out.print("Nhap dong " + (i+1) + " khoa (cach nhau bang dau phay): ");
                String row = scanner.nextLine();
                out.println(row);
            }
            String cipher = in.readLine();
            System.out.println("Nhan ban ma hoa tu server: " + cipher);

            System.out.print("Nhap ban ma hoa de giai ma: ");
            String cipher2 = scanner.nextLine().toUpperCase();
            out.println(cipher2);
            String plain2 = in.readLine();
            System.out.println("Nhan van ban giai ma tu server: " + plain2);
        } catch (Exception e) {
            System.out.println("Loi ket noi server: " + e.getMessage());
        }
    }
} 