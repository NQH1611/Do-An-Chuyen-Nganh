package vn.edu.stu.doanchuyennganh.model;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "sanpham")
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "model")
    private String model;
    @Column(name = "CPU")
    private String CPU;
    @Column(name = "VGA")
    private String VGA;
    @Column(name = "RAM")
    private String RAM;
    @Column(name = "ocung")
    private String oCung;
    @Column(name = "manhinh")
    private String manHinh;
    @Column(name = "ketnoi")
    private String ketNoi;
    @Column(name = "conggiaotiep")
    private String congGiaoTiep;
    @Column(name = "webcam")
    private String webcam;
    @Column(name = "hedieuhanh")
    private String heDieuHanh;
    @Column(name = "pin")
    private String pin;
    @Column(name = "kichthuoc")
    private String kichThuoc;
    @Column(name = "trongluong")
    private String trongLuong;
    @Column(name = "mauSac")
    private String mauSac;
    @Column(name = "gia")
    private BigDecimal gia;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hangsanxuat")
    @JsonIgnore
    private HangSanXuat hangSanXuat;
    @Column(name = "hinhanh")
    private String hinhAnh;
    @Column(name = "khuyenmai")
    private String khuyenMai;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loaisanpham")
    @JsonIgnore
    private LoaiSanPham loaiSanPham;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "sanPhams")
    private Set<DonHang> donHangs;
    public SanPham() {
    }
   
    public SanPham(int id, String model, String CPU, String VGA, String RAM, String oCung, String manHinh,
            String ketNoi, String congGiaoTiep, String webcam, String heDieuHanh, String pin, String kichThuoc,
            String trongLuong, String mauSac, BigDecimal gia, HangSanXuat hangSanXuat, String hinhAnh, String khuyenMai,
            LoaiSanPham loaiSanPham) {
        this.id = id;
        this.model = model;
        this.CPU = CPU;
        this.VGA = VGA;
        this.RAM = RAM;
        this.oCung = oCung;
        this.manHinh = manHinh;
        this.ketNoi = ketNoi;
        this.congGiaoTiep = congGiaoTiep;
        this.webcam = webcam;
        this.heDieuHanh = heDieuHanh;
        this.pin = pin;
        this.kichThuoc = kichThuoc;
        this.trongLuong = trongLuong;
        this.mauSac = mauSac;
        this.gia = gia;
        this.hangSanXuat = hangSanXuat;
        this.hinhAnh = hinhAnh;
        this.khuyenMai = khuyenMai;
        this.loaiSanPham = loaiSanPham;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getCPU() {
        return CPU;
    }
    public void setCPU(String cPU) {
        CPU = cPU;
    }
    public String getVGA() {
        return VGA;
    }
    public void setVGA(String vGA) {
        VGA = vGA;
    }
    public String getRAM() {
        return RAM;
    }
    
    public BigDecimal getGia() {
        return gia;
    }

    public void setGia(BigDecimal gia) {
        this.gia = gia;
    }

    public LoaiSanPham getLoaiSanPham() {
        return loaiSanPham;
    }

    public void setLoaiSanPham(LoaiSanPham loaiSanPham) {
        this.loaiSanPham = loaiSanPham;
    }

    public void setRAM(String rAM) {
        RAM = rAM;
    }
    public String getoCung() {
        return oCung;
    }
    public void setoCung(String oCung) {
        this.oCung = oCung;
    }
    public String getManHinh() {
        return manHinh;
    }
    public void setManHinh(String manHinh) {
        this.manHinh = manHinh;
    }
    public String getKetNoi() {
        return ketNoi;
    }
    public void setKetNoi(String ketNoi) {
        this.ketNoi = ketNoi;
    }
    public String getCongGiaoTiep() {
        return congGiaoTiep;
    }
    public void setCongGiaoTiep(String congGiaoTiep) {
        this.congGiaoTiep = congGiaoTiep;
    }
    public String getWebcam() {
        return webcam;
    }
    public void setWebcam(String webcam) {
        this.webcam = webcam;
    }
    public String getHeDieuHanh() {
        return heDieuHanh;
    }
    public void setHeDieuHanh(String heDieuHanh) {
        this.heDieuHanh = heDieuHanh;
    }
    public String getPin() {
        return pin;
    }
    public void setPin(String pin) {
        this.pin = pin;
    }
    public String getKichThuoc() {
        return kichThuoc;
    }
    public void setKichThuoc(String kichThuoc) {
        this.kichThuoc = kichThuoc;
    }
    public String getTrongLuong() {
        return trongLuong;
    }
    public void setTrongLuong(String trongLuong) {
        this.trongLuong = trongLuong;
    }
    public String getMauSac() {
        return mauSac;
    }
    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }
    public HangSanXuat getHangSanXuat() {
        return hangSanXuat;
    }
    public void setHangSanXuat(HangSanXuat hangSanXuat) {
        this.hangSanXuat = hangSanXuat;
    }
    public String getHinhAnh() {
        return hinhAnh;
    }
    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
    public String getKhuyenMai() {
        return khuyenMai;
    }
    public void setKhuyenMai(String khuyenMai) {
        this.khuyenMai = khuyenMai;
    }
    
}
