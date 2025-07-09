import java.io.*;
import java.net.*;
import java.util.Stack;

public class Server {
    public static void main(String[] args) {
        int port = 12345;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is running on port " + port);
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                     DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream())) {

                    String expr = in.readUTF();
                    String result;
                    try {
                        double value = evalPostfix(expr);
                        result = "Ket qua: " + value;
                    } catch (Exception e) {
                        result = "Bieu thuc khong hop le";
                    }
                    out.writeUTF(result);
                    System.out.println("Nhan: " + expr + "\nTra ve: " + result);
                } catch (IOException e) {
                    System.out.println("Loi ket noi client: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }

    private static double evalPostfix(String expr) throws Exception {
        Stack<Double> stack = new Stack<>();
        String[] tokens = expr.trim().split("\\s+");
        for (String token : tokens) {
            if (token.matches("-?\\d+(\\.\\d+)?")) {
                stack.push(Double.parseDouble(token));
            } else if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                if (stack.size() < 2) throw new Exception();
                double b = stack.pop();
                double a = stack.pop();
                switch (token) {
                    case "+": stack.push(a + b); break;
                    case "-": stack.push(a - b); break;
                    case "*": stack.push(a * b); break;
                    case "/": stack.push(a / b); break;
                }
            } else {
                throw new Exception();
            }
        }
        if (stack.size() != 1) throw new Exception();
        return stack.pop();
    }
} 