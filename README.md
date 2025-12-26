# 🎬 Quản Lý Bán Vé Rạp Chiếu Phim

## 📌 Giới thiệu
Trong những năm gần đây, ngành công nghiệp điện ảnh Việt Nam phát triển mạnh mẽ, kéo theo nhu cầu tự động hóa và tối ưu hóa quy trình quản lý bán vé tại các rạp chiếu phim. Việc quản lý thủ công dễ dẫn đến sai sót, thất thoát dữ liệu, tốn thời gian và ảnh hưởng đến trải nghiệm khách hàng.

Dự án **Quản lý bán vé rạp chiếu phim** được xây dựng nhằm thiết kế và phát triển một hệ thống quản lý bán vé tự động, hỗ trợ các nghiệp vụ cơ bản của rạp chiếu phim hiện đại như bán vé, quản lý lịch chiếu, quản lý chỗ ngồi, thanh toán và thống kê doanh thu.

---

## 🎯 Mục tiêu hệ thống
- Tự động hóa quy trình bán vé tại rạp
- Quản lý phim, phòng chiếu và lịch chiếu
- Quản lý sơ đồ ghế và trạng thái ghế
- Quản lý hóa đơn, khách hàng
- Hỗ trợ thống kê và báo cáo doanh thu

---

## ⚙️ Chức năng chính
- 🔐 Đăng nhập hệ thống
- 🎞️ Quản lý phim
- 🕒 Quản lý lịch chiếu phim
- 💺 Quản lý ghế ngồi theo từng lịch chiếu
- 🎟️ Bán vé tại quầy
- 💳 Thanh toán và lập hóa đơn
- 📊 Thống kê và báo cáo doanh thu

---

## 🧩 Mô hình dữ liệu
Hệ thống được xây dựng dựa trên mô hình cơ sở dữ liệu quan hệ, bao gồm các bảng chính:

- **KhachHang**: Lưu trữ thông tin khách hàng
- **Phim**: Quản lý thông tin phim
- **Phong**: Quản lý phòng chiếu
- **LichChieuPhim**: Quản lý lịch chiếu phim
- **Ghe**: Quản lý sơ đồ ghế và trạng thái ghế
- **HoaDon**: Quản lý hóa đơn bán vé
- **TaiKhoan**: Quản lý tài khoản đăng nhập hệ thống

Các bảng được liên kết với nhau thông qua khóa chính và khóa ngoại nhằm đảm bảo tính toàn vẹn dữ liệu.

---

## 🛠️ Công nghệ sử dụng
- Ngôn ngữ lập trình: **Java**
- Cơ sở dữ liệu: **SQL Server**
- Kết nối CSDL: **JDBC**
- Công cụ thiết kế: **Class Diagram**
- IDE: IntelliJ IDEA / Eclipse / NetBeans

- ## ▶️ Hướng dẫn chạy chương trình
1. Import file cơ sở dữ liệu `QLRapPhim.sql` vào SQL Server
2. Cấu hình thông tin kết nối database trong project
3. Mở project bằng IDE
4. Chạy chương trình và đăng nhập hệ thống

---

## 👨‍🎓 Nhóm thực hiện
- **Nguyễn Thành Luân** – 22653021  
- **Nguyễn Phạm Tuân** – 22650551  
- **Cao Trọng Nguyễn** – 22671461  

**Lớp:** DHKHMT18CTT – **Nhóm:** 3  
**Trường:** Đại học Công Nghiệp TP.HCM – Khoa Công Nghệ Thông Tin

---

## 📅 Thời gian thực hiện
Tháng 11 năm 2024
