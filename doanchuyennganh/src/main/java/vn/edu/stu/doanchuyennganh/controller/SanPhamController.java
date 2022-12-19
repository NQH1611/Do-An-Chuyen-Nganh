package vn.edu.stu.doanchuyennganh.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import vn.edu.stu.doanchuyennganh.model.SanPham;
import vn.edu.stu.doanchuyennganh.repository.SanPhamDTO;
import vn.edu.stu.doanchuyennganh.repository.SanPhamRepository;

@RestController
@CrossOrigin
public class SanPhamController {
    @Autowired
    SanPhamRepository gSanPhamRepository;

    @GetMapping("/sanpham")
    public ResponseEntity<List<SanPham>> getAllSanPham() {
        List<SanPham> lstSanPham = new ArrayList<SanPham>();
        gSanPhamRepository.findAll().forEach((lstSanPham::add));
        if (lstSanPham.size() != 0)
            return new ResponseEntity<>(lstSanPham, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
    @GetMapping("/model")
    public ResponseEntity<List<SanPhamDTO>> getModelAndPriceFromSanPham() {
        List<SanPhamDTO> lstModel = new ArrayList<SanPhamDTO>();
        gSanPhamRepository.getModelAndGiaSanPham().forEach(lstModel::add);
        if (lstModel.size() != 0) return new ResponseEntity<>(lstModel, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/gethangsx/{maHangSX}")
    public ResponseEntity<List<SanPham>> getSanPhamByMaHangSX(@PathVariable("maHangSX") String maHangSX){
        List<SanPham> lstSanPham = new ArrayList<SanPham>();
        gSanPhamRepository.getSanPhamByHangSanXuat(maHangSX).forEach(lstSanPham::add);
        if (lstSanPham.size() != 0) return new ResponseEntity<>(lstSanPham, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/sanpham/{id}")
    public ResponseEntity<SanPham> getSanPhamById(@PathVariable("id") int id) {
        Optional<SanPham> sanPham = gSanPhamRepository.findById(id);
        if (sanPham.isPresent())
            return new ResponseEntity<>(sanPham.get(), HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @PostMapping("/sanpham")
    public ResponseEntity<Object> createSanPham(@RequestBody SanPham sanPham){
        try {
            SanPham nSanPham = new SanPham();
            nSanPham.setModel(sanPham.getModel());
            nSanPham.setCpu(sanPham.getCpu());
            nSanPham.setVga(sanPham.getVga());
            nSanPham.setRam(sanPham.getRam());
            nSanPham.setoCung(sanPham.getoCung());
            nSanPham.setManHinh(sanPham.getManHinh());
            nSanPham.setKetNoi(sanPham.getKetNoi());
            nSanPham.setCongGiaoTiep(sanPham.getCongGiaoTiep());
            nSanPham.setWebcam(sanPham.getWebcam());
            nSanPham.setHeDieuHanh(sanPham.getHeDieuHanh());
            nSanPham.setPin(sanPham.getPin());
            nSanPham.setKichThuoc(sanPham.getKichThuoc());
            nSanPham.setTrongLuong(sanPham.getTrongLuong());
            nSanPham.setMauSac(sanPham.getMauSac());
            nSanPham.setGia(sanPham.getGia());
            nSanPham.setHangSanXuat(sanPham.getHangSanXuat());
            nSanPham.setHinhAnh(sanPham.getHinhAnh());
            nSanPham.setKhuyenMai(sanPham.getKhuyenMai());
            nSanPham.setLoaiSanPham(sanPham.getLoaiSanPham());
            SanPham saveSanPham = gSanPhamRepository.save(nSanPham);
        return new ResponseEntity<>(saveSanPham, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/sanpham/{id}")
    public ResponseEntity<Object> updateSanPham(@PathVariable("id") int id, @RequestBody SanPham sanPham){
        try {
            Optional<SanPham> result = gSanPhamRepository.findById(id);
            SanPham nSanPham = result.get();
            nSanPham.setModel(sanPham.getModel());
            nSanPham.setCpu(sanPham.getCpu());
            nSanPham.setVga(sanPham.getVga());
            nSanPham.setRam(sanPham.getRam());
            nSanPham.setoCung(sanPham.getoCung());
            nSanPham.setManHinh(sanPham.getManHinh());
            nSanPham.setKetNoi(sanPham.getKetNoi());
            nSanPham.setCongGiaoTiep(sanPham.getCongGiaoTiep());
            nSanPham.setWebcam(sanPham.getWebcam());
            nSanPham.setHeDieuHanh(sanPham.getHeDieuHanh());
            nSanPham.setPin(sanPham.getPin());
            nSanPham.setKichThuoc(sanPham.getKichThuoc());
            nSanPham.setTrongLuong(sanPham.getTrongLuong());
            nSanPham.setMauSac(sanPham.getMauSac());
            nSanPham.setGia(sanPham.getGia());
            nSanPham.setHangSanXuat(sanPham.getHangSanXuat());
            nSanPham.setHinhAnh(sanPham.getHinhAnh());
            nSanPham.setKhuyenMai(sanPham.getKhuyenMai());
            nSanPham.setLoaiSanPham(sanPham.getLoaiSanPham());
            SanPham saveSanPham = gSanPhamRepository.save(nSanPham);
            return new ResponseEntity<>(saveSanPham, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/sanpham/{id}")
    public ResponseEntity<SanPham> deleteLienHe(@PathVariable("id") int id){
        try {
            gSanPhamRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
