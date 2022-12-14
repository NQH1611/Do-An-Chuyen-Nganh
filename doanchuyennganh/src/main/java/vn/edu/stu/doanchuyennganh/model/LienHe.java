package vn.edu.stu.doanchuyennganh.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "lienhe")
public class LienHe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "hoten")
    private String hoTen;
    @Column(name = "email")
    private String email;
    @Column(name = "dienthoai")
    private String dienThoai;
    @Column(name = "noidung")
    private String noiDung;
    @Column(name = "ngaytao")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date ngayTao;
    public LienHe() {
    }
    public LienHe(int id, String hoTen, String email, String dienThoai, String noiDung, Date ngayTao) {
        this.id = id;
        this.hoTen = hoTen;
        this.email = email;
        this.dienThoai = dienThoai;
        this.noiDung = noiDung;
        this.ngayTao = ngayTao;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getHoTen() {
        return hoTen;
    }
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDienThoai() {
        return dienThoai;
    }
    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }
    public String getNoiDung() {
        return noiDung;
    }
    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }
    public Date getNgayTao() {
        return ngayTao;
    }
    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }
    
}
