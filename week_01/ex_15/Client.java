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

            System.out.print("Nhap so an n: ");
            int n = scanner.nextInt();
            scanner.nextLine();
            double[][] A = new double[n][n];
            for (int i = 0; i < n; i++) {
                System.out.print("Nhap dong " + (i+1) + " ma tran A (cach nhau bang dau phay): ");
                String[] parts = scanner.nextLine().split(",");
                for (int j = 0; j < n; j++) A[i][j] = Double.parseDouble(parts[j].trim());
            }
            System.out.print("Nhap vector B (cach nhau bang dau phay): ");
            String[] bparts = scanner.nextLine().split(",");
            double[] B = new double[n];
            for (int i = 0; i < n; i++) B[i] = Double.parseDouble(bparts[i].trim());
            String jsonA = matrixToJson(A);
            String jsonB = vectorToJson(B);
            out.println(jsonA);
            out.println(jsonB);
            String result = in.readLine();
            System.out.println("Nhan ket qua tu server: " + result);
        } catch (Exception e) {
            System.out.println("Loi ket noi server: " + e.getMessage());
        }
    }
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
    private static String vectorToJson(double[] v) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < v.length; i++) {
            sb.append(v[i]);
            if (i < v.length - 1) sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }
} 