package com.example.demo.config;

import com.example.demo.entiti.RolUser;
import com.example.demo.entiti.User;
import com.example.demo.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    private final IUserRepository userRepository;
    @Autowired
    public DataLoader(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void run(ApplicationArguments args) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password1 = passwordEncoder.encode("1234");
        BCryptPasswordEncoder passwordEncoder2 = new BCryptPasswordEncoder();
        String password2 = passwordEncoder2.encode("12345");


        userRepository.save(new User("aris", password1, RolUser.ROLE_USER));
        userRepository.save(new User("bello", password2, RolUser.ROLE_ADMIN));


    }

}
