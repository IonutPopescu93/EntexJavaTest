package com.entex.user.mapper;

import com.entex.user.dto.UserDto;
import com.entex.user.model.UserDao;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto map(UserDao entity){
        UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setCounty(entity.getCounty());
        dto.setLocality(entity.getLocality());
        dto.setEmail(entity.getEmail());
        return dto;
    }
}
