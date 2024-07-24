package com.othree.dao;

import javax.persistence.Embeddable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.othree.entity.Authorities;

public interface AuthoritiesDao extends JpaRepository<Authorities, Embeddable>{

}
