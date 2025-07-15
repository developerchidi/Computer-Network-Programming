# Bài 1: Tính tổng hai số nguyên (UDP)

## Yêu cầu:

- **Client:** Nhập hai số nguyên từ bàn phím, gửi tới server qua giao thức UDP.
- **Server:** Nhận 2 số, tính tổng và trả kết quả về client (qua UDP).
- **Client:** Hiển thị kết quả tổng nhận được từ server.

**Kiến thức toán học:** Cộng 2 số nguyên.

**Mục tiêu socket:** Kết nối, gửi và nhận dữ liệu số nguyên qua UDP (DatagramSocket).

---

## Hướng dẫn chạy

1. **Biên dịch:**
   ```bash
   javac Server.java
   javac Client.java
   ```
2. **Chạy server:**
   ```bash
   java Server
   ```
3. **Chạy client (mở terminal khác):**
   ```bash
   java Client
   ```

> Lưu ý: Server sử dụng cổng `9008` và chạy trên `localhost`.

---

## Ví dụ kết quả

**Client:**
```
Nhập số a: 5
Nhập số b: 7
Kết quả: 12
```

**Server:**
```
Server đã sẵn sàng (UDP, port 9008)
Nhận: 5, 7 | Trả về: 12
``` 