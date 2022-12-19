package vn.edu.stu.doanchuyennganh.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
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
    @Column(name = "trangthai")
    private int trangthai;
    private int idsanPhams;
    
    public DonHang() {
    }

    public DonHang(int id, String maDonHang, String hoTen, String diaChiGiao, String sdtGiao, String ghiChu,
            Date ngayTao, int trangthai, int idsanPhams) {
        this.id = id;
        this.maDonHang = maDonHang;
        this.hoTen = hoTen;
        this.diaChiGiao = diaChiGiao;
        this.sdtGiao = sdtGiao;
        this.ghiChu = ghiChu;
        this.ngayTao = ngayTao;
        this.trangthai = trangthai;
        this.idsanPhams = idsanPhams;
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

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    public int getIdsanPhams() {
        return idsanPhams;
    }

    public void setIdsanPhams(int idsanPhams) {
        this.idsanPhams = idsanPhams;
    }

    
}
