package com.entex.user.mapper;

import com.entex.user.dto.UserDto;
import com.entex.user.model.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    @Autowired
    private PasswordEncoder bcryptEncoder;

    public UserDto map(UserDao entity){
        UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setCounty(entity.getCounty());
        dto.setLocality(entity.getLocality());
        dto.setEmail(entity.getEmail());
        return dto;
    }

    public UserDao update(UserDao userToUpdate, UserDto data) {
        userToUpdate.setUsername(data.getUsername());
        userToUpdate.setEmail(data.getEmail());
        userToUpdate.setCounty(data.getCounty());
        userToUpdate.setLocality(data.getLocality());
        userToUpdate.setPassword(bcryptEncoder.encode(data.getPassword()));
        return userToUpdate;
    }
}
