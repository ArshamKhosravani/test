package com.arsham.test.demo.Service;

import com.arsham.test.demo.Model.Cousre;
import com.arsham.test.demo.Model.Role;
import com.arsham.test.demo.Model.Rolename;
import com.arsham.test.demo.Model.User;
import com.arsham.test.demo.Repository.UserRepo;
import com.arsham.test.demo.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserRepo userRepo;

    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public User createUser(UserDto userDto) {
        User newUser = new User();
        newUser.setPassword(encoder().encode(userDto.getPassword()));
        newUser.setName(userDto.getUsername());
        Role roleUser = new Role();
        roleUser.setRolename(Rolename.User);
        newUser.setRole(roleUser);
        return userRepo.save(newUser);
    }

    @Override
    public void deleteUser(long id) {
        userRepo.deleteById(id);
    }

    @Override
    public void assignCourse(User user, List<Cousre> courses) {
        userRepo.save(user).setCousres(courses);
    }
}
