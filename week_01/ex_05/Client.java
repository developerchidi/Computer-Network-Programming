import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 12345;
        try (Socket socket = new Socket(host, port);
             DataOutputStream out = new DataOutputStream(socket.getOutputStream());
             DataInputStream in = new DataInputStream(socket.getInputStream());
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Nhap bieu thuc hau to (VD: 3 4 2 * +): ");
            String expr = scanner.nextLine();
            out.writeUTF(expr);

            String result = in.readUTF();
            System.out.println("Ket qua tu server:\n" + result);
        } catch (IOException e) {
            System.out.println("Loi client: " + e.getMessage());
        }
    }
} 