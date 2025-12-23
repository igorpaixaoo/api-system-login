package com.igor.system_login.controller;

import com.igor.system_login.entity.Users;
import com.igor.system_login.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMessage;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Users> findEmail(@RequestParam("email") String email){
        Users user = usersService.findByEmail(email);
        if(user != null){
            return ResponseEntity.ok(user);
        }else return ResponseEntity.notFound().build();
    }

    @PostMapping("create")
    public ResponseEntity<Users> create(@RequestBody Users users){
        Users user = usersService.createUsers(users);
        return ResponseEntity.ok(user);
    }
}
