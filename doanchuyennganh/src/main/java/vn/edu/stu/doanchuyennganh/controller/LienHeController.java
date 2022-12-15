package vn.edu.stu.doanchuyennganh.controller;

import java.util.ArrayList;
import java.util.Date;
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

import vn.edu.stu.doanchuyennganh.model.LienHe;
import vn.edu.stu.doanchuyennganh.repository.LienHeRepository;

@RestController
@CrossOrigin
public class LienHeController {
    @Autowired
    LienHeRepository gLienHeRepository;

    @GetMapping("/lienhe")
    public ResponseEntity<List<LienHe>> getAllLienHe(){
        List<LienHe> lstLienHe = new ArrayList<LienHe>();
        gLienHeRepository.findAll().forEach(lstLienHe::add);
        if(lstLienHe.size()!=0) return new ResponseEntity<>(lstLienHe, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/lienhe/{id}")
    public ResponseEntity<LienHe> getLienHeById(@PathVariable("id") int id){
        Optional<LienHe> lienHe = gLienHeRepository.findById(id);
        if(lienHe.isPresent()) return new ResponseEntity<>(lienHe.get(), HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT); 
        
    }
    @PostMapping("/lienhe")
    public ResponseEntity<Object> createLienHe(@RequestBody LienHe lienHe){
        try {
            LienHe nLienHe = new LienHe();
            nLienHe.setHoTen(lienHe.getHoTen());
            nLienHe.setEmail(lienHe.getEmail());
            nLienHe.setDienThoai(lienHe.getDienThoai());
            nLienHe.setNoiDung(lienHe.getNoiDung());
            nLienHe.setNgayTao(new Date());
            LienHe saveLienHe= gLienHeRepository.save(nLienHe);
            return new ResponseEntity<>(saveLienHe, HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.unprocessableEntity()
					.body("Failed to Create specified Lien He: " + e.getCause().getCause().getMessage());

        }
    }
    @PutMapping("/lienhe/{id}")
    public ResponseEntity<Object> updateLienHe(@PathVariable("id") int id, @RequestBody LienHe lienHe){
        try {
            Optional<LienHe> result = gLienHeRepository.findById(id);
            LienHe nLienHe = result.get();
            nLienHe.setHoTen(lienHe.getHoTen());
            nLienHe.setEmail(lienHe.getEmail());
            nLienHe.setDienThoai(lienHe.getDienThoai());
            nLienHe.setNoiDung(lienHe.getNoiDung());
            LienHe saveLienHe = gLienHeRepository.save(nLienHe);
            return new ResponseEntity<>(saveLienHe, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity()
					.body("Failed to update specified Hang San Xuat: " + e.getCause().getCause().getMessage());
        }
    }
    @DeleteMapping("/lienhe/{id}")
    public ResponseEntity<LienHe> deleteLienHe(@PathVariable("id") int id){
        try {
            gLienHeRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
