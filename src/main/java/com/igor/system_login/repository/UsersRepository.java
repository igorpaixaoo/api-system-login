package com.igor.system_login.repository;

import com.igor.system_login.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    Users findByEmail(String email);
    boolean existsByEmail(String email);
}
