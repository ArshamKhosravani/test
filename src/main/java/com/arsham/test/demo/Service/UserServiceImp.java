package com.arsham.test.demo.Service;

import com.arsham.test.demo.Model.Cousre;
import com.arsham.test.demo.Repository.CousreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private CousreRepository cousreRepository;

    @Override
    public Cousre getCousre(long id) {
        return cousreRepository.findById(id);
    }

    @Override
    public List<Cousre> getAllCouses() {
        return cousreRepository.findAll();
    }

    @Override
    public void deleteCourse(long id) {
        cousreRepository.deleteById(id);
    }

}
