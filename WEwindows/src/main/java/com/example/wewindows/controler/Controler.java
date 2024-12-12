package com.example.wewindows.controler;

import com.example.wewindows.business.AuthenticateUserUseCase;
import com.example.wewindows.business.CreateNewUserUseCase;
import com.example.wewindows.dto.UserAuthenticateDTO;
import com.example.wewindows.dto.UserRegistrationDTO;
import com.example.wewindows.model.User;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RequiredArgsConstructor
@RestController
public class Controler {
    private final CreateNewUserUseCase createNewUserUseCase;
    private final AuthenticateUserUseCase authenticateUserUseCase;

    @PostMapping(value="user/register")
    public ResponseEntity<UserRegistrationDTO> createAccount(@RequestBody User user) {
        return ResponseEntity.ok(createNewUserUseCase.execute(user));
    }

    @PostMapping(value="user/enter")
    public ResponseEntity<Map<String,String>> enterAccount(@RequestBody UserAuthenticateDTO user) {;
        String token = authenticateUserUseCase.execute(user.getEmail(), user.getPassword());
        Map<String,String> response = new HashMap<>();
        response.put("token",token);
        return ResponseEntity.ok(response);
    }
}
