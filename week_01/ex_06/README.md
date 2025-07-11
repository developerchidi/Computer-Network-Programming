# Bài 6: Kiểm tra tính đối xứng số

Viết chương trình TCP client-server:

- **Client** gửi một số nguyên dương đến **server**.
- **Server** kiểm tra xem số đó có phải là **số đối xứng** (palindrome) hay không, và gửi kết quả về client.

Ví dụ: 121 là đối xứng, 123 thì không.

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
Nhap so nguyen duong: 121
Ket qua tu server: 121 la so doi xung
```

**Server:**
```
Server is running on port 12345
Nhan: 121 | Tra ve: 121 la so doi xung
```

**Client:**
```
Nhap so nguyen duong: 123
Ket qua tu server: 123 khong phai la so doi xung
```

**Server:**
```
Server is running on port 12345
Nhan: 123 | Tra ve: 123 khong phai la so doi xung
``` 