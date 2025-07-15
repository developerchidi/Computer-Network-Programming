# Bài 4: Tính tổng dãy số (UDP)

## Yêu cầu:

- **Client:** Nhập một dãy số (cách nhau bằng dấu phẩy), gửi tới server qua giao thức UDP.
- **Server:** Tính tổng các phần tử trong dãy, trả về kết quả qua UDP.

**Kiến thức toán học:** Tổng dãy số.

**Mục tiêu socket:** Xử lý chuỗi, tách số từ chuỗi, tổng hợp qua UDP (DatagramSocket).

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
Nhập dãy số (cách nhau bằng dấu phẩy): 1,2,3,4,5
Kết quả từ server: Tổng dãy số là: 15.0
```

**Server:**
```
Server đã sẵn sàng (UDP, port 9008)
Nhận: 1,2,3,4,5 | Trả về: Tổng dãy số là: 15.0
``` 