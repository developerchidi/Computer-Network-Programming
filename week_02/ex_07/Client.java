import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Client {
    public static void main(String[] args) {
        DatagramSocket clientSocket = null;
        try {
            clientSocket = new DatagramSocket();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            // Nhập số nguyên dương
            System.out.print("Nhập số nguyên dương: ");
            int n = Integer.parseInt(reader.readLine());
            // Nhập hệ cần chuyển đổi
            System.out.print("Nhập hệ cần chuyển đổi (2, 8, 16): ");
            int base = Integer.parseInt(reader.readLine());

            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 9008;

            // Gửi số nguyên tới server
            byte[] nBytes = String.valueOf(n).getBytes();
            DatagramPacket packetNum = new DatagramPacket(nBytes, nBytes.length, serverAddress, serverPort);
            clientSocket.send(packetNum);
            // Gửi hệ cần chuyển đổi tới server
            byte[] baseBytes = String.valueOf(base).getBytes();
            DatagramPacket packetBase = new DatagramPacket(baseBytes, baseBytes.length, serverAddress, serverPort);
            clientSocket.send(packetBase);

            // Nhận kết quả từ server
            byte[] buffer = new byte[256];
            DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length);
            clientSocket.receive(responsePacket);
            String result = new String(responsePacket.getData(), 0, responsePacket.getLength()).trim();
            System.out.println("Kết quả từ server: " + result);
        } catch (Exception e) {
            System.err.println("Lỗi client: " + e.getMessage());
        } finally {
            if (clientSocket != null && !clientSocket.isClosed()) {
                clientSocket.close();
            }
        }
    }
} 