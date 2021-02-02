package com.arsham.test.demo.Service;

import com.arsham.test.demo.Model.Cousre;
import com.arsham.test.demo.Model.User;
import com.arsham.test.demo.dto.UserDto;

import java.util.List;

public interface AdminService {

    User createUser(UserDto user);

    void deleteUser(long id);

    void assignCourse(User user, List<Cousre> courses);
}
