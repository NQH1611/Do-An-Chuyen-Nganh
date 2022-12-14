package vn.edu.stu.doanchuyennganh.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import vn.edu.stu.doanchuyennganh.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    @Query(value = "SELECT * FROM users where username = ?1 and password = ?2", nativeQuery = true)
    Optional<User> getUserbyUsernameAndPassword(String username, String password);
}
