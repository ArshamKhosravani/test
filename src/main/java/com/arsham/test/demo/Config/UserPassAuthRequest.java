package com.arsham.test.demo.Config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserPassAuthRequest {

    private String username;
    private String password;
}
