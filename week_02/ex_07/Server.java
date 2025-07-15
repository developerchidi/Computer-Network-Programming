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
            byte[] bufferNum = new byte[256];
            DatagramPacket packetNum = new DatagramPacket(bufferNum, bufferNum.length);
            serverSocket.receive(packetNum);
            String strNum = new String(packetNum.getData(), 0, packetNum.getLength()).trim();
            int n = Integer.parseInt(strNum);

            // Nhận hệ cần chuyển đổi từ client
            byte[] bufferBase = new byte[256];
            DatagramPacket packetBase = new DatagramPacket(bufferBase, bufferBase.length);
            serverSocket.receive(packetBase);
            String strBase = new String(packetBase.getData(), 0, packetBase.getLength()).trim();
            int base = Integer.parseInt(strBase);

            String result;
            if (base == 2 || base == 8 || base == 16) {
                String converted = Integer.toString(n, base).toUpperCase();
                result = n + " trong hệ " + base + " là: " + converted;
            } else {
                result = "Hệ đếm không hợp lệ";
            }
            System.out.printf("Nhận: %d, hệ %d | Trả về: %s\n", n, base, result);

            // Gửi kết quả về cho client
            byte[] resultBytes = result.getBytes();
            InetAddress clientAddress = packetNum.getAddress();
            int clientPort = packetNum.getPort();
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