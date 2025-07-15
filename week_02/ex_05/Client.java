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

            // Nhập biểu thức hậu tố
            System.out.print("Nhập biểu thức hậu tố (VD: 3 4 2 * +): ");
            String expr = reader.readLine();

            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 9008;

            // Gửi biểu thức tới server
            byte[] exprBytes = expr.getBytes();
            DatagramPacket packet = new DatagramPacket(exprBytes, exprBytes.length, serverAddress, serverPort);
            clientSocket.send(packet);

            // Nhận kết quả từ server
            byte[] buffer = new byte[256];
            DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length);
            clientSocket.receive(responsePacket);
            String result = new String(responsePacket.getData(), 0, responsePacket.getLength()).trim();
            System.out.println("Kết quả từ server:\n" + result);
        } catch (Exception e) {
            System.err.println("Lỗi client: " + e.getMessage());
        } finally {
            if (clientSocket != null && !clientSocket.isClosed()) {
                clientSocket.close();
            }
        }
    }
} 