# Bài 4: Tính tổng dãy số

## Yêu cầu:

- **Client:** Nhập một dãy số (cách nhau bằng dấu phẩy), gửi tới server.
- **Server:** Tính tổng các phần tử trong dãy, trả về kết quả.

**Kiến thức toán học:** Tổng dãy số.

**Mục tiêu socket:** Xử lý chuỗi, tách số từ chuỗi, tổng hợp.

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
Nhap day so (cach nhau bang dau phay): 1,2,3,4,5
Ket qua tu server: Tong day so la: 15.0
```

**Server:**
```
Server is running on port 12345
Nhan: 1,2,3,4,5 | Tra ve: Tong day so la: 15.0
``` 