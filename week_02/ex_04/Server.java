import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {
    public static void main(String[] args) {
        DatagramSocket serverSocket = null;
        try {
            serverSocket = new DatagramSocket(9008);
            System.out.println("Server đã sẵn sàng (UDP, port 9008)");

            // Nhận dãy số từ client (dạng chuỗi, các số cách nhau bằng dấu phẩy)
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            serverSocket.receive(packet);
            String input = new String(packet.getData(), 0, packet.getLength()).trim();

            // Tính tổng dãy số
            double sum = 0;
            String[] numbers = input.split(",");
            for (String numStr : numbers) {
                sum += Double.parseDouble(numStr.trim());
            }
            String result = "Tổng dãy số là: " + sum;
            System.out.printf("Nhận: %s | Trả về: %s\n", input, result);

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
} 