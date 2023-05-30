package com.ashwani.exam.examportal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashwani.exam.examportal.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String username);

}
