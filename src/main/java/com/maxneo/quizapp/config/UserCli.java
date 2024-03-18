package com.maxneo.quizapp.config;

import static com.maxneo.quizapp.enumerated.Role.SUPERADMIN;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.maxneo.quizapp.model.User;
import com.maxneo.quizapp.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@SuppressWarnings("null")
public class UserCli implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() > 0)
            return;
        var superadmin = User.builder().name("Mohan").email("mohan@gmail.com")
                .password(passwordEncoder.encode("Mohan@123")).phoneNumber("1234567890").role(SUPERADMIN).active(true)
                .build();
        userRepository.save(superadmin);
    }

}
