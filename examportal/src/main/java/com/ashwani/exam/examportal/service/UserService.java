package com.ashwani.exam.examportal.service;

import java.util.Set;

import com.ashwani.exam.examportal.model.User;
import com.ashwani.exam.examportal.model.UserRole;

public interface UserService {
    // creating user
    public User creatUser(User user, Set<UserRole> userRoles) throws Exception;

    // get user by name
    public User getUser(String username);

    // delete user by id
    public User deleteUser(Long userId);
}
