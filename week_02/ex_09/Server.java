import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {
    public static void main(String[] args) {
        DatagramSocket serverSocket = null;
        try {
            serverSocket = new DatagramSocket(9008);
            System.out.println("Server đã sẵn sàng (UDP, port 9008)");

            // Nhận danh sách số thực từ client (dạng chuỗi, các số cách nhau bằng dấu phẩy)
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            serverSocket.receive(packet);
            String input = new String(packet.getData(), 0, packet.getLength()).trim();

            String[] parts = input.split(",");
            double sum = 0, max = Double.NEGATIVE_INFINITY, min = Double.POSITIVE_INFINITY;
            int count = 0;
            for (String part : parts) {
                double val = Double.parseDouble(part.trim());
                sum += val;
                if (val > max) max = val;
                if (val < min) min = val;
                count++;
            }
            double avg = sum / count;
            String result = String.format("Trung bình: %.2f\nLớn nhất: %.1f\nNhỏ nhất: %.1f", avg, max, min);
            System.out.printf("Nhận: %s\nTrả về:\n%s\n", input, result);

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