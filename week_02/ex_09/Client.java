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

            // Nhập danh sách số thực (cách nhau bằng dấu phẩy)
            System.out.print("Nhập danh sách số thực (cách nhau bằng dấu phẩy): ");
            String input = reader.readLine();

            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 9008;

            // Gửi danh sách tới server
            byte[] inputBytes = input.getBytes();
            DatagramPacket packet = new DatagramPacket(inputBytes, inputBytes.length, serverAddress, serverPort);
            clientSocket.send(packet);

            // Nhận kết quả từ server
            byte[] buffer = new byte[512];
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