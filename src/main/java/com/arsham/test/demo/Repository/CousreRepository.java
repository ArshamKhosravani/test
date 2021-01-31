package com.arsham.test.demo.Repository;

import com.arsham.test.demo.Model.Cousre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CousreRepository extends JpaRepository<Cousre,Long> {
    Cousre findById(long id);
}
