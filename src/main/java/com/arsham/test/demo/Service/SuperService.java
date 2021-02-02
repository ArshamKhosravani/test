package com.arsham.test.demo.Service;

import com.arsham.test.demo.Model.User;
import com.arsham.test.demo.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class SuperService {

    @Autowired
    private UserRepo userRepo;

    public User createAdmin(User admin) {
        return userRepo.save(admin);
    }

    public void deleteAdmin(Long id) {
        userRepo.deleteById(id);
    }
}
