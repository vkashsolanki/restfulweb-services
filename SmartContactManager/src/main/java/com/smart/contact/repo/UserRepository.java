package com.smart.contact.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smart.contact.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
