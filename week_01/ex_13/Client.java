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

            System.out.print("Nhap a: ");
            int a = scanner.nextInt();
            System.out.print("Nhap b: ");
            int b = scanner.nextInt();
            out.println(a + " " + b);

            Thread inputThread = new Thread(() -> {
                while (true) {
                    String cmd = scanner.nextLine();
                    if (cmd.trim().equalsIgnoreCase("STOP")) {
                        out.println("STOP");
                        break;
                    }
                }
            });
            inputThread.setDaemon(true);
            inputThread.start();

            String line;
            while ((line = in.readLine()) != null) {
                System.out.println("Nhan so nguyen to: " + line);
            }
        } catch (Exception e) {
            System.out.println("Loi ket noi server: " + e.getMessage());
        }
    }
} 