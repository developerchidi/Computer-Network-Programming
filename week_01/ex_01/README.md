# Bài 1: Tính tổng hai số nguyên

## Yêu cầu:

- **Client:** Nhập hai số nguyên từ bàn phím, gửi tới server.
- **Server:** Nhận 2 số, tính tổng và trả kết quả về client.
- **Client:** Hiển thị kết quả tổng từ server.

**Kiến thức toán học:** Cộng 2 số nguyên.

**Mục tiêu socket:** Kết nối, gửi và nhận dữ liệu dạng số nguyên.

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

---

## Ví dụ kết quả

**Client:**
```
Nhap so nguyen thu nhat: 5
Nhap so nguyen thu hai: 7
Tong hai so la: 12
```

**Server:**
```
Server is running on port 12345
Nhan 2 so: 5, 7 | Tra ve tong: 12
```
