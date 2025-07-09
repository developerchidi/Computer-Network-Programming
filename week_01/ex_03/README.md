# Bài 3: Giải phương trình bậc hai

## Yêu cầu:

- **Client:** Nhập 3 hệ số a, b, c, gửi tới server.
- **Server:** Giải phương trình ax² + bx + c = 0, trả nghiệm (nếu có) về client.
- **Client:** Hiển thị nghiệm từ server.

**Kiến thức toán học:** Phân biệt Δ, tính nghiệm thực hoặc phức.

**Mục tiêu socket:** Truyền và xử lý mảng dữ liệu thực (float), nhiều giá trị trả về.

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

---

## Ví dụ kết quả

**Client:**
```
Nhap he so a: 1
Nhap he so b: -3
Nhap he so c: 2
Ket qua tu server: 2 nghiem thuc: x1 = 2.0, x2 = 1.0
```

**Server:**
```
Server is running on port 12345
Nhan: a=1.0, b=-3.0, c=2.0 | Tra ve: 2 nghiem thuc: x1 = 2.0, x2 = 1.0
```

**Client:**
```
Nhap he so a: 1
Nhap he so b: 2
Nhap he so c: 1
Ket qua tu server: Nghiem kep: x = -1.0
```

**Client:**
```
Nhap he so a: 1
Nhap he so b: 2
Nhap he so c: 5
Ket qua tu server: 2 nghiem phuc: x1 = -1.0 + 2.0i, x2 = -1.0 - 2.0i
``` 