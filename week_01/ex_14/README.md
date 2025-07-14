# Bài 14: Mã hóa Hill Cipher trên mạng

- **Client** gửi 1 văn bản và ma trận khóa K (kích thước 2x2 hoặc 3x3) đến server.
- **Server** thực hiện mã hóa Hill Cipher (yêu cầu: det(K) khác 0 mod 26) rồi gửi kết quả về.
- Sau đó, client tiếp tục gửi mã đã mã hóa và yêu cầu giải mã, server thực hiện tìm nghịch đảo của ma trận khóa rồi giải mã và gửi lại kết quả.

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

## Ví dụ test

**Client:**
```
Nhap van ban can ma hoa: HELLO
Nhap kich thuoc ma tran khoa (2 hoac 3): 2
Nhap dong 1 khoa (cach nhau bang dau phay): 3,3
Nhap dong 2 khoa (cach nhau bang dau phay): 2,5
Nhan ban ma hoa tu server: RRLZWA
Nhap ban ma hoa de giai ma: RRLZWA
Nhan van ban giai ma tu server: HELLOX
```

**Server:**
```
Server is running on port 12345
Nhan van ban: HELLO
Nhan khoa: [[3,3],[2,5]]
Ban ma hoa: RRLZWA
Nhan yeu cau giai ma: RRLZWA
Ban giai ma: HELLOX
```

---

## Lưu ý
- Văn bản sẽ được tự động thêm ký tự 'X' nếu không đủ chia hết cho kích thước ma trận.
- Ma trận khóa phải có định thức khác 0 và gcd(det,26)=1 để tồn tại nghịch đảo.
- Chỉ dùng bảng chữ cái tiếng Anh in hoa (A-Z). 