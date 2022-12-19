package vn.edu.stu.doanchuyennganh.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import vn.edu.stu.doanchuyennganh.model.User;
import vn.edu.stu.doanchuyennganh.repository.UserDTO;
import vn.edu.stu.doanchuyennganh.repository.UserRepository;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    UserRepository gUserRepository;

    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> lstUser = new ArrayList<User>();
        gUserRepository.findAll().forEach(lstUser::add);
        if(lstUser.size()!=0) return new ResponseEntity<>(lstUser, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
    @GetMapping("/username/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id){
        Optional<User> user = gUserRepository.findById(id);
        if(user.isPresent()) return new ResponseEntity<>(user.get(), HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user){
        User nUser = new User();
        nUser.setHoTen(user.getHoTen());
        nUser.setNgaySinh(user.getNgaySinh());
        nUser.setSoDienThoai(user.getSoDienThoai());
        nUser.setDiaChi(user.getDiaChi());
        nUser.setEmail(user.getEmail());
        nUser.setUsername(user.getUsername());
        nUser.setPassword(user.getPassword());
        nUser.setRole(user.getRole());
        User saveUser = gUserRepository.save(nUser);
        return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
    }

    @PostMapping("/login?username={username}&password={password}")
    public ResponseEntity<Object> login(@PathVariable("username") String username, @PathVariable("username") String password){
        String un = username;
        String pw = password;
        Optional<User> result = gUserRepository.getUserbyUsernameAndPassword(un, pw);
        if(result.isPresent()) return new ResponseEntity<>(result.get(), HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
    @PutMapping("/update/user/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable("id") int id, @RequestBody User user){
        Optional<User> result = gUserRepository.findById(id);
        User nUser = result.get();
        nUser.setHoTen(user.getHoTen());
        nUser.setNgaySinh(user.getNgaySinh());
        nUser.setSoDienThoai(user.getSoDienThoai());
        nUser.setDiaChi(user.getDiaChi());
        nUser.setEmail(user.getEmail());
        nUser.setUsername(user.getUsername());
        nUser.setPassword(user.getPassword());
        nUser.setRole(user.getRole());
        User saveUser = gUserRepository.save(nUser);
        return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
    }
}
