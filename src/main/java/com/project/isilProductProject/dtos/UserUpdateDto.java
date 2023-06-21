package com.project.isilProductProject.dtos;

import com.project.isilProductProject.entities.User;
import com.project.isilProductProject.enumeration.ProfessionStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
public class UserUpdateDto {
    private Integer age;
    private ProfessionStatus professionStatus;
}
