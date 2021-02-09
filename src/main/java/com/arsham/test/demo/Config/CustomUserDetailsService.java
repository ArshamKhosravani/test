package com.arsham.test.demo.Config;

import com.arsham.test.demo.Exception.UserNotFoundException;
import com.arsham.test.demo.Model.User;
import com.arsham.test.demo.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private final UserRepo userRepository;


    public CustomUserDetailsService(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UserNotFoundException {
        User user = userRepository.findByName(username);

    /*    if ("ali".equals(username)) {
            return new org.springframework.security.core.userdetails.
                    User("ali",
                    passwordEncoder().encode("1234"),
                    new ArrayList<>());
        }

     */

       // return new org.springframework.security.core.userdetails.
              //  User(user.getUsername(), user.getPassword(), user.getAuthorities());


        if (user == null) {
            throw new UsernameNotFoundException(String.format("User %s does not exist!", username));
        }
        //new AccountStatusUserDetailsChecker().check(user);

        return user;
    }
}

