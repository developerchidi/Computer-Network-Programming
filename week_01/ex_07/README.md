# Bài 7: Máy chủ chuyển đổi hệ số

- **Client** gửi một số nguyên dương và hệ đếm muốn chuyển đổi (2, 8 hoặc 16) đến **server**.
- **Server** trả về biểu diễn của số đó trong hệ nhị phân, bát phân hoặc thập lục phân tương ứng.

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
Nhap so nguyen duong: 31
Nhap he can chuyen doi (2, 8, 16): 2
Ket qua tu server: 31 trong he 2 la: 11111
```

**Server:**
```
Server is running on port 12345
Nhan: 31, he 2 | Tra ve: 31 trong he 2 la: 11111
```

**Client:**
```
Nhap so nguyen duong: 31
Nhap he can chuyen doi (2, 8, 16): 16
Ket qua tu server: 31 trong he 16 la: 1F
```

**Client (hệ không hợp lệ):**
```
Nhap so nguyen duong: 31
Nhap he can chuyen doi (2, 8, 16): 10
Ket qua tu server: He dem khong hop le
``` 