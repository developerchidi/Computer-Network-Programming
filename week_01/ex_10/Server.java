import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int port = 12345;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is running on port " + port);
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    String input = in.readLine();
                    int n = Integer.parseInt(input.trim());
                    String result;
                    if (isFibonacci(n)) {
                        result = n + " la so Fibonacci";
                    } else {
                        result = n + " khong phai la so Fibonacci";
                    }
                    System.out.println("Nhan: " + n + " | Tra ve: " + result);
                    out.println(result);
                } catch (Exception e) {
                    System.out.println("Loi xu ly client: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Khong the khoi dong server: " + e.getMessage());
        }
    }

    // Kiểm tra số Fibonacci bằng công thức: 5*n^2+4 hoặc 5*n^2-4 là số chính phương
    private static boolean isFibonacci(int n) {
        if (n < 0) return false;
        int x1 = 5 * n * n + 4;
        int x2 = 5 * n * n - 4;
        return isPerfectSquare(x1) || isPerfectSquare(x2);
    }

    private static boolean isPerfectSquare(int x) {
        int s = (int)Math.sqrt(x);
        return s * s == x;
    }
} 