import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    static Random rand = new Random();
    public static void main(String[] args) {
        int port = 12345;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is running on port " + port);
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    // Bước 1: Nhận x bí mật
                    String xStr = in.readLine();
                    int x = Integer.parseInt(xStr.trim());
                    System.out.println("Nhan x = " + x);

                    // Bước 2: Gửi phép toán 1
                    String[] eq1 = genEquation(x);
                    out.println(eq1[0]); // gửi biểu thức
                    String ans1 = in.readLine();
                    System.out.print("Nhan x client tra loi: " + ans1 + " | ");
                    if (!ans1.equals(xStr)) {
                        out.println("Sai!");
                        System.out.println("Sai!");
                        continue;
                    } else {
                        out.println("Dung!");
                        System.out.println("Dung!");
                    }

                    // Bước 3: Gửi phép toán 2
                    String[] eq2 = genEquation(x);
                    out.println(eq2[0]);
                    String ans2 = in.readLine();
                    System.out.print("Nhan x client tra loi: " + ans2 + " | ");
                    if (!ans2.equals(xStr)) {
                        out.println("Sai!");
                        System.out.println("Sai!");
                        continue;
                    } else {
                        out.println("Dung!");
                        System.out.println("Dung!");
                    }

                    // Thành công
                    out.println("Ban da duoc xac thuc thanh cong! Challenge: Congratulation!");
                    System.out.println("Xac thuc thanh cong, gui challenge!");
                } catch (Exception e) {
                    System.out.println("Loi xu ly client: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Khong the khoi dong server: " + e.getMessage());
        }
    }

    // Sinh phép toán ngẫu nhiên (ax+b hoặc ax^2+bx+c), trả về [biểu thức, giá trị]
    private static String[] genEquation(int x) {
        int type = rand.nextInt(2);
        if (type == 0) {
            // ax + b
            int a = rand.nextInt(5) + 1;
            int b = rand.nextInt(10) - 5;
            int y = a * x + b;
            String expr = a + "x" + (b >= 0 ? "+" : "") + b;
            return new String[]{expr, String.valueOf(y)};
        } else {
            // ax^2 + bx + c
            int a = rand.nextInt(3) + 1;
            int b = rand.nextInt(7) - 3;
            int c = rand.nextInt(11) - 5;
            int y = a * x * x + b * x + c;
            String expr = a + "x^2" + (b >= 0 ? "+" : "") + b + "x" + (c >= 0 ? "+" : "") + c;
            return new String[]{expr, String.valueOf(y)};
        }
    }
} 