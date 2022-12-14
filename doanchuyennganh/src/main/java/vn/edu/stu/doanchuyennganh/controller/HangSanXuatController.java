package vn.edu.stu.doanchuyennganh.controller;

import java.util.ArrayList;
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

import vn.edu.stu.doanchuyennganh.model.HangSanXuat;
import vn.edu.stu.doanchuyennganh.repository.HangSanXuatRepository;

@RestController
@CrossOrigin
public class HangSanXuatController {
    @Autowired
    HangSanXuatRepository gHangSanXuatRepository;
    @GetMapping("/hangsanxuat")
    public ResponseEntity<List<HangSanXuat>> getAllHangSanXuat(){
        List<HangSanXuat> lstHangSanXuat = new ArrayList<HangSanXuat>();
        gHangSanXuatRepository.findAll().forEach(lstHangSanXuat::add);
        if(lstHangSanXuat.size()!=0) return new ResponseEntity<>(lstHangSanXuat, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/hangsanxuat/{id}")
    public ResponseEntity<HangSanXuat> getHangSanXuatById(@PathVariable("id") int id){
        Optional<HangSanXuat> hangSanXuat = gHangSanXuatRepository.findById(id);
        if(hangSanXuat.isPresent()) return new ResponseEntity<>(hangSanXuat.get(), HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT); 
        
    }
    @PostMapping("/hangsanxuat")
    public ResponseEntity<Object> createHangSanXuat(@RequestBody HangSanXuat hangSanXuat){
        try {
            int numberOfCharactor = 8;
            HangSanXuatController rand = new HangSanXuatController();
            HangSanXuat nHangSanXuat = new HangSanXuat();
            nHangSanXuat.setMaHangSX(rand.randomAlphaNumeric(numberOfCharactor));
            nHangSanXuat.setTenHangSX(hangSanXuat.getTenHangSX());
            HangSanXuat saveHangSanXuat = gHangSanXuatRepository.save(nHangSanXuat);
            return new ResponseEntity<>(saveHangSanXuat, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.unprocessableEntity()
					.body("Failed to Create specified Hang San Xuat: " + e.getCause().getCause().getMessage());

        }
    }

    @PutMapping("/hangsanxuat/{id}")
    public ResponseEntity<Object> updateHangSanXuat(@PathVariable("id") int id, @RequestBody HangSanXuat hangSanXuat){
        try {
            Optional<HangSanXuat> result = gHangSanXuatRepository.findById(id);
            HangSanXuat nHangSanXuat = result.get();
            nHangSanXuat.setTenHangSX(hangSanXuat.getTenHangSX());
            HangSanXuat saveDonHang = gHangSanXuatRepository.save(nHangSanXuat);
            return new ResponseEntity<>(saveDonHang, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity()
					.body("Failed to update specified Hang San Xuat: " + e.getCause().getCause().getMessage());
        }
    }
    @DeleteMapping("/hangsanxuat/{id}")
    public ResponseEntity<HangSanXuat> deleteHangSanXuat(@PathVariable("id") int id){
        try {
            gHangSanXuatRepository.deleteById(id);
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
