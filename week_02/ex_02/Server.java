import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {
    public static void main(String[] args) {
        DatagramSocket serverSocket = null;
        try {
            // Tạo socket UDP lắng nghe trên cổng 9008
            serverSocket = new DatagramSocket(9008);
            System.out.println("Server đã sẵn sàng (UDP, port 9008)");

            // Nhận số nguyên từ client
            byte[] buffer = new byte[256];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            serverSocket.receive(packet);
            String strNum = new String(packet.getData(), 0, packet.getLength()).trim();
            int n = Integer.parseInt(strNum);

            // Kiểm tra số nguyên tố
            String result = isPrime(n) ? "Prime" : "Not Prime";
            System.out.printf("Received: %d | Sent: %s\n", n, result);

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

    // Hàm kiểm tra số nguyên tố
    private static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
} 