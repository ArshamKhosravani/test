package com.arsham.test.demo.Service;

import com.arsham.test.demo.Model.Cousre;
import com.arsham.test.demo.Model.User;
import com.arsham.test.demo.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private UserRepo userRepo;

    public User createUser(User user) {
        return userRepo.save(user);
    }

    public void deleteUser(long id) {
        userRepo.deleteById(id);
    }

    public void assignCourse(User user, List<Cousre> courses) {
        userRepo.save(user).setCousres(courses);
    }
}
