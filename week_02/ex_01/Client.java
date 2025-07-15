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

            // Nhập số a
            System.out.print("Nhập số a: ");
            int a = Integer.parseInt(reader.readLine());
            // Nhập số b
            System.out.print("Nhập số b: ");
            int b = Integer.parseInt(reader.readLine());

            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 9008;

            // Gửi số a
            byte[] aBytes = String.valueOf(a).getBytes();
            DatagramPacket packetA = new DatagramPacket(aBytes, aBytes.length, serverAddress, serverPort);
            clientSocket.send(packetA);
            // Gửi số b
            byte[] bBytes = String.valueOf(b).getBytes();
            DatagramPacket packetB = new DatagramPacket(bBytes, bBytes.length, serverAddress, serverPort);
            clientSocket.send(packetB);

            // Nhận kết quả từ server
            byte[] buffer = new byte[256];
            DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length);
            clientSocket.receive(responsePacket);
            String result = new String(responsePacket.getData(), 0, responsePacket.getLength()).trim();
            System.out.println("Kết quả: " + result);
        } catch (Exception e) {
            System.err.println("Lỗi client: " + e.getMessage());
        } finally {
            if (clientSocket != null && !clientSocket.isClosed()) {
                clientSocket.close();
            }
        }
    }
} 