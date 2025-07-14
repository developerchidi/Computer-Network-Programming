# Bài 15: Giải hệ phương trình tuyến tính qua mạng

- **Client** gửi hệ phương trình tuyến tính gồm n ẩn và n phương trình (dạng JSON: danh sách ma trận hệ số A và vector hằng số B) đến server.
- **Server** sử dụng phương pháp Gauss-Jordan hoặc pivoting để giải AX = B, gửi kết quả vector nghiệm X về client.
- Yêu cầu: Xử lý sai định dạng, ma trận suy biến (det = 0), hoặc thiếu số phương trình.

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
Nhap so an n: 3
Nhap dong 1 ma tran A (cach nhau bang dau phay): 2,1,-1
Nhap dong 2 ma tran A (cach nhau bang dau phay): -3,-1,2
Nhap dong 3 ma tran A (cach nhau bang dau phay): -2,1,2
Nhap vector B (cach nhau bang dau phay): 8,-11,-3
Nhan ket qua tu server: [2.0, 3.0, -1.0]
```

**Server:**
```
Server is running on port 12345
Nhan he phuong trinh: A=[[2,1,-1],[-3,-1,2],[-2,1,2]], B=[8,-11,-3]
Gui ket qua: [2.0, 3.0, -1.0]
```

---

## Lưu ý
- Nếu hệ vô nghiệm hoặc vô số nghiệm, server sẽ trả về thông báo tương ứng.
- Nếu nhập sai định dạng, thiếu dòng, server sẽ báo lỗi. 