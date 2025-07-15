import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {
    public static void main(String[] args) {
        DatagramSocket serverSocket = null;
        try {
            serverSocket = new DatagramSocket(9008);
            System.out.println("Server đã sẵn sàng (UDP, port 9008)");

            // Nhận số nguyên dương từ client
            byte[] buffer = new byte[256];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            serverSocket.receive(packet);
            String strNum = new String(packet.getData(), 0, packet.getLength()).trim();
            int n = Integer.parseInt(strNum);

            // Kiểm tra số Fibonacci
            String result = isFibonacci(n) ? (n + " là số Fibonacci") : (n + " không phải là số Fibonacci");
            System.out.printf("Nhận: %d | Trả về: %s\n", n, result);

            // Gửi kết quả về cho client
            byte[] resultBytes = result.getBytes();
            InetAddress clientAddress = packet.getAddress();
            int clientPort = packet.getPort();
            DatagramPacket resultPacket = new DatagramPacket(resultBytes, resultBytes.length, clientAddress, clientPort);
            serverSocket.send(resultPacket);
        } catch (Exception e) {
            System.err.println("Lỗi server: " + e.getMessage());
        } finally {
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
            }
        }
    }

    // Hàm kiểm tra số Fibonacci
    private static boolean isFibonacci(int n) {
        if (n < 0) return false;
        int a = 0, b = 1;
        while (b < n) {
            int temp = b;
            b = a + b;
            a = temp;
        }
        return n == b || n == 0;
    }
} 