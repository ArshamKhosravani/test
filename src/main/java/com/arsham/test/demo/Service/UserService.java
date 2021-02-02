package com.arsham.test.demo.Service;

import com.arsham.test.demo.Model.Cousre;

import java.util.List;

public interface UserService {

    Cousre getCousre(long id);

    List<Cousre> getAllCouses();

    void deleteCourse(long id);
}
