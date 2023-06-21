package com.project.isilProductProject.repositories;

import com.project.isilProductProject.dtos.CampaignListDto;
import com.project.isilProductProject.entities.Campaign;
import com.project.isilProductProject.enumeration.AdvantagedAge;
import com.project.isilProductProject.enumeration.ProfessionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CampaignRepository extends JpaRepository<Campaign, Integer> {
    List<Campaign> getAllByProfessionStatus(ProfessionStatus professionStatus);

    List<Campaign> getAllByAdvantagedAge(AdvantagedAge advantagedAge);
}
