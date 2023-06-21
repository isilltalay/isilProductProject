package com.project.isilProductProject.auth;

import com.project.isilProductProject.configuration.CurrentUser;
import com.project.isilProductProject.dtos.UserSecurityDto;
import com.project.isilProductProject.entities.User;
import com.project.isilProductProject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @PostMapping("/api/login/auth")
    UserSecurityDto handleAuthentication(@CurrentUser User user) {
        return new UserSecurityDto(user, "Başarılı bir şekilde giriş yapıldı");
    }
}
