package com.ashwani.exam.examportal.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.ashwani.exam.examportal.model.User;
import com.ashwani.exam.examportal.model.UserRole;
import com.ashwani.exam.examportal.repo.RoleRepository;
import com.ashwani.exam.examportal.repo.UserRepository;
import com.ashwani.exam.examportal.service.UserService;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    // creating user
    @Override
    public User creatUser(User user, Set<UserRole> userRoles) throws Exception {

        User local = this.userRepository.findByUserName(user.getUsername());

        if (local != null) {
            System.out.println("User is already there");
            throw new Exception("User already present");
        } else {
            for (UserRole ur : userRoles) {
                roleRepository.save(ur.getRole());
            }

            user.getUserRoles().addAll(userRoles);
            local = this.userRepository.save(user);
        }

        return local;
    }

}
