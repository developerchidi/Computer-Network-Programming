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

                    String json = in.readLine();
                    double[][] matrix = parseMatrixFromJson(json);
                    System.out.println("Nhan ma tran kich thuoc " + matrix.length + " x " + matrix.length);
                    double det = parallelDeterminant(matrix);
                    out.println(det);
                    System.out.println("Tra ve dinh thuc: " + det);
                } catch (Exception e) {
                    System.out.println("Loi xu ly client: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Khong the khoi dong server: " + e.getMessage());
        }
    }

    // Parse ma trận từ JSON dạng [[1,2],[3,4]]
    private static double[][] parseMatrixFromJson(String json) {
        json = json.trim().replaceAll("\\s", "");
        json = json.substring(1, json.length() - 1); // bỏ [ ] ngoài
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

    // Tính định thức song song bằng Laplace expansion
    private static double parallelDeterminant(double[][] matrix) throws InterruptedException {
        int n = matrix.length;
        if (n == 1) return matrix[0][0];
        if (n == 2) return matrix[0][0]*matrix[1][1] - matrix[0][1]*matrix[1][0];
        DetThread[] threads = new DetThread[n];
        double[] results = new double[n];
        for (int j = 0; j < n; j++) {
            double sign = (j % 2 == 0) ? 1 : -1;
            double[][] minor = getMinor(matrix, 0, j);
            threads[j] = new DetThread(sign * matrix[0][j], minor, results, j);
            threads[j].start();
        }
        for (DetThread t : threads) t.join();
        double det = 0;
        for (double v : results) det += v;
        return det;
    }

    // Lấy ma trận con bỏ dòng row, cột col
    private static double[][] getMinor(double[][] matrix, int row, int col) {
        int n = matrix.length;
        double[][] minor = new double[n-1][n-1];
        int r = 0;
        for (int i = 0; i < n; i++) {
            if (i == row) continue;
            int c = 0;
            for (int j = 0; j < n; j++) {
                if (j == col) continue;
                minor[r][c++] = matrix[i][j];
            }
            r++;
        }
        return minor;
    }

    // Thread tính định thức nhánh con
    static class DetThread extends Thread {
        double coef;
        double[][] minor;
        double[] results;
        int idx;
        DetThread(double coef, double[][] minor, double[] results, int idx) {
            this.coef = coef;
            this.minor = minor;
            this.results = results;
            this.idx = idx;
        }
        public void run() {
            results[idx] = coef * determinant(minor);
        }
        // Đệ quy Laplace (tuần tự)
        private double determinant(double[][] matrix) {
            int n = matrix.length;
            if (n == 1) return matrix[0][0];
            if (n == 2) return matrix[0][0]*matrix[1][1] - matrix[0][1]*matrix[1][0];
            double det = 0;
            for (int j = 0; j < n; j++) {
                double sign = (j % 2 == 0) ? 1 : -1;
                det += sign * matrix[0][j] * determinant(getMinor(matrix, 0, j));
            }
            return det;
        }
    }
} 