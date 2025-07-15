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

            // Nhập hệ số a
            System.out.print("Nhập hệ số a: ");
            double a = Double.parseDouble(reader.readLine());
            // Nhập hệ số b
            System.out.print("Nhập hệ số b: ");
            double b = Double.parseDouble(reader.readLine());
            // Nhập hệ số c
            System.out.print("Nhập hệ số c: ");
            double c = Double.parseDouble(reader.readLine());

            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 9008;

            // Gửi hệ số a
            byte[] aBytes = String.valueOf(a).getBytes();
            DatagramPacket packetA = new DatagramPacket(aBytes, aBytes.length, serverAddress, serverPort);
            clientSocket.send(packetA);
            // Gửi hệ số b
            byte[] bBytes = String.valueOf(b).getBytes();
            DatagramPacket packetB = new DatagramPacket(bBytes, bBytes.length, serverAddress, serverPort);
            clientSocket.send(packetB);
            // Gửi hệ số c
            byte[] cBytes = String.valueOf(c).getBytes();
            DatagramPacket packetC = new DatagramPacket(cBytes, cBytes.length, serverAddress, serverPort);
            clientSocket.send(packetC);

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