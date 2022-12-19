-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 16, 2022 at 03:47 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `doanchuyennganh`
--

-- --------------------------------------------------------

--
-- Table structure for table `danhmuc`
--

CREATE TABLE `danhmuc` (
  `id` int(11) NOT NULL,
  `madanhmuc` varchar(12) DEFAULT NULL,
  `tendanhmuc` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `danhmuc`
--

INSERT INTO `danhmuc` (`id`, `madanhmuc`, `tendanhmuc`) VALUES
(1, 'QvLbkdv1', 'Gaming'),
(2, 'm6t34hu3', 'Văn Phòng'),
(3, 'wOkgYt5M', 'Đồ Họa');

-- --------------------------------------------------------

--
-- Table structure for table `donhang`
--

CREATE TABLE `donhang` (
  `id` int(11) NOT NULL,
  `diachigiao` varchar(255) DEFAULT NULL,
  `ghichu` varchar(255) DEFAULT NULL,
  `hoten` varchar(255) DEFAULT NULL,
  `madonhang` varchar(255) DEFAULT NULL,
  `ngaytao` datetime DEFAULT NULL,
  `sdtgiao` varchar(255) DEFAULT NULL,
  `tongtien` decimal(19,2) DEFAULT NULL,
  `trangthai` int(11) DEFAULT NULL,
  `idsan_phams` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `donhang`
--

INSERT INTO `donhang` (`id`, `diachigiao`, `ghichu`, `hoten`, `madonhang`, `ngaytao`, `sdtgiao`, `tongtien`, `trangthai`, `idsan_phams`) VALUES
(2, 'Gia Lai', 'nhẹ tay', 'quốc huy', 'R42WhT3Q', '2022-12-16 05:47:38', '0369173417', NULL, 3, 4),
(3, 'gia lai', 'nhẹ tay', 'quốc huy', 'wodERF0A', '2022-12-16 05:47:39', '0369173417', NULL, 0, 4),
(4, 'Gia Lai', 'Nhẹ tay', 'Quốc Huy', '36PJ0QJ2', '2022-12-16 05:48:53', '0369173417', NULL, 0, 4);

-- --------------------------------------------------------

--
-- Table structure for table `hangsanxuat`
--

CREATE TABLE `hangsanxuat` (
  `id` int(11) NOT NULL,
  `mahangsx` varchar(12) DEFAULT NULL,
  `tenhangsx` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `hangsanxuat`
--

INSERT INTO `hangsanxuat` (`id`, `mahangsx`, `tenhangsx`) VALUES
(1, 'kJ2OAY19', 'Dell'),
(2, 'XuAMdF9N', 'Lenovo'),
(3, 'JhUr3Byh', 'Mac'),
(4, 'uHZiwLfP', 'Gigabyte'),
(5, 'EGEjOvu7', 'Asus'),
(6, 'oEpyCFTM', 'Acer');

-- --------------------------------------------------------

--
-- Table structure for table `lienhe`
--

CREATE TABLE `lienhe` (
  `id` int(11) NOT NULL,
  `dienthoai` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `hoten` varchar(255) DEFAULT NULL,
  `ngaytao` datetime DEFAULT NULL,
  `noidung` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `sanpham`
--

CREATE TABLE `sanpham` (
  `id` int(11) NOT NULL,
  `cpu` text DEFAULT NULL,
  `ram` text DEFAULT NULL,
  `vga` text DEFAULT NULL,
  `conggiaotiep` varchar(255) DEFAULT NULL,
  `gia` decimal(19,2) DEFAULT NULL,
  `hang_san_xuat` varchar(255) DEFAULT NULL,
  `hedieuhanh` varchar(255) DEFAULT NULL,
  `hinhanh` varchar(255) DEFAULT NULL,
  `ketnoi` varchar(255) DEFAULT NULL,
  `khuyenmai` varchar(255) DEFAULT NULL,
  `kichthuoc` varchar(255) DEFAULT NULL,
  `loai_san_pham` varchar(255) DEFAULT NULL,
  `manhinh` varchar(255) DEFAULT NULL,
  `mau_sac` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `ocung` varchar(255) DEFAULT NULL,
  `pin` varchar(255) DEFAULT NULL,
  `trongluong` varchar(255) DEFAULT NULL,
  `webcam` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `sanpham`
--

INSERT INTO `sanpham` (`id`, `cpu`, `ram`, `vga`, `conggiaotiep`, `gia`, `hang_san_xuat`, `hedieuhanh`, `hinhanh`, `ketnoi`, `khuyenmai`, `kichthuoc`, `loai_san_pham`, `manhinh`, `mau_sac`, `model`, `ocung`, `pin`, `trongluong`, `webcam`) VALUES
(3, 'Core i5 11400H (2.6 Ghz Up to 4.4 Ghz, 12MB)', '16GB 3200Mhz, 2 Khe, up to 32GB', 'NVIDIA GeForce RTX 3050 4GB GDDR6', '4 x USB 3.1 Gen 1 Type-A (one Always On)', '20990000.00', 'Gigabyte', 'Windows 11 Home', 'C:\\fakepath\\21725-laptop-gigabyte-gaming-g5-md-51s1123so.jpg', 'Dual 10/100/1000Mbps Ethernet,802.11 ac Wi-Fi + Bluetooth v4.1', 'Giảm trực tiếp khi áp dụng mã \"NC100\" : 1.000.000đ', '38.0 x 26.5 x 2.58 cm', 'Gaming', '15.6 Inch Full HD, 100% srgb', 'Black', 'Gigabyte Gaming G5 GD 51S1123SO/51VN123SO', '512GB SSD / có thể Nâng cấp 1 ổ Sata 2.5\"', '4 Cell', '2.2kg', 'Có'),
(4, 'AMD Ryzen 7 5800H', '16GB DDR4 3200Mhz (2*8GB)', 'Nvidia Geforce RTX3050Ti 4G DDR6', '1 x (RJ-45); 1 x HDMI 2.1 port; 2 x USB 3.2 Gen 1 ports; 1x USB 3.2 Gen 1 port with PowerShare; 1xUSB 3.2 Gen 2 Type-C port with Display Port', '26490000.00', 'Dell', 'Windows 11 Home', 'C:\\fakepath\\21740-laptop-dell-gaming-g15-5515-70266675--nc.jpg', 'Realtek ALC3254 with Nahimic 3D Audio for Gamers', 'Vệ sinh bảo dưỡng Laptop miễn phí trọn đời trị giá: 1 triệu đồng', '38.0 x 26.5 x 2.58 cm', 'Gaming', '15.6-inch FHD (1920 x1080) 120Hz 250 nits', 'Gray', 'Laptop Dell Gaming G15 5515 70266675', '512GB SSD M.2 PCIe NVMe (+ M.2 SSD 2230/2280 slot)', '3 Cell', '2.8kg', 'Có'),
(5, 'Intel Core i7-11800H', '8GB', 'Geforce RTX 3060 6GB', 'Wi-Fi 6 (802.11ax) + Bluetooth 5.2 (Băng tần kép) 2 * 2; (* Phiên bản BT có thể thay đổi khi nâng cấp hệ điều hành.)', '29490000.00', 'Asus', 'Windows 11 SL', 'C:\\fakepath\\23245-laptop-asus-tuf-gaming-fx506hm-hn366w-11.jpg', '1x 3.5mm kết hợp giắc cắm âm thanh', 'Vệ sinh bảo dưỡng Laptop miễn phí trọn đời trị giá: 1 triệu đồng', '35,9 x 25,6 x 2,28 ~ 2,43 cm (14,13 \"x 10,08\" x 0,90 \"~ 0,96\")', 'Gaming', '15.6 inch FHD-144Hz', 'Black', 'Laptop ASUS TUF Gaming FX506HM-HN366W', '512GB SSD', '90WHrs, 4S1P, 4 cell Li-ion', '2.3kg', 'Có'),
(6, 'AMD Ryzen 7 4800H', '16GB DDR4 3200Mhz (2*8GB)', 'Nvidia Geforce RTX 3050 Ti 4GB', '1 x (RJ-45); 1 x HDMI 2.1 port; 2 x USB 3.2 Gen 1 ports; 1x USB 3.2 Gen 1 port with PowerShare; 1xUSB 3.2 Gen 2 Type-C port with Display Port', '26490000.00', 'Asus', 'Windows 11 Home', 'C:\\fakepath\\23250-laptop-asus-gaming-rog-strix-g513rm-hq055w-9.jpg', '1x 3.5mm kết hợp giắc cắm âm thanh', 'Vệ sinh bảo dưỡng Laptop miễn phí trọn đời trị giá: 1 triệu đồng', '38.0 x 26.5 x 2.58 cm', 'Gaming', '15.6 inch FHD, 144Hz', 'Black', 'Laptop Asus ROG Strix G153 G513IE-HN246W', '512GB SSD', '4 Cell', '2.8kg', 'Có'),
(7, 'AMD R7-6800H', '8GB', 'NVIDIA GeForce RTX 3060 6GB', '1 x (RJ-45); 1 x HDMI 2.1 port; 2 x USB 3.2 Gen 1 ports; 1x USB 3.2 Gen 1 port with PowerShare; 1xUSB 3.2 Gen 2 Type-C port with Display Port', '26490000.00', 'Gigabyte', 'Windows 11 Home', 'C:\\fakepath\\22203-fa507rm-hn018w.jpg', 'Realtek ALC3254 with Nahimic 3D Audio for Gamers', 'Vệ sinh bảo dưỡng Laptop miễn phí trọn đời trị giá: 1 triệu đồng', '35,9 x 25,6 x 2,28 ~ 2,43 cm (14,13 \"x 10,08\" x 0,90 \"~ 0,96\")', 'Gaming', '15.6 inch FHD', 'Black', 'Laptop Asus TUF Gaming A15 FA507RM-HN018W', '512GB SSD', '4 Cell', '2.2kg', 'Có'),
(8, 'Intel Core i5-12450H', '8GB DDR4 3200MHz', 'NVIDIA GeForce RTX 3060 6GB', '4 x USB 3.1 Gen 1 Type-A (one Always On)', '29490000.00', 'Asus', 'Windows 11 Home', 'C:\\fakepath\\23762-laptop-msi-gaming-katana-gf66-12uck-804vn-6.jpg', '1x 3.5mm kết hợp giắc cắm âm thanh', 'Vệ sinh bảo dưỡng Laptop miễn phí trọn đời trị giá: 1 triệu đồng', '38.0 x 26.5 x 2.58 cm', 'Gaming', '15.6 inch FHD (1920x1080), 144Hz, IPS-Level', 'Black', 'Laptop MSI Gaming Katana GF66 12UCK-699VN', '512GB SSD M.2 PCIe NVMe (+ M.2 SSD 2230/2280 slot)', '90WHrs, 4S1P, 4 cell Li-ion', '2.8kg', 'Có'),
(9, 'Intel Core I3-1115G4', '8GB', 'Intel UHD Graphics', '4 x USB 3.1 Gen 1 Type-A (one Always On)', '11490000.00', 'Asus', 'Windows 11 Home', 'C:\\fakepath\\22706-msi-14.jpg', 'Dual 10/100/1000Mbps Ethernet,802.11 ac Wi-Fi + Bluetooth v4.1', 'Vệ sinh bảo dưỡng Laptop miễn phí trọn đời trị giá: 1 triệu đồng', '319 x 219 x 16.9 mm', 'Văn Phòng', '14 inch FHD 60 Hz', 'Black', 'Laptop MSI Modern 14 B11MOU-1027VN', '256GB SSD', '4 Cell', '1.3kg', 'Có'),
(10, 'Intel Core i7-1255U', '16GB', 'Intel Iris Xe Graphics', '4 x USB 3.1 Gen 1 Type-A (one Always On)', '20990000.00', 'Acer', 'Windows 11 SL', 'C:\\fakepath\\23083-laptop-hp-pavilion-x360-14-ek0056tu-6l294pa-8.jpg', 'Dual 10/100/1000Mbps Ethernet,802.11 ac Wi-Fi + Bluetooth v4.1', 'Giảm trực tiếp khi áp dụng mã \"NC100\" : 1.000.000đ', '35,9 x 25,6 x 2,28 ~ 2,43 cm (14,13 \"x 10,08\" x 0,90 \"~ 0,96\")', 'Văn Phòng', '14 inch FHD, Touch', 'Pink', 'Laptop ACER Pavilion X360 14-ek0055TU 6L293PA', '512GB SSD', '4 Cell', '1.3kg', 'Có'),
(11, 'Intel Core i3-1215U (up to 4.4 Ghz, 10 MB)', '8GB', 'Intel UHD Graphics', '1 x (RJ-45); 1 x HDMI 2.1 port; 2 x USB 3.2 Gen 1 ports; 1x USB 3.2 Gen 1 port with PowerShare; 1xUSB 3.2 Gen 2 Type-C port with Display Port', '11490000.00', 'Lenovo', 'Windows 11 SL', 'C:\\fakepath\\23083-laptop-hp-pavilion-x360-14-ek0056tu-6l294pa-8.jpg', 'Realtek ALC3254 with Nahimic 3D Audio for Gamers', 'Vệ sinh bảo dưỡng Laptop miễn phí trọn đời trị giá: 1 triệu đồng', '35,9 x 25,6 x 2,28 ~ 2,43 cm (14,13 \"x 10,08\" x 0,90 \"~ 0,96\")', 'Gaming', '15.6 inch FHD', 'Gray', 'Laptop HP Pavilion 15-eg2063TU 6K791PA', '256GB SSD', '3 Cell', '2.8kg', 'Có'),
(12, 'M2 Chip', '8GB', '', '2 x Thunderbolt', '37990000.00', 'Mac', 'MacOS', 'C:\\fakepath\\22899-apple-m2-gray-7[1].jpg', 'WiFi 802.11ax (Wifi 6)', '', '30.41 x 21.24 x 1.56 cm', 'Văn Phòng', '13.3 inch', 'Silver', 'Laptop Apple Macbook Pro M2', '512GB SSD', '4 Cell', '1.3kg', 'Có');

-- --------------------------------------------------------

--
-- Table structure for table `sanpham_donhang`
--

CREATE TABLE `sanpham_donhang` (
  `donhang_id` int(11) NOT NULL,
  `sanpham_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `diachi` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `hoten` varchar(255) DEFAULT NULL,
  `ngaysinh` datetime DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` int(11) DEFAULT NULL,
  `sodienthoai` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `diachi`, `email`, `hoten`, `ngaysinh`, `password`, `role`, `sodienthoai`, `username`) VALUES
(1, 'Gia Lai', 'quochuy@gmail.com', 'Nguyễn Quốc Huy', '2001-01-14 07:00:00', 'quochuy', 1, '0369173417', 'quochuy'),
(2, 'Gia Lai', 'quochuy@gmail.com', 'Quốc Huy', '2001-01-14 07:00:00', 'user', 0, '0369173417', 'user'),
(3, 'Tân Phú', 'quochuy.140101@gmail.com', 'nguyenhuy', '2022-11-29 07:00:00', 'quochuy123', 0, '0369173417', 'quochuy123'),
(4, 'Tân Phú', 'quochuy.140101@gmail.com', 'minhkhang', '2022-12-03 07:00:00', 'trmkhang', 0, '0369173417', 'trmkhang');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `danhmuc`
--
ALTER TABLE `danhmuc`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `donhang`
--
ALTER TABLE `donhang`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `hangsanxuat`
--
ALTER TABLE `hangsanxuat`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `lienhe`
--
ALTER TABLE `lienhe`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sanpham_donhang`
--
ALTER TABLE `sanpham_donhang`
  ADD PRIMARY KEY (`donhang_id`,`sanpham_id`),
  ADD KEY `FKrfqtfp5u3ksjk8s19gfsr9qr3` (`sanpham_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `danhmuc`
--
ALTER TABLE `danhmuc`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `donhang`
--
ALTER TABLE `donhang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `hangsanxuat`
--
ALTER TABLE `hangsanxuat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `lienhe`
--
ALTER TABLE `lienhe`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
