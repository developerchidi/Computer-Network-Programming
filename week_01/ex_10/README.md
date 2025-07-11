# Bài 10: Kiểm tra số Fibonacci

- **Client** gửi một số nguyên dương n đến **server**.
- **Server** kiểm tra xem số đó có thuộc dãy **Fibonacci** hay không và gửi kết quả về client.

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
Nhap so nguyen duong: 21
Ket qua tu server: 21 la so Fibonacci
```

**Server:**
```
Server is running on port 12345
Nhan: 21 | Tra ve: 21 la so Fibonacci
```

**Client:**
```
Nhap so nguyen duong: 22
Ket qua tu server: 22 khong phai la so Fibonacci
```

**Server:**
```
Server is running on port 12345
Nhan: 22 | Tra ve: 22 khong phai la so Fibonacci
``` 