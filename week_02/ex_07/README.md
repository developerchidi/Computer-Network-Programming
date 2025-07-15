# Bài 7: Máy chủ chuyển đổi hệ số (UDP)

## Yêu cầu:

- **Client:** Gửi một số nguyên dương và hệ đếm muốn chuyển đổi (2, 8 hoặc 16) đến server qua UDP.
- **Server:** Trả về biểu diễn của số đó trong hệ nhị phân, bát phân hoặc thập lục phân tương ứng.

**Kiến thức toán học:** Chuyển đổi hệ đếm.

**Mục tiêu socket:** Truyền số và hệ đếm, xử lý chuyển đổi trên server qua UDP (DatagramSocket).

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
Nhập số nguyên dương: 31
Nhập hệ cần chuyển đổi (2, 8, 16): 2
Kết quả từ server: 31 trong hệ 2 là: 11111
```

**Server:**
```
Server đã sẵn sàng (UDP, port 9008)
Nhận: 31, hệ 2 | Trả về: 31 trong hệ 2 là: 11111
```

**Client:**
```
Nhập số nguyên dương: 31
Nhập hệ cần chuyển đổi (2, 8, 16): 16
Kết quả từ server: 31 trong hệ 16 là: 1F
```

**Client (hệ không hợp lệ):**
```
Nhập số nguyên dương: 31
Nhập hệ cần chuyển đổi (2, 8, 16): 10
Kết quả từ server: Hệ đếm không hợp lệ
``` 