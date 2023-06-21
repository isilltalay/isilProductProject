package com.project.isilProductProject.entities;

import com.project.isilProductProject.enumeration.AdvantagedAge;
import com.project.isilProductProject.enumeration.ProfessionStatus;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "campaign")
@Data
public class Campaign {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "campaign")
    private String campaign;

    @Column(name = "profession")
    @Enumerated(EnumType.STRING)
    private ProfessionStatus professionStatus;

    @Column(name = "advantaged_age")
    @Enumerated(EnumType.STRING)
    private AdvantagedAge advantagedAge;
}
