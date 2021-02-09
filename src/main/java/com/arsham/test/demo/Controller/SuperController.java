package com.arsham.test.demo.Controller;

import com.arsham.test.demo.Model.User;
import com.arsham.test.demo.Service.SuperServiceImp;
import com.arsham.test.demo.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class SuperController {

    @Autowired
    private SuperServiceImp superService;

    @GetMapping("/hello")
    public String hello(){
        return "hello user";
    }

    @GetMapping("/test")
    @PreAuthorize("hasRole('Super')")
    public String test(){
        return "testing succeed! Super created!";
    }

    @PostMapping("/addAdmin/")
    public User createAdmin(@RequestBody UserDto admin) {

        return superService.createAdmin(admin);
    }

    @DeleteMapping("/deleteAdmin/{id}/")
    public void deleteAdmin(@PathVariable Long id) {
        superService.deleteAdmin(id);
    }

}
