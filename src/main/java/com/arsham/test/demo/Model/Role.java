package com.arsham.test.demo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Role {

    @Id
    @Column(name = "roll_id")
    private long id;

    @Column(name = "role_name")
    private  Rolename rolename;
}
