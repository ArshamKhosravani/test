package com.arsham.test.demo.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
public class Role {
    public Role() {
    }

    @Id
    @Column(name = "roll_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "role_name")
    private RoleName rolename;



}
