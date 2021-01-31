package com.arsham.test.demo.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "USER")
public class User {

    @Id
    @Column(name = "_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "_name")
    private String name;

    @ManyToOne
    private Role role;

    @ManyToMany
    private List<Cousre> cousres;


}
