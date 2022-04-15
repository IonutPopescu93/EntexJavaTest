package com.entex.user.service;

import com.entex.user.dto.UserDto;
import com.entex.user.mapper.UserMapper;
import com.entex.user.model.UserDao;
import com.entex.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder bcryptEncoder;
    @Autowired
    private UserMapper userMapper;


    public void saveUser(UserDto userDto) {
        UserDao user = new UserDao();
        user.setUsername(userDto.getUsername());
        user.setPassword(bcryptEncoder.encode(userDto.getPassword()));
        user.setEmail(userDto.getEmail());
        user.setCounty(userDto.getCounty());
        user.setLocality(userDto.getLocality());
        userRepository.save(user);
    }

    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(user -> userMapper.map(user))
                .collect(Collectors.toList());
    }
}

