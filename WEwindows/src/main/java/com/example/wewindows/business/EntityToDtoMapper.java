package com.example.wewindows.business;

import com.example.wewindows.dto.UserRegistrationDTO;
import com.example.wewindows.model.User;

public class EntityToDtoMapper {
    public static UserRegistrationDTO getUserRegistrationDTO(User user) {
        return UserRegistrationDTO.builder().email(user.getEmail())
                .firstName(user.getName())
                .lastName(user.getName())
                .build();
    }
}