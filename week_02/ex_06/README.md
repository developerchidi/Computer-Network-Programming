# Bài 6: Kiểm tra tính đối xứng số (UDP)

## Yêu cầu:

- **Client:** Gửi một số nguyên dương đến server qua UDP.
- **Server:** Kiểm tra xem số đó có phải là số đối xứng (palindrome) hay không, gửi kết quả về client qua UDP.

**Kiến thức toán học:** Số đối xứng (palindrome).

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
Nhập số nguyên dương: 121
Kết quả từ server: 121 là số đối xứng
```

**Server:**
```
Server đã sẵn sàng (UDP, port 9008)
Nhận: 121 | Trả về: 121 là số đối xứng
```

**Client:**
```
Nhập số nguyên dương: 123
Kết quả từ server: 123 không phải là số đối xứng
```

**Server:**
```
Server đã sẵn sàng (UDP, port 9008)
Nhận: 123 | Trả về: 123 không phải là số đối xứng
``` 