package com.arsham.test.demo.Service;

import com.arsham.test.demo.Model.Cousre;
import com.arsham.test.demo.Repository.CousreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private CousreRepository cousreRepository;

    public Cousre getCousre(long id) {
        return cousreRepository.findById(id);
    }

    public List<Cousre> getAllCouses() {
        return cousreRepository.findAll();
    }

    public void deleteCourse(long id) {
        cousreRepository.deleteById(id);
    }

}
