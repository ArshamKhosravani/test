package com.arsham.test.demo.Service;

import com.arsham.test.demo.Model.Role;
import com.arsham.test.demo.Model.Rolename;
import com.arsham.test.demo.Model.User;
import com.arsham.test.demo.Repository.UserRepo;
import com.arsham.test.demo.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class SuperServiceImp implements SuperService {

    @Autowired
    private UserRepo userRepo;

    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public User createAdmin(UserDto admin) {
        User newUser = new User();
        newUser.setPassword(encoder().encode(admin.getPassword()));
        newUser.setName(admin.getUsername());
        Role roleUser = new Role();
        roleUser.setRolename(Rolename.User);
        newUser.setRole(roleUser);
        return userRepo.save(newUser);
    }

    @Override
    public void deleteAdmin(Long id) {
        userRepo.deleteById(id);
    }
}
