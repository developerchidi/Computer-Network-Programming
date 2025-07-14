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

            System.out.print("Nhap kich thuoc ma tran n: ");
            int n = scanner.nextInt();
            scanner.nextLine();
            double[][] matrix = new double[n][n];
            for (int i = 0; i < n; i++) {
                System.out.print("Nhap dong " + (i+1) + " (cach nhau bang dau phay): ");
                String[] parts = scanner.nextLine().split(",");
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Double.parseDouble(parts[j].trim());
                }
            }
            String json = matrixToJson(matrix);
            out.println(json);
            String response = in.readLine();
            System.out.println("Dinh thuc ma tran la: " + response);
        } catch (Exception e) {
            System.out.println("Loi ket noi server: " + e.getMessage());
        }
    }

    // Chuyển ma trận sang JSON dạng [[1,2],[3,4]]
    private static String matrixToJson(double[][] matrix) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < matrix.length; i++) {
            sb.append("[");
            for (int j = 0; j < matrix.length; j++) {
                sb.append(matrix[i][j]);
                if (j < matrix.length - 1) sb.append(",");
            }
            sb.append("]");
            if (i < matrix.length - 1) sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }
} 