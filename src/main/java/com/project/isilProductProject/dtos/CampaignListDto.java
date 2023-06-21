package com.project.isilProductProject.dtos;

import com.project.isilProductProject.entities.Campaign;
import lombok.*;

@Data
@NoArgsConstructor
public class CampaignListDto {
    private String campaignName;

    public CampaignListDto(Campaign campaign) {
        this.campaignName = campaign.getCampaign();
    }


}
