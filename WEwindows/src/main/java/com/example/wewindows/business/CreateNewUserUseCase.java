package com.example.wewindows.business;

import com.example.wewindows.dto.UserRegistrationDTO;
import com.example.wewindows.model.User;
import com.example.wewindows.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateNewUserUseCase {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @SneakyThrows
    public UserRegistrationDTO execute(com.example.wewindows.model.@Valid User user) {
        if (Boolean.TRUE.equals(isUserRegistered(user))) {
            throw new RuntimeException("User already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return EntityToDtoMapper.getUserRegistrationDTO(userRepository.save(user));
    }

    private boolean isUserRegistered(User user) {
        return userRepository.findUserByEmail(user.getEmail()).isPresent();
    }
}