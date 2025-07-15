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

            // Nhận số a từ client
            byte[] bufferA = new byte[256];
            DatagramPacket packetA = new DatagramPacket(bufferA, bufferA.length);
            serverSocket.receive(packetA);
            String strA = new String(packetA.getData(), 0, packetA.getLength()).trim();
            int a = Integer.parseInt(strA);

            // Nhận số b từ client
            byte[] bufferB = new byte[256];
            DatagramPacket packetB = new DatagramPacket(bufferB, bufferB.length);
            serverSocket.receive(packetB);
            String strB = new String(packetB.getData(), 0, packetB.getLength()).trim();
            int b = Integer.parseInt(strB);

            int sum = a + b;
            System.out.printf("Nhận: %d, %d | Trả về: %d\n", a, b, sum);

            // Gửi kết quả về cho client
            String result = String.valueOf(sum);
            byte[] resultBytes = result.getBytes();
            InetAddress clientAddress = packetA.getAddress();
            int clientPort = packetA.getPort();
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
} 