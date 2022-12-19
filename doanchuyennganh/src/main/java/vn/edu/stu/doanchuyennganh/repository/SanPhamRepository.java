package vn.edu.stu.doanchuyennganh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import vn.edu.stu.doanchuyennganh.model.SanPham;

public interface SanPhamRepository extends JpaRepository<SanPham, Integer>{
    @Query(value = "select id, model, gia, hinhanh from sanpham limit 8", nativeQuery = true)
    List<SanPhamDTO> getModelAndGiaSanPham();

    List<SanPham> getSanPhamByHangSanXuat(String maHangSX);
}
