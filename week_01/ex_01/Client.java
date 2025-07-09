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

            System.out.print("Nhap so nguyen thu nhat: ");
            int a = scanner.nextInt();
            System.out.print("Nhap so nguyen thu hai: ");
            int b = scanner.nextInt();

            out.writeInt(a);
            out.writeInt(b);

            int sum = in.readInt();
            System.out.println("Tong hai so la: " + sum);
        } catch (IOException e) {
            System.out.println("Loi client: " + e.getMessage());
        }
    }
} 