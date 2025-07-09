import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int port = 12345;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is running on port " + port);
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                     DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream())) {

                    float a = in.readFloat();
                    float b = in.readFloat();
                    float c = in.readFloat();
                    String result = solveQuadratic(a, b, c);
                    out.writeUTF(result);
                    System.out.println("Nhan:\n\ta = " + a + "\n\tb = " + b + "\n\tc = " + c + "\nTra ve:\n" + result);
                } catch (IOException e) {
                    System.out.println("Loi ket noi client: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }

    private static String solveQuadratic(float a, float b, float c) {
        if (a == 0) {
            if (b == 0) {
                return (c == 0) ? "Vo so nghiem" : "Vo nghiem";
            } else {
                float x = -c / b;
                return "Nghiem duy nhat:\n x = " + x;
            }
        }
        float delta = b * b - 4 * a * c;
        if (delta > 0) {
            float x1 = (float)((-b + Math.sqrt(delta)) / (2 * a));
            float x2 = (float)((-b - Math.sqrt(delta)) / (2 * a));
            return "2 nghiem thuc:\n\tx1 = " + x1 + "\n\tx2 = " + x2;
        } else if (delta == 0) {
            float x = -b / (2 * a);
            return "Nghiem kep:\n\tx = " + x;
        } else {
            float real = -b / (2 * a);
            float imag = (float)(Math.sqrt(-delta) / (2 * a));
            return "2 nghiem phuc:\n\tx1 = " + real + " + " + imag + "i\n\tx2 = " + real + " - " + imag + "i";
        }
    }
} 