package vn.edu.stu.doanchuyennganh.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

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

import vn.edu.stu.doanchuyennganh.model.DonHang;
import vn.edu.stu.doanchuyennganh.repository.DonHangRepository;

@RestController
@CrossOrigin
public class DonHangController {
    @Autowired
    DonHangRepository gDonHangRepository;

    @GetMapping("/donhang")
    public ResponseEntity<List<DonHang>> getAllDonHang(){
        List<DonHang> lstDonHang = new ArrayList<DonHang>();
        gDonHangRepository.findAll().forEach(lstDonHang::add);
        if(lstDonHang.size()!=0) return new ResponseEntity<>(lstDonHang, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/donhang/{id}")
    public ResponseEntity<DonHang> getDonHangById(@PathVariable("id") int id){
        Optional<DonHang> donHang = gDonHangRepository.findById(id);
        if(donHang.isPresent()) return new ResponseEntity<>(donHang.get(), HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT); 
        
    }
    @PostMapping("/donhang")
    public ResponseEntity<Object> createDonHang(@RequestBody DonHang donHang){
        try {
            int numberOfCharactor = 8;
            DonHangController rand = new DonHangController();
            DonHang nDonHang = new DonHang();
            nDonHang.setMaDonHang(rand.randomAlphaNumeric(numberOfCharactor));
            nDonHang.setHoTen(donHang.getHoTen());
            nDonHang.setDiaChiGiao(donHang.getDiaChiGiao());
            nDonHang.setSdtGiao(donHang.getSdtGiao());
            nDonHang.setGhiChu(donHang.getGhiChu());
            nDonHang.setNgayTao(new Date());
            nDonHang.setTongtien(donHang.getTongtien());
            nDonHang.setSanPham(donHang.getSanPham());
            nDonHang.setTrangthai(0);
            DonHang saveDonHang = gDonHangRepository.save(nDonHang);
            return new ResponseEntity<>(saveDonHang, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.unprocessableEntity()
					.body("Failed to Create specified Don Hang: " + e.getCause().getCause().getMessage());

        }
    }

    @PutMapping("/donhang/{id}")
    public ResponseEntity<Object> updateDrink(@PathVariable("id") int id, @RequestBody DonHang donHang){
        try {
            Optional<DonHang> result = gDonHangRepository.findById(id);
            DonHang nDonHang = result.get();
            nDonHang.setHoTen(donHang.getHoTen());
            nDonHang.setDiaChiGiao(donHang.getDiaChiGiao());
            nDonHang.setSdtGiao(donHang.getSdtGiao());
            nDonHang.setGhiChu(donHang.getGhiChu());
            nDonHang.setNgayTao(new Date());
            nDonHang.setTongtien(donHang.getTongtien());
            nDonHang.setSanPham(donHang.getSanPham());
            DonHang saveDonHang = gDonHangRepository.save(nDonHang);
            return new ResponseEntity<>(saveDonHang, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity()
					.body("Failed to update specified Don Hang: " + e.getCause().getCause().getMessage());
        }
    }
    @DeleteMapping("/donhang/{id}")
    public ResponseEntity<DonHang> deleteDrink(@PathVariable("id") int id){
        try {
            gDonHangRepository.deleteById(id);
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
