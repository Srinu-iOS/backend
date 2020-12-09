package com.library.management.repositories;

import com.library.management.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmailIdAndPassword(String userName, String password);
    User findByEmailIdAndUserType(String userName, Integer userType);
    User findByUserId(Long userId);
}
