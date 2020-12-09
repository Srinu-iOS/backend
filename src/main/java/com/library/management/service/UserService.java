package com.library.management.service;

import com.library.management.dto.Response.ResponseDTO;
import com.library.management.dto.SignInDTO;
import com.library.management.dto.SignUpDTO;

public interface UserService {

    ResponseDTO createUser(SignUpDTO signUpDTO);

    ResponseDTO sigIn(SignInDTO signInDTO);
}
