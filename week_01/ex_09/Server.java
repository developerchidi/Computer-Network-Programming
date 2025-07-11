import java.io.*;
import java.net.*;
import java.util.*;

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
                    System.out.println("Nhan: " + input);
                    String[] parts = input.split(",");
                    List<Double> numbers = new ArrayList<>();
                    for (String s : parts) {
                        numbers.add(Double.parseDouble(s.trim()));
                    }
                    double sum = 0, max = numbers.get(0), min = numbers.get(0);
                    for (double d : numbers) {
                        sum += d;
                        if (d > max) max = d;
                        if (d < min) min = d;
                    }
                    double avg = sum / numbers.size();
                    String result = String.format("Trung binh: %.2f|Lon nhat: %.1f|Nho nhat: %.1f", avg, max, min);
                    System.out.println("Tra ve: " + result);
                    out.println(result);
                } catch (Exception e) {
                    System.out.println("Loi xu ly client: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Khong the khoi dong server: " + e.getMessage());
        }
    }
} 