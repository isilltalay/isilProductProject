package com.project.isilProductProject.controllers;

import com.project.isilProductProject.dtos.UserUpdateDto;
import com.project.isilProductProject.entities.User;
import com.project.isilProductProject.results.GenericResponse;
import com.project.isilProductProject.results.Result;
import com.project.isilProductProject.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/createUser")
    public Result createUser(@RequestBody User newUser) {
        log.info(newUser.toString());
         return userService.addUser(newUser);
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable int userId) {
        return userService.findById(userId);
    }

    @PutMapping("/{userId}")
    public Result updateUser(@PathVariable int userId, @RequestBody UserUpdateDto newUser) {
        return userService.updateUser(userId, newUser);

    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable int userId) {
        userService.deleteById(userId);
    }
}
