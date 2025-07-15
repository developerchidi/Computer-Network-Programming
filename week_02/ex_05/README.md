# Bài 5: Máy chủ giải toán biểu thức hậu tố (UDP)

## Yêu cầu:

- **Client:** Gửi một biểu thức hậu tố, ví dụ: "3 4 2 * +" tới server qua UDP.
- **Server:** Phân tích và tính giá trị biểu thức, gửi kết quả về client qua UDP.

**Kiến thức toán học:** Biểu thức hậu tố, ngăn xếp (stack).

**Mục tiêu socket:** Phân tích biểu thức, xử lý ngăn xếp trên server qua UDP (DatagramSocket).

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
Nhập biểu thức hậu tố (VD: 3 4 2 * +): 3 4 2 * +
Kết quả từ server:
Kết quả: 11.0
```

**Server:**
```
Server đã sẵn sàng (UDP, port 9008)
Nhận: 3 4 2 * +
Trả về: Kết quả: 11.0
```

**Client (biểu thức sai):**
```
Nhập biểu thức hậu tố (VD: 3 4 + *): 3 4 + *
Kết quả từ server:
Biểu thức không hợp lệ
``` 