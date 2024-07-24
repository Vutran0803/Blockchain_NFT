package com.othree.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.othree.entity.Role;

public interface RoleDao extends JpaRepository<Role, Integer> {

}
