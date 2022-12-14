package vn.edu.stu.doanchuyennganh.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "donhang")
public class DonHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "madonhang")
    private String maDonHang;
    @Column(name = "hoten")
    private String hoTen;
    @Column(name = "diachigiao")
    private String diaChiGiao;
    @Column(name = "sdtgiao")
    private String sdtGiao;
    @Column(name = "ghichu")
    private String ghiChu;
    @Column(name = "ngaytao")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date ngayTao;
    @Column(name = "tongtien")
    private BigDecimal tongTien;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "sanpham_donhang", joinColumns = { @JoinColumn(name = "donhang_id")}, inverseJoinColumns = {@JoinColumn(name="sanpham_id")})
    private Set<SanPham> sanPhams;
    
    public DonHang() {
    }

    public DonHang(int id, String maDonHang, String hoTen, String diaChiGiao, String sdtGiao, String ghiChu,
            Date ngayTao, BigDecimal tongTien, Set<vn.edu.stu.doanchuyennganh.model.SanPham> sanPham) {
        this.id = id;
        this.maDonHang = maDonHang;
        this.hoTen = hoTen;
        this.diaChiGiao = diaChiGiao;
        this.sdtGiao = sdtGiao;
        this.ghiChu = ghiChu;
        this.ngayTao = ngayTao;
        this.tongTien = tongTien;
        //this.sanPhams = sanPham;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(String maDonHang) {
        this.maDonHang = maDonHang;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChiGiao() {
        return diaChiGiao;
    }

    public void setDiaChiGiao(String diaChiGiao) {
        this.diaChiGiao = diaChiGiao;
    }

    public String getSdtGiao() {
        return sdtGiao;
    }

    public void setSdtGiao(String sdtGiao) {
        this.sdtGiao = sdtGiao;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public BigDecimal getTongtien() {
        return tongTien;
    }

    public void setTongtien(BigDecimal tongTien) {
        this.tongTien = tongTien;
    }

    public Set<SanPham> getSanPham() {
        return sanPhams;
    }

    public void setSanPham(Set<SanPham> sanPhams) {
        this.sanPhams = sanPhams;
    }
    
    
}
