# Bài 13: Truy vấn số nguyên tố trong khoảng bằng luồng liên tục

- **Client** gửi một cặp (a, b) và giữ kết nối mở.
- **Server** gửi lần lượt từng số nguyên tố trong khoảng [a, b] theo kiểu TCP streaming (gửi từng số, mỗi lần cách 1 giây).
- **Client** có thể gửi "STOP" bất kỳ lúc nào để ngắt luồng.
- Không gửi hết rồi mới trả — phải duy trì phiên làm việc lâu dài.

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
Nhap a: 10
Nhap b: 30
Nhan so nguyen to: 11
Nhan so nguyen to: 13
Nhan so nguyen to: 17
Nhan so nguyen to: 19
Nhan so nguyen to: 23
Nhan so nguyen to: 29
(hoặc có thể nhập STOP bất kỳ lúc nào để dừng)
```

**Server:**
```
Server is running on port 12345
Nhan truy van: 10 30
Gui: 11
Gui: 13
Gui: 17
Gui: 19
Gui: 23
Gui: 29
Client da ngat ket noi hoac gui STOP.
```

---

## Lưu ý
- Server gửi từng số, mỗi lần cách 1 giây.
- Client có thể nhập STOP bất kỳ lúc nào để dừng nhận số.
- Kết nối luôn mở cho đến khi client chủ động dừng. 