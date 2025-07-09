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

            System.out.print("Nhap he so a: ");
            float a = scanner.nextFloat();
            System.out.print("Nhap he so b: ");
            float b = scanner.nextFloat();
            System.out.print("Nhap he so c: ");
            float c = scanner.nextFloat();

            out.writeFloat(a);
            out.writeFloat(b);
            out.writeFloat(c);

            String result = in.readUTF();
            System.out.println("Ket qua tu server: ");
            System.out.println(result);
        } catch (IOException e) {
            System.out.println("Loi client: " + e.getMessage());
        }
    }
} 