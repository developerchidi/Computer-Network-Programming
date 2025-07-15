# Bài 8: Tính giai thừa song song (UDP)

## Yêu cầu:

- **Client:** Gửi một số nguyên n đến server qua UDP.
- **Server:** Tính n! (giai thừa), gửi kết quả về client qua UDP.

**Kiến thức toán học:** Giai thừa số nguyên dương.

**Mục tiêu socket:** Tính toán và trả kết quả qua UDP (DatagramSocket).

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
Nhập số nguyên: 10
Kết quả từ server: 10! = 3628800
```

**Server:**
```
Server đã sẵn sàng (UDP, port 9008)
Nhận: 10 | Trả về: 10! = 3628800
``` 