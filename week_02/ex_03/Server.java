import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {
    public static void main(String[] args) {
        DatagramSocket serverSocket = null;
        try {
            serverSocket = new DatagramSocket(9008);
            System.out.println("Server đã sẵn sàng (UDP, port 9008)");

            // Nhận hệ số a
            byte[] bufferA = new byte[256];
            DatagramPacket packetA = new DatagramPacket(bufferA, bufferA.length);
            serverSocket.receive(packetA);
            String strA = new String(packetA.getData(), 0, packetA.getLength()).trim();
            double a = Double.parseDouble(strA);

            // Nhận hệ số b
            byte[] bufferB = new byte[256];
            DatagramPacket packetB = new DatagramPacket(bufferB, bufferB.length);
            serverSocket.receive(packetB);
            String strB = new String(packetB.getData(), 0, packetB.getLength()).trim();
            double b = Double.parseDouble(strB);

            // Nhận hệ số c
            byte[] bufferC = new byte[256];
            DatagramPacket packetC = new DatagramPacket(bufferC, bufferC.length);
            serverSocket.receive(packetC);
            String strC = new String(packetC.getData(), 0, packetC.getLength()).trim();
            double c = Double.parseDouble(strC);

            String result = solveQuadratic(a, b, c);
            System.out.printf("Nhận: a=%.2f, b=%.2f, c=%.2f | Trả về: %s\n", a, b, c, result);

            // Gửi kết quả về cho client
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

    // Hàm giải phương trình bậc hai
    private static String solveQuadratic(double a, double b, double c) {
        if (a == 0) {
            if (b == 0) return (c == 0) ? "Vô số nghiệm" : "Vô nghiệm";
            return "Nghiệm: x = " + (-c / b);
        }
        double delta = b * b - 4 * a * c;
        if (delta > 0) {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            return String.format("2 nghiệm thực: x1 = %.2f, x2 = %.2f", x1, x2);
        } else if (delta == 0) {
            double x = -b / (2 * a);
            return String.format("Nghiệm kép: x = %.2f", x);
        } else {
            double real = -b / (2 * a);
            double imag = Math.sqrt(-delta) / (2 * a);
            return String.format("2 nghiệm phức: x1 = %.2f + %.2fi, x2 = %.2f - %.2fi", real, imag, real, imag);
        }
    }
} 