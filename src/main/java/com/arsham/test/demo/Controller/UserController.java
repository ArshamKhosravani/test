package com.arsham.test.demo.Controller;

import com.arsham.test.demo.Model.Cousre;
import com.arsham.test.demo.Model.User;
import com.arsham.test.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getCousre/{id}")
    public Cousre getCousre(@PathVariable long id) {
        return userService.getCousre(id);
    }

    @GetMapping("/getAllCourses/")
    public List<Cousre> getAllCouses() {
        return userService.getAllCouses();
    }

    @DeleteMapping("/deleteCousre/{id}")
    public void deleteCourse(@PathVariable long id) {
        userService.deleteCourse(id);
    }
}
