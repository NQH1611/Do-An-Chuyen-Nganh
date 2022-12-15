package vn.edu.stu.doanchuyennganh.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import vn.edu.stu.doanchuyennganh.model.LoaiSanPham;
import vn.edu.stu.doanchuyennganh.repository.LoaiSanPhamRepository;

@RestController
@CrossOrigin
public class LoaiSanPhamController {
    @Autowired
    LoaiSanPhamRepository gLoaiSanPhamRepository;

    @GetMapping("/loaisanpham")
    public ResponseEntity<List<LoaiSanPham>> getAllLoaiSanPham(){
        List<LoaiSanPham> lstLoaiSanPham = new ArrayList<LoaiSanPham>();
        gLoaiSanPhamRepository.findAll().forEach(lstLoaiSanPham::add);
        if(lstLoaiSanPham.size()!=0) return new ResponseEntity<>(lstLoaiSanPham, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/loaisanpham/{id}")
    public ResponseEntity<LoaiSanPham> getLoaiSanPhamById(@PathVariable("id") int id){
        Optional<LoaiSanPham> LoaiSanPham = gLoaiSanPhamRepository.findById(id);
        if(LoaiSanPham.isPresent()) return new ResponseEntity<>(LoaiSanPham.get(), HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT); 
        
    }
    @PostMapping("/loaisanpham")
    public ResponseEntity<Object> createLoaiSanPham(@RequestBody LoaiSanPham LoaiSanPham){
        try {
            int numberOfCharactor = 8;
            LoaiSanPhamController rand = new LoaiSanPhamController();
            LoaiSanPham nLoaiSanPham = new LoaiSanPham();
            nLoaiSanPham.setMaDanhMuc(rand.randomAlphaNumeric(numberOfCharactor));
            nLoaiSanPham.setTenDanhMuc(LoaiSanPham.getTenDanhMuc());
            LoaiSanPham saveLoaiSanPham = gLoaiSanPhamRepository.save(nLoaiSanPham);
            return new ResponseEntity<>(saveLoaiSanPham, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.unprocessableEntity()
					.body("Failed to Create specified Hang San Xuat: " + e.getCause().getCause().getMessage());

        }
    }

    @PutMapping("/loaisanpham/{id}")
    public ResponseEntity<Object> updateLoaiSanPham(@PathVariable("id") int id, @RequestBody LoaiSanPham LoaiSanPham){
        try {
            Optional<LoaiSanPham> result = gLoaiSanPhamRepository.findById(id);
            LoaiSanPham nLoaiSanPham = result.get();
            nLoaiSanPham.setTenDanhMuc(LoaiSanPham.getTenDanhMuc());
            LoaiSanPham saveDonHang = gLoaiSanPhamRepository.save(nLoaiSanPham);
            return new ResponseEntity<>(saveDonHang, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity()
					.body("Failed to update specified Hang San Xuat: " + e.getCause().getCause().getMessage());
        }
    }
    @DeleteMapping("/loaisanpham/{id}")
    public ResponseEntity<LoaiSanPham> deleteLoaiSanPham(@PathVariable("id") int id){
        try {
            gLoaiSanPhamRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    private static final String alpha = "abcdefghijklmnopqrstuvwxyz"; // a-z
    private static final String alphaUpperCase = alpha.toUpperCase(); // A-Z
    private static final String digits = "0123456789"; // 0-9
    private static final String ALPHA_NUMERIC = alpha + alphaUpperCase + digits;
    private static Random generator = new Random();
    public static int randomNumber(int min, int max) {
        return generator.nextInt((max - min) + 1) + min;
    }
    public String randomAlphaNumeric(int numberOfCharactor) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfCharactor; i++) {
            int number = randomNumber(0, ALPHA_NUMERIC.length() - 1);
            char ch = ALPHA_NUMERIC.charAt(number);
            sb.append(ch);
        }
        return sb.toString();
    }
}
