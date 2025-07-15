import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Stack;

public class Server {
    public static void main(String[] args) {
        DatagramSocket serverSocket = null;
        try {
            serverSocket = new DatagramSocket(9008);
            System.out.println("Server đã sẵn sàng (UDP, port 9008)");

            // Nhận biểu thức hậu tố từ client
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            serverSocket.receive(packet);
            String expr = new String(packet.getData(), 0, packet.getLength()).trim();

            String result = evaluatePostfix(expr);
            System.out.printf("Nhận: %s\nTrả về: %s\n", expr, result);

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

    // Hàm tính giá trị biểu thức hậu tố
    private static String evaluatePostfix(String expr) {
        try {
            Stack<Double> stack = new Stack<>();
            String[] tokens = expr.split(" ");
            for (String token : tokens) {
                if (token.matches("-?\\d+(\\.\\d+)?")) {
                    stack.push(Double.parseDouble(token));
                } else if (token.length() == 1 && "+-*/".contains(token)) {
                    if (stack.size() < 2) return "Biểu thức không hợp lệ";
                    double b = stack.pop();
                    double a = stack.pop();
                    switch (token.charAt(0)) {
                        case '+': stack.push(a + b); break;
                        case '-': stack.push(a - b); break;
                        case '*': stack.push(a * b); break;
                        case '/': if (b == 0) return "Lỗi: chia cho 0"; stack.push(a / b); break;
                    }
                } else {
                    return "Biểu thức không hợp lệ";
                }
            }
            if (stack.size() != 1) return "Biểu thức không hợp lệ";
            return "Kết quả: " + stack.pop();
        } catch (Exception e) {
            return "Biểu thức không hợp lệ";
        }
    }
} 