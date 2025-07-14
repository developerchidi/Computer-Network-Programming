import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    public static void main(String[] args) {
        int port = 12345;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is running on port " + port);
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    String plain = in.readLine();
                    int n = Integer.parseInt(in.readLine());
                    int[][] key = new int[n][n];
                    for (int i = 0; i < n; i++) {
                        String[] parts = in.readLine().split(",");
                        for (int j = 0; j < n; j++) key[i][j] = Integer.parseInt(parts[j].trim());
                    }
                    System.out.println("Nhan van ban: " + plain);
                    System.out.println("Nhan khoa: " + Arrays.deepToString(key));
                    String cipher = hillEncrypt(plain, key, n);
                    out.println(cipher);
                    System.out.println("Ban ma hoa: " + cipher);

                    // Nhận bản mã để giải mã
                    String cipher2 = in.readLine();
                    System.out.println("Nhan yeu cau giai ma: " + cipher2);
                    String plain2 = hillDecrypt(cipher2, key, n);
                    out.println(plain2);
                    System.out.println("Ban giai ma: " + plain2);
                } catch (Exception e) {
                    System.out.println("Loi xu ly client: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Khong the khoi dong server: " + e.getMessage());
        }
    }

    // Hill Cipher Encrypt
    private static String hillEncrypt(String text, int[][] key, int n) {
        text = text.replaceAll("[^A-Z]", "").toUpperCase();
        while (text.length() % n != 0) text += "X";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i += n) {
            int[] vec = new int[n];
            for (int j = 0; j < n; j++) vec[j] = text.charAt(i + j) - 'A';
            int[] res = new int[n];
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) res[r] += key[r][c] * vec[c];
                res[r] = ((res[r] % 26) + 26) % 26;
            }
            for (int v : res) sb.append((char) (v + 'A'));
        }
        return sb.toString();
    }

    // Hill Cipher Decrypt
    private static String hillDecrypt(String cipher, int[][] key, int n) {
        int det = modDet(key, n, 26);
        int detInv = modInverse(det, 26);
        int[][] invKey = matrixModInverse(key, n, 26, detInv);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cipher.length(); i += n) {
            int[] vec = new int[n];
            for (int j = 0; j < n; j++) vec[j] = cipher.charAt(i + j) - 'A';
            int[] res = new int[n];
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) res[r] += invKey[r][c] * vec[c];
                res[r] = ((res[r] % 26) + 26) % 26;
            }
            for (int v : res) sb.append((char) (v + 'A'));
        }
        return sb.toString();
    }

    // Tính định thức mod m
    private static int modDet(int[][] mat, int n, int m) {
        if (n == 2) return ((mat[0][0]*mat[1][1] - mat[0][1]*mat[1][0]) % m + m) % m;
        if (n == 3) {
            int det = mat[0][0]*(mat[1][1]*mat[2][2]-mat[1][2]*mat[2][1])
                    - mat[0][1]*(mat[1][0]*mat[2][2]-mat[1][2]*mat[2][0])
                    + mat[0][2]*(mat[1][0]*mat[2][1]-mat[1][1]*mat[2][0]);
            return ((det % m) + m) % m;
        }
        return 0;
    }

    // Tìm nghịch đảo modulo
    private static int modInverse(int a, int m) {
        a = ((a % m) + m) % m;
        for (int x = 1; x < m; x++) if ((a * x) % m == 1) return x;
        throw new RuntimeException("Khong ton tai nghich dao!");
    }

    // Nghịch đảo ma trận mod m
    private static int[][] matrixModInverse(int[][] mat, int n, int m, int detInv) {
        int[][] inv = new int[n][n];
        if (n == 2) {
            inv[0][0] = mat[1][1]; inv[0][1] = -mat[0][1];
            inv[1][0] = -mat[1][0]; inv[1][1] = mat[0][0];
            for (int i = 0; i < n; i++) for (int j = 0; j < n; j++)
                inv[i][j] = ((inv[i][j] * detInv) % m + m) % m;
        } else if (n == 3) {
            for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) {
                int sign = ((i+j)%2==0)?1:-1;
                int[][] minor = new int[2][2];
                int r=0,c=0;
                for (int ii=0;ii<3;ii++) if(ii!=i) {
                    c=0;
                    for (int jj=0;jj<3;jj++) if(jj!=j) minor[r][c++]=mat[ii][jj];
                    r++;
                }
                int cofactor = sign * (minor[0][0]*minor[1][1]-minor[0][1]*minor[1][0]);
                inv[j][i] = ((cofactor * detInv) % m + m) % m;
            }
        }
        return inv;
    }
} 