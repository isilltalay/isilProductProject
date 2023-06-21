package com.project.isilProductProject.dtos;

import com.project.isilProductProject.enumeration.AdvantagedAge;
import com.project.isilProductProject.enumeration.ProfessionStatus;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CreateCampaignDto {
    private String name;
    private ProfessionStatus professionStatus;

    public CreateCampaignDto(String name, ProfessionStatus professionStatus, AdvantagedAge advantagedAge) {
        this.name = name;
        this.professionStatus = professionStatus;
        this.advantagedAge = advantagedAge;
    }

    private AdvantagedAge advantagedAge;

}
