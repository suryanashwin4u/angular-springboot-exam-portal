package com.ashwani.exam.examportal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashwani.exam.examportal.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
