package com.example.spring_security_thymeleaf.Repository;

import com.example.spring_security_thymeleaf.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

}
