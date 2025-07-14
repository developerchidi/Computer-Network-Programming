# Bài 12: Giao thức xác thực số học ba bước (Three-way Arithmetic Handshake)

- **Client** gửi một số bí mật x.
- **Server** gửi lại một phép toán ngẫu nhiên (ví dụ: "2x + 3", "x^2 - 4x + 1"), client phải giải ngược lại để tìm x, rồi xác minh.
- Nếu client giải đúng trong 2 lần, server mở cổng gửi bài toán chính (challenge).
- Đây là hệ thống xác thực client theo kiểu Zero Knowledge Proof nhẹ nhàng.

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
Nhap so bi mat x: 7
Nhan duoc phep toan: 2x + 3 = ?
Nhap ket qua nghich dao (gia tri x): 7
Server: Dung!
Nhan duoc phep toan: x^2 - 4x + 1 = ?
Nhap ket qua nghich dao (gia tri x): 7
Server: Dung!
Ban da duoc xac thuc thanh cong! Challenge: Congratulation!
```

**Server:**
```
Server is running on port 12345
Nhan x = 7
Gui phep toan: 2x + 3
Nhan x client tra loi: 7 | Dung!
Gui phep toan: x^2 - 4x + 1
Nhan x client tra loi: 7 | Dung!
Xac thuc thanh cong, gui challenge!
```

---

## Lưu ý
- Nếu client trả lời sai, server sẽ báo "Sai!" và kết thúc kết nối.
- Có thể mở rộng thêm nhiều phép toán ngẫu nhiên hơn. 