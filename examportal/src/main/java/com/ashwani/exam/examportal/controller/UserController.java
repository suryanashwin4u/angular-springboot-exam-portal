package com.ashwani.exam.examportal.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashwani.exam.examportal.model.Role;
import com.ashwani.exam.examportal.model.User;
import com.ashwani.exam.examportal.model.UserRole;
import com.ashwani.exam.examportal.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {
        Set<UserRole> roles = new HashSet<>(); // create HashSet

        Role role = new Role(); // adding custom roles in an object
        role.setRoleId(45L);
        role.setRoleName("Normal");

        UserRole userRole = new UserRole(); // adding userroles in an object
        userRole.setUser(user);
        userRole.setRole(role);

        roles.add(userRole); // add user roles

        return this.userService.creatUser(user, roles);
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username) {
        return this.userService.getUser(username);
    }

    @DeleteMapping("/{userId}")
    public User deleteUser(@PathVariable("userId") Long userId) {
        return this.userService.deleteUser(userId);
    }
}
