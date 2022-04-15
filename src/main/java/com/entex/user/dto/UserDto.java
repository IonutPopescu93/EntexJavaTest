package com.entex.user.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDto {

    private Long id;
    private String email;
    private String username;
    private String locality;
    private String county;
    private String password;
}
