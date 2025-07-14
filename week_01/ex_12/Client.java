import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 12345;
        try (Socket socket = new Socket(host, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Nhap so bi mat x: ");
            int x = scanner.nextInt();
            out.println(x);

            for (int i = 1; i <= 2; i++) {
                String expr = in.readLine();
                System.out.println("Nhan duoc phep toan: " + expr + " = ?");
                // Giải ngược: nhập lại x (giả sử client biết x)
                System.out.print("Nhap ket qua nghich dao (gia tri x): ");
                int xAns = scanner.nextInt();
                out.println(xAns);
                String check = in.readLine();
                System.out.println("Server: " + check);
                if (check.equals("Sai!")) return;
            }
            // Nhận challenge
            String challenge = in.readLine();
            System.out.println(challenge);
        } catch (Exception e) {
            System.out.println("Loi ket noi server: " + e.getMessage());
        }
    }
} 