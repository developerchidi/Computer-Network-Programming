# Bài 3: Giải phương trình bậc hai (UDP)

## Yêu cầu:

- **Client:** Nhập 3 hệ số a, b, c, gửi tới server qua giao thức UDP.
- **Server:** Giải phương trình ax² + bx + c = 0, trả nghiệm (nếu có) về client (qua UDP).
- **Client:** Hiển thị nghiệm từ server.

**Kiến thức toán học:** Phân biệt Δ, tính nghiệm thực hoặc phức.

**Mục tiêu socket:** Truyền và xử lý mảng dữ liệu thực (float/double), nhiều giá trị trả về qua UDP (DatagramSocket).

---

## Hướng dẫn chạy

1. Biên dịch:
   ```bash
   javac Server.java
   javac Client.java
   ```
2. Chạy server:
   ```bash
   java Server
   ```
3. Chạy client (mở terminal khác):
   ```bash
   java Client
   ```

> Lưu ý: Server sử dụng cổng `9008` và chạy trên `localhost`.

---

## Ví dụ kết quả

**Client:**
```
Nhập hệ số a: 1
Nhập hệ số b: -3
Nhập hệ số c: 2
Kết quả từ server: 2 nghiệm thực: x1 = 2.00, x2 = 1.00
```

**Server:**
```
Server đã sẵn sàng (UDP, port 9008)
Nhận: a=1.00, b=-3.00, c=2.00 | Trả về: 2 nghiệm thực: x1 = 2.00, x2 = 1.00
```

**Client:**
```
Nhập hệ số a: 1
Nhập hệ số b: 2
Nhập hệ số c: 1
Kết quả từ server: Nghiệm kép: x = -1.00
```

**Client:**
```
Nhập hệ số a: 1
Nhập hệ số b: 2
Nhập hệ số c: 5
Kết quả từ server: 2 nghiệm phức: x1 = -1.00 + 2.00i, x2 = -1.00 - 2.00i
``` 