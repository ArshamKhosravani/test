package com.arsham.test.demo.Controller;

import com.arsham.test.demo.Model.Cousre;
import com.arsham.test.demo.Model.User;
import com.arsham.test.demo.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/AddUser/")
    public User createUser(@RequestBody User user) {
        return adminService.createUser(user);
    }

    @DeleteMapping("/deleteUser/{id}/")
    public void deleteUser(@PathVariable long id) {
        adminService.deleteUser(id);
    }

    @PostMapping()
    public void assignCourse(@RequestBody User user, @RequestBody List<Cousre> courses) {
        adminService.assignCourse(user,courses);
    }
}
