package com.library.management.controller;

import com.library.management.dto.Response.ResponseDTO;
import com.library.management.dto.SignInDTO;
import com.library.management.dto.SignUpDTO;
import com.library.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/user/signUp")
    public ResponseDTO signUp(@RequestBody SignUpDTO signUpDTO) {
        return userService.createUser(signUpDTO);
    }

    @PostMapping("/user/signIn")
    public ResponseDTO signIn(@RequestBody SignInDTO signInDTO) {
        return userService.sigIn(signInDTO);
    }
}
