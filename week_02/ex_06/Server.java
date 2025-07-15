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

            // Kiểm tra đối xứng
            String result = isPalindrome(n) ? (n + " là số đối xứng") : (n + " không phải là số đối xứng");
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

    // Hàm kiểm tra số đối xứng
    private static boolean isPalindrome(int n) {
        int original = n, reversed = 0;
        while (n > 0) {
            reversed = reversed * 10 + n % 10;
            n /= 10;
        }
        return original == reversed;
    }
} 