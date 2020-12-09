package com.library.management.dto;

import com.library.management.Enum.UserTypeEnum;
import com.library.management.model.User;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class SignUpDTO {
    private String password;

    private String emailId;

    private String name;

    private String mobileNumber;

    public User toUserEntity() {
        User user = new User();
        user.setName(this.name);
        user.setMobileNumber(this.mobileNumber);
        user.setEmailId(this.emailId);
        user.setPassword(this.password);
        user.setStatus(true);
        user.setUserType(UserTypeEnum.USER.getUserTypeId());
        user.setCreatedDt(new Timestamp(new Date().getTime()));
        user.setUpdatedDt(new Timestamp(new Date().getTime()));
        return user;
    }
}
