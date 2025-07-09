# Bài 2: Kiểm tra số nguyên tố

## Yêu cầu:

- **Client:** Nhập 1 số nguyên, gửi tới server.
- **Server:** Kiểm tra xem số đó có phải là số nguyên tố không, trả kết quả dạng "Prime" hoặc "Not Prime".
- **Client:** Hiển thị kết quả từ server.

**Kiến thức toán học:** Kiểm tra số nguyên tố.

**Mục tiêu socket:** Xử lý logic ở server, trả phản hồi dạng chuỗi.

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
Nhập một số nguyên: 7
Kết quả từ server: Prime
```

**Server:**
```
Server is running on port 12345
Received: 7 | Sent: Prime
```

**Client:**
```
Nhập một số nguyên: 8
Kết quả từ server: Not Prime
```

**Server:**
```
Server is running on port 12345
Received: 8 | Sent: Not Prime
``` 