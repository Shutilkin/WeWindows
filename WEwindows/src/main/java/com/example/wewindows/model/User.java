package com.example.wewindows.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Table (name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Getter @Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    @NotBlank(message = "user_id not can be blank")
    Integer userId;
    @Column(name = "username")
    @NotBlank(message = "username not can be blank")
    String name;
    @Column(name = "email")
    @NotBlank(message = "email not can be blank")
    @Email
    String email;
    @Column(name = "password")
    @NotBlank(message = "password not can be blank")
    String password;
}
