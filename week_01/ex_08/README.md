# Bài 8: Tính giai thừa song song

- **Client** gửi một số nguyên n đến **server**.
- **Server** chia công việc tính n! thành các đoạn nhỏ (nhiều thread hoặc xử lý tuần tự tùy yêu cầu), sau đó gửi kết quả về cho client.

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
Nhap so nguyen: 10
Ket qua tu server: 10! = 3628800
```

**Server:**
```
Server is running on port 12345
Nhan: 10 | Tra ve: 10! = 3628800
``` 