package com.project.isilProductProject.services;

import com.project.isilProductProject.dtos.UserUpdateDto;
import com.project.isilProductProject.entities.User;
import com.project.isilProductProject.repositories.UserRepository;
import com.project.isilProductProject.results.ErrorResult;
import com.project.isilProductProject.results.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserService {

    private UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Result addUser(User user) {
        try {
            log.info("Kaydedilen yeni user:{}", user.getUsername());
            user.setPassword(this.passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return new Result(true, "New user added.");
        } catch (Exception e) {
            return new ErrorResult("User did not create.");
        }
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User findById(int userId) {
        return userRepository.findById(userId).get();
    }

    public Result updateUser(Integer userId, UserUpdateDto newUser) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            User foundUser = user.get();
            foundUser.setAge(newUser.getAge());
            foundUser.setProfession(newUser.getProfessionStatus());
            userRepository.save(foundUser);
            return new Result(true, "User updated.");
        } else
            return new ErrorResult("User did not updated");
    }

    public void deleteById(int userId) {
        userRepository.deleteById(userId);
    }
}
