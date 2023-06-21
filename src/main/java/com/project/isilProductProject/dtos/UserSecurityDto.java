package com.project.isilProductProject.dtos;

import com.project.isilProductProject.entities.User;
import lombok.Data;

@Data
public class UserSecurityDto {
    public UserSecurityDto(User user, String message) {
        this.setUserName(user.getUsername());
        this.message = message;
    }

    private String message;

    private String userName;

}
