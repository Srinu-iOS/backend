package com.library.management.service;


import com.library.management.Enum.UserTypeEnum;
import com.library.management.dto.Response.ResponseDTO;
import com.library.management.dto.SignInDTO;
import com.library.management.dto.SignUpDTO;
import com.library.management.model.User;
import com.library.management.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseDTO createUser(SignUpDTO signUpDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        User user = userRepository.findByEmailIdAndUserType(signUpDTO.getEmailId(),UserTypeEnum.USER.getUserTypeId());
        if(user != null) {
            responseDTO.setCode(HttpStatus.NOT_FOUND.value());
            responseDTO.setMessage("Already registered with this mail");
        } else {
            User newUserData = userRepository.saveAndFlush(signUpDTO.toUserEntity());
            responseDTO.setData(newUserData);
            responseDTO.setCode(HttpStatus.OK.value());
        }
        return responseDTO;
    }

    @Override
    public ResponseDTO sigIn(SignInDTO signInDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        User user = userRepository.findByEmailIdAndPassword(signInDTO.getUserName(), signInDTO.getPassword());
        if(user == null) {
            responseDTO.setCode(HttpStatus.NOT_FOUND.value());
            responseDTO.setMessage("user not found");
        } else {
            if(user.getUserType() == UserTypeEnum.USER.getUserTypeId() && !user.getStatus()) {
                responseDTO.setCode(HttpStatus.UNAUTHORIZED.value());
                responseDTO.setMessage("user not activated");
                return responseDTO;
            }
            responseDTO.setData(user);
            responseDTO.setMessage("success");
            responseDTO.setCode(HttpStatus.OK.value());
        }
        return responseDTO;
    }
}
