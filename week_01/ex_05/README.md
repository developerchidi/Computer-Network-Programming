# Bài 5: Máy chủ giải toán biểu thức hậu tố (postfix)

## Yêu cầu:

- **Client:** Gửi một biểu thức hậu tố, ví dụ: "3 4 2 * +" tới server.
- **Server:** Phân tích và tính giá trị biểu thức, gửi kết quả về client.

**Kiến thức toán học:** Biểu thức hậu tố, ngăn xếp (stack).

**Mục tiêu socket:** Phân tích biểu thức, xử lý ngăn xếp trên server.

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
Nhap bieu thuc hau to (VD: 3 4 2 * +): 3 4 2 * +
Ket qua tu server:
Ket qua: 11.0
```

**Server:**
```
Server is running on port 12345
Nhan: 3 4 2 * +
Tra ve: Ket qua: 11.0
```

**Client (biểu thức sai):**
```
Nhap bieu thuc hau to (VD: 3 4 2 * +): 3 4 + *
Ket qua tu server:
Bieu thuc khong hop le
``` 