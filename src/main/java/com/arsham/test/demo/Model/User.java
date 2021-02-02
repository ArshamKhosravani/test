package com.arsham.test.demo.Model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@Table(name = "USER")
public class User implements Serializable, UserDetails {

    @Id
    @Column(name = "_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "_name")
    private String name;

    @ManyToOne
    private Role role;

    @Column
    private String password;

    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }


    public void setPassword(String encode) {
        encode = encoder().encode(encode);
        this.password = encode;
    }


    public User(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public User() {

    }

    public void setRole(Role role) {
        this.role = role;
    }

    @ManyToMany
    private List<Cousre> cousres;

    public void setCousres(List<Cousre> cousres) {
        this.cousres = cousres;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
