package com.igor.system_login.service;

import com.igor.system_login.entity.Users;
import com.igor.system_login.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public List<Users> findAllUsers(){
        return usersRepository.findAll();
    }

    public Users findByEmail(String email){
        return usersRepository.findByEmail(email);
    }

    public Users createUsers(Users users){
        if(!usersRepository.existsByEmail(users.getEmail())){
            return usersRepository.save(users);
        }else throw new RuntimeException("Email already exists");
    }

}
