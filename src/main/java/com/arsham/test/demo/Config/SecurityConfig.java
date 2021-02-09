package com.arsham.test.demo.Config;

import com.arsham.test.demo.Model.RoleName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtEntryPoint jwtEntryPoint;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtRequestFilter jwTuserPassFilter;


    @Qualifier("customUserDetailsService")
    @Autowired
    private CustomUserDetailsService userDetailsService;


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
      /*  http
                .csrf().disable().sessionManagement()
                .sessionCreationPolicy((SessionCreationPolicy.STATELESS))
                .and()
                .addFilter(new JWTuserPassFilter(authenticationManager()))
                .addFilterAfter(new JwtTokenVerifier(),JWTuserPassFilter.class)


                .authorizeRequests()

                .antMatchers("/authenticated").permitAll()

                .antMatchers("/AddUser/", "/deleteUser/{id}/", "/Assign/")
                .hasRole(Rolename.Admin.name())

                .antMatchers("/addAdmin/", "/deleteAdmin/{id}/")
                .hasRole(Rolename.Super.name())

                .antMatchers("/getCousre/{id}", "/getAllCourses/", "/deleteCousre/{id}")
                .hasRole(Rolename.User.name())
                
                .anyRequest().authenticated()

                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();

       */


        http.csrf().disable()

                .authorizeRequests()
                .antMatchers("/authenticate","/hello").permitAll()

                .antMatchers("/AddUser/", "/deleteUser/{id}/", "/Assign/")
                .hasRole(RoleName.Admin.name())

                .antMatchers("/addAdmin/", "/deleteAdmin/{id}/","/test")
                .hasRole(RoleName.Super.name())

                .antMatchers("/getCousre/{id}", "/getAllCourses/", "/deleteCousre/{id}")
                .hasRole(RoleName.User.name())
                       // anyRequest().authenticated().
                . and().

                        exceptionHandling().authenticationEntryPoint(jwtEntryPoint).and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);


           http.addFilterBefore(jwTuserPassFilter, UsernamePasswordAuthenticationFilter.class);
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}

