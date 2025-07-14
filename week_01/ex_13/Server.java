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

                    String line = in.readLine();
                    if (line == null) continue;
                    String[] parts = line.trim().split("\\s+");
                    int a = Integer.parseInt(parts[0]);
                    int b = Integer.parseInt(parts[1]);
                    System.out.println("Nhan truy van: " + a + " " + b);
                    for (int n = a; n <= b; n++) {
                        if (isPrime(n)) {
                            out.println(n);
                            System.out.println("Gui: " + n);
                            // Chờ 1 giây hoặc dừng nếu client gửi STOP
                            long start = System.currentTimeMillis();
                            while (System.currentTimeMillis() - start < 1000) {
                                if (in.ready()) {
                                    String cmd = in.readLine();
                                    if (cmd != null && cmd.trim().equalsIgnoreCase("STOP")) {
                                        System.out.println("Client da gui STOP.");
                                        return;
                                    }
                                }
                                Thread.sleep(100);
                            }
                        }
                    }
                    System.out.println("Hoan thanh gui so nguyen to. Doi client tiep tuc hoac ngat ket noi.");
                } catch (Exception e) {
                    System.out.println("Client da ngat ket noi hoac loi: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Khong the khoi dong server: " + e.getMessage());
        }
    }

    private static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
} 