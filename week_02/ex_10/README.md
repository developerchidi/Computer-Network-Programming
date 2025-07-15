# Bài 10: Kiểm tra số Fibonacci (UDP)

## Yêu cầu:

- **Client:** Gửi một số nguyên dương n đến server qua UDP.
- **Server:** Kiểm tra xem số đó có thuộc dãy Fibonacci hay không và gửi kết quả về client qua UDP.

**Kiến thức toán học:** Dãy số Fibonacci.

**Mục tiêu socket:** Kiểm tra logic và trả kết quả qua UDP (DatagramSocket).

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
Nhập số nguyên dương: 21
Kết quả từ server: 21 là số Fibonacci
```

**Server:**
```
Server đã sẵn sàng (UDP, port 9008)
Nhận: 21 | Trả về: 21 là số Fibonacci
```

**Client:**
```
Nhập số nguyên dương: 22
Kết quả từ server: 22 không phải là số Fibonacci
```

**Server:**
```
Server đã sẵn sàng (UDP, port 9008)
Nhận: 22 | Trả về: 22 không phải là số Fibonacci
``` 