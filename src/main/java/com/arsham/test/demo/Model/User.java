package com.arsham.test.demo.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "USER")
public class User implements Serializable {

    @Id
    @Column(name = "_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "_name")
    @Setter
    private String name;

    @ManyToOne
    private Role role;

    public User(User user) {
    }

    public User(long id, String name, Role role, List<Cousre> cousres) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.cousres = cousres;
    }

    public User(){

    }

    public void setRole(Role role) {
        this.role = role;
    }

    @ManyToMany
    private List<Cousre> cousres;



}
