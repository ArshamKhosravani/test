package com.arsham.test.demo.Service;

import com.arsham.test.demo.Model.User;
import com.arsham.test.demo.dto.UserDto;

public interface SuperService {

    User createAdmin(UserDto admin);
    void deleteAdmin(Long id);
}
