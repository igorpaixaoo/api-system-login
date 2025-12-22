package com.igor.system_login.controller;

import com.igor.system_login.entity.Users;
import com.igor.system_login.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMessage;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.net.http.HttpRequest;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "user")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("users")
    public List<Users> listAll(){
        return usersService.findAllUsers();
    }

    @GetMapping("findEmail")
    public Users findEmail(@RequestParam("email") String email){
        if(usersService.findByEmail(email) != null){
            return usersService.findByEmail(email);
        }else return null;
    }

    @PostMapping("create")
    public Users create(@RequestBody Users users){
        return usersService.createUsers(users);
    }
}
