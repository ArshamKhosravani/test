package com.arsham.test.demo.Service;

import com.arsham.test.demo.Model.Role;
import com.arsham.test.demo.Model.RoleName;
import com.arsham.test.demo.Model.User;
import com.arsham.test.demo.Repository.RoleRepo;
import com.arsham.test.demo.Repository.UserRepo;
import com.arsham.test.demo.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
public class SuperServiceImp implements SuperService {

    private final UserRepo userRepo;

    private final RoleRepo roleRepo;

    private final PasswordEncoder passwordEncoder;

    public SuperServiceImp(UserRepo userRepo, RoleRepo roleRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public User createAdmin(UserDto admin) {
        User newUser = new User();
        newUser.setPassword(passwordEncoder.encode(admin.getPassword()));
        newUser.setName(admin.getUsername());
        Role roleUser = new Role();
        roleUser.setRolename(RoleName.User);
        newUser.setRoles(Collections.singleton(roleUser));
        return userRepo.save(newUser);
    }

    @Override
    public void deleteAdmin(Long id) {
        userRepo.deleteById(id);
    }

    @PostConstruct
    public User initialSuperUser() {
        User user = new User();
        Role role = new Role();
        role.setRolename(RoleName.Super);
        roleRepo.save(role);
        Set<Role> roleSet=new HashSet<>();
        roleSet.add(role);
        user.setRoles(roleSet);
        user.setName("ali");
        user.setPassword(passwordEncoder.encode("123"));
        user.setCousres(Collections.emptyList());
        user.setId(100);
        userRepo.save(user);
        return user;
    }



}


