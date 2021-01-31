package com.arsham.test.demo.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table
public class Cousre {

    @Id
    @Column(name = "Course_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "Course_name")
    private String name;

    @ManyToMany
    private List<User> userList;
}
