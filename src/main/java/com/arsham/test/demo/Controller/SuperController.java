package com.arsham.test.demo.Controller;

import com.arsham.test.demo.Model.Role;
import com.arsham.test.demo.Model.Rolename;
import com.arsham.test.demo.Model.User;
import com.arsham.test.demo.Service.SuperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
public class SuperController {

    @Autowired
    private SuperService superService;

    @PostMapping("/addAdmin/")
    public User createAdmin(@RequestBody User admin) {
        return superService.createAdmin(admin);
    }

    @DeleteMapping("/deleteAdmin/{id}/")
    public void deleteAdmin(@PathVariable Long id) {
        superService.deleteAdmin(id);
    }

    @PostConstruct
    public User initialSuperUser() {
        User user = new User();
        Role role = new Role();
        role.setRolename(Rolename.Super);
        user.setRole(role);
        return user;
    }
}
