package com.restpagination.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restpagination.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
