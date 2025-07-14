# Bài 11: Hệ phân tán tính định thức ma trận lớn

- **Client** gửi một ma trận vuông kích thước n × n (dạng chuỗi JSON) đến server.
- **Server** phân chia thành nhiều nhánh con (thread workers) để tính định thức theo phép Laplace expansion song song.
- Sau khi tính xong, kết quả được tổng hợp và gửi lại cho client.
- **Yêu cầu:** Kết quả chính xác với ma trận kích thước n ≥ 10.

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
Nhap kich thuoc ma tran n: 3
Nhap dong 1 (cach nhau bang dau phay): 1,2,3
Nhap dong 2 (cach nhau bang dau phay): 0,1,4
Nhap dong 3 (cach nhau bang dau phay): 5,6,0
Dinh thuc ma tran la: 1.0
```

**Server:**
```
Server is running on port 12345
Nhan ma tran kich thuoc 3 x 3
Tra ve dinh thuc: 1.0
```

---

## Gợi ý
- Nên sử dụng JSON để truyền ma trận giữa client và server.
- Có thể dùng đa luồng (thread) để tăng tốc tính toán định thức với ma trận lớn.
- Đảm bảo kết quả chính xác với n ≥ 10. 