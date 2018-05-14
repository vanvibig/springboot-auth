package com.kv.springbootlogin.repository;

import com.kv.springbootlogin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
