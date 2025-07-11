# Bài 9: Tính trung bình danh sách số

- **Client** gửi một danh sách các số thực (dạng chuỗi: "2.5,3.7,5.0") đến **server**.
- **Server** tính giá trị trung bình, số lớn nhất, số nhỏ nhất, và gửi tất cả các kết quả về client.

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
Nhap danh sach so thuc (cach nhau bang dau phay): 2.5,3.7,5.0
Ket qua tu server:
Trung binh: 3.73
Lon nhat: 5.0
Nho nhat: 2.5
```

**Server:**
```
Server is running on port 12345
Nhan: 2.5,3.7,5.0
Tra ve:
Trung binh: 3.73
Lon nhat: 5.0
Nho nhat: 2.5
``` 