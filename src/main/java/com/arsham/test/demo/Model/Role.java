package com.arsham.test.demo.Model;

import javax.persistence.*;

@Entity
@Table
public class Role {
    public Role() {
    }

    @Id
    @Column(name = "roll_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "role_name")
    private Rolename rolename;

    public void setRolename(Rolename rolename) {
        this.rolename = rolename;
    }

}
