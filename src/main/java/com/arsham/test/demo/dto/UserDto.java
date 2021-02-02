package com.arsham.test.demo.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserDto implements Serializable {

    @NotNull
    private String username;
    @NotNull
    private String password;
}
