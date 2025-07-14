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

                    String jsonA = in.readLine();
                    String jsonB = in.readLine();
                    double[][] A = parseMatrix(jsonA);
                    double[] B = parseVector(jsonB);
                    System.out.println("Nhan he phuong trinh: A=" + Arrays.deepToString(A) + ", B=" + Arrays.toString(B));
                    String result;
                    try {
                        double[] X = gaussJordan(A, B);
                        result = Arrays.toString(X);
                    } catch (Exception e) {
                        result = "Loi: " + e.getMessage();
                    }
                    out.println(result);
                    System.out.println("Gui ket qua: " + result);
                } catch (Exception e) {
                    System.out.println("Loi xu ly client: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Khong the khoi dong server: " + e.getMessage());
        }
    }

    // Parse ma trận từ JSON dạng [[2,1,-1],[-3,-1,2],[-2,1,2]]
    private static double[][] parseMatrix(String json) {
        json = json.trim().replaceAll("\\s", "");
        json = json.substring(1, json.length() - 1);
        String[] rows = json.split("]\\s*,\\s*\\[");
        int n = rows.length;
        double[][] matrix = new double[n][n];
        for (int i = 0; i < n; i++) {
            String row = rows[i].replace("[", "").replace("]", "");
            String[] nums = row.split(",");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Double.parseDouble(nums[j]);
            }
        }
        return matrix;
    }
    // Parse vector từ JSON dạng [8,-11,-3]
    private static double[] parseVector(String json) {
        json = json.trim().replaceAll("\\s", "");
        json = json.substring(1, json.length() - 1);
        String[] nums = json.split(",");
        double[] v = new double[nums.length];
        for (int i = 0; i < nums.length; i++) v[i] = Double.parseDouble(nums[i]);
        return v;
    }
    // Gauss-Jordan elimination
    private static double[] gaussJordan(double[][] A, double[] B) {
        int n = A.length;
        double[][] a = new double[n][n+1];
        for (int i = 0; i < n; i++) {
            System.arraycopy(A[i], 0, a[i], 0, n);
            a[i][n] = B[i];
        }
        for (int i = 0; i < n; i++) {
            // Tìm pivot
            int maxRow = i;
            for (int k = i+1; k < n; k++) if (Math.abs(a[k][i]) > Math.abs(a[maxRow][i])) maxRow = k;
            double[] tmp = a[i]; a[i] = a[maxRow]; a[maxRow] = tmp;
            if (Math.abs(a[i][i]) < 1e-8) throw new RuntimeException("He vo nghiem hoac vo so nghiem");
            // Chuẩn hóa dòng i
            for (int j = i+1; j <= n; j++) a[i][j] /= a[i][i];
            a[i][i] = 1.0;
            // Khử các dòng khác
            for (int k = 0; k < n; k++) if (k != i) {
                double f = a[k][i];
                for (int j = i; j <= n; j++) a[k][j] -= f * a[i][j];
            }
        }
        double[] x = new double[n];
        for (int i = 0; i < n; i++) x[i] = a[i][n];
        return x;
    }
} 