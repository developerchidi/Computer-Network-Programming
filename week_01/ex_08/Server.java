import java.io.*;
import java.net.*;
import java.math.BigInteger;

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
                    int n = Integer.parseInt(input.trim());
                    BigInteger result = parallelFactorial(n);
                    String response = n + "! = " + result;
                    System.out.println("Nhan: " + n + " | Tra ve: " + response);
                    out.println(response);
                } catch (Exception e) {
                    System.out.println("Loi xu ly client: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Khong the khoi dong server: " + e.getMessage());
        }
    }

    // Tính giai thừa song song bằng 4 thread
    private static BigInteger parallelFactorial(int n) throws InterruptedException {
        if (n < 0) return BigInteger.ZERO;
        if (n == 0 || n == 1) return BigInteger.ONE;
        int numThreads = 4;
        FactorialThread[] threads = new FactorialThread[numThreads];
        int chunk = n / numThreads;
        int start = 1;
        for (int i = 0; i < numThreads; i++) {
            int end = (i == numThreads - 1) ? n : start + chunk - 1;
            threads[i] = new FactorialThread(start, end);
            threads[i].start();
            start = end + 1;
        }
        BigInteger result = BigInteger.ONE;
        for (FactorialThread t : threads) {
            t.join();
            result = result.multiply(t.getResult());
        }
        return result;
    }

    static class FactorialThread extends Thread {
        private int start, end;
        private BigInteger result = BigInteger.ONE;
        public FactorialThread(int start, int end) {
            this.start = start;
            this.end = end;
        }
        public void run() {
            for (int i = start; i <= end; i++) {
                result = result.multiply(BigInteger.valueOf(i));
            }
        }
        public BigInteger getResult() {
            return result;
        }
    }
}