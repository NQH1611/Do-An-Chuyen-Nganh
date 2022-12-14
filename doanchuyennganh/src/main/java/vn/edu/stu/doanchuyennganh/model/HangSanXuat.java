package vn.edu.stu.doanchuyennganh.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "hangsanxuat")
public class HangSanXuat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "dữ liệu không được trống")
    @Size(min = 6, max = 12)
    @Column(name = "mahangsx")
    private String maHangSX;
    @NotEmpty(message = "dữ liệu không được trống")
    @Column(name = "tenhangsx")
    private String tenHangSX;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "hangSanXuat")
    @JsonIgnore
    private Set<SanPham> sanPhams;
    public HangSanXuat() {
    }
    
    public HangSanXuat(int id, @NotEmpty(message = "dữ liệu không được trống") @Size(min = 6, max = 12) String maHangSX,
            @NotEmpty(message = "dữ liệu không được trống") String tenHangSX, Set<SanPham> sanPhams) {
        this.id = id;
        this.maHangSX = maHangSX;
        this.tenHangSX = tenHangSX;
        this.sanPhams = sanPhams;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getMaHangSX() {
        return maHangSX;
    }
    public void setMaHangSX(String maHangSX) {
        this.maHangSX = maHangSX;
    }
    public String getTenHangSX() {
        return tenHangSX;
    }
    public void setTenHangSX(String tenHangSX) {
        this.tenHangSX = tenHangSX;
    }

    public Set<SanPham> getSanPhams() {
        return sanPhams;
    }

    public void setSanPhams(Set<SanPham> sanPhams) {
        this.sanPhams = sanPhams;
    }
    
}
