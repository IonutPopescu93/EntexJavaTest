package com.entex.user.repository;

import com.entex.user.model.UserDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<UserDao, Long> {

    UserDao findByUsername(String username);

    UserDao findByEmail(String email);
}
