package com.arsham.test.demo.Controller;

import com.arsham.test.demo.Model.Cousre;
import com.arsham.test.demo.Model.User;
import com.arsham.test.demo.Service.AdminService;
import com.arsham.test.demo.Service.AdminServiceImpl;
import com.arsham.test.demo.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminServiceImpl;

    @PostMapping("/AddUser/")
    public User createUser(@RequestBody UserDto userDto) {
        return adminServiceImpl.createUser(userDto);
    }

    @DeleteMapping("/deleteUser/{id}/")
    public void deleteUser(@PathVariable long id) {
        adminServiceImpl.deleteUser(id);
    }

    @PostMapping()
    public void assignCourse(@RequestBody UserDto user, @RequestBody List<Cousre> courses) {
        adminServiceImpl.assignCourse(user,courses);
    }
}
