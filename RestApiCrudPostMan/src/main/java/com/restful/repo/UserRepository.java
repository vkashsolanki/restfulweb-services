package com.restful.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restful.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
