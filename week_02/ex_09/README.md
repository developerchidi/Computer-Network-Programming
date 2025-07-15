# Bài 9: Tính trung bình, lớn nhất, nhỏ nhất của danh sách số thực (UDP)

## Yêu cầu:

- **Client:** Gửi một danh sách các số thực (dạng chuỗi: "2.5,3.7,5.0") đến server qua UDP.
- **Server:** Tính giá trị trung bình, số lớn nhất, số nhỏ nhất, và gửi tất cả các kết quả về client qua UDP.

**Kiến thức toán học:** Trung bình cộng, tìm max, min.

**Mục tiêu socket:** Xử lý chuỗi, tính toán và trả kết quả qua UDP (DatagramSocket).

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
Nhập danh sách số thực (cách nhau bằng dấu phẩy): 2.5,3.7,5.0
Kết quả từ server:
Trung bình: 3.73
Lớn nhất: 5.0
Nhỏ nhất: 2.5
```

**Server:**
```
Server đã sẵn sàng (UDP, port 9008)
Nhận: 2.5,3.7,5.0
Trả về:
Trung bình: 3.73
Lớn nhất: 5.0
Nhỏ nhất: 2.5
``` 