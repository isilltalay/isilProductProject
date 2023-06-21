package com.project.isilProductProject.services;

import com.project.isilProductProject.dtos.CampaignListDto;
import com.project.isilProductProject.dtos.CreateCampaignDto;
import com.project.isilProductProject.entities.Campaign;
import com.project.isilProductProject.entities.User;
import com.project.isilProductProject.enumeration.AdvantagedAge;
import com.project.isilProductProject.exceptions.NotFoundException;
import com.project.isilProductProject.repositories.CampaignRepository;
import com.project.isilProductProject.results.ErrorResult;
import com.project.isilProductProject.results.Result;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CampaignService {
    private CampaignRepository campaignRepository;
    private UserService userService;

    public CampaignService(CampaignRepository campaignRepository, UserService userService) {
        this.campaignRepository = campaignRepository;
        this.userService = userService;
    }

    public List<CampaignListDto> getAllByAdvantagesProfessionStatusAndAdvantagedAge(int userId) {
        User user = userService.findById(userId);
        List<Campaign> list = new ArrayList<>();

        if (user.getAge() != null) {
            if ((AdvantagedAge.YOUNG.isAdvantaged(user.getAge()))) {
                list.addAll(campaignRepository.getAllByAdvantagedAge(AdvantagedAge.YOUNG));
            } else if ((AdvantagedAge.OLD.isAdvantaged(user.getAge()))) {
                list.addAll(campaignRepository.getAllByAdvantagedAge(AdvantagedAge.OLD));
            }
        }
        if (user.getProfession() != null) {
            if (user.getProfession().isAdvantaged()) {
                list.addAll(campaignRepository.getAllByProfessionStatus(user.getProfession()));
            }
        }
        list.addAll(campaignRepository.findAll());
        return list.stream().map(campaign -> new CampaignListDto(campaign)).distinct().collect(Collectors.toCollection(LinkedList::new));
    }

    public Result createCampaign(CreateCampaignDto createCampaignDto) {
        try {
            Campaign campaign = new Campaign();
            campaign.setCampaign(createCampaignDto.getName());
            campaign.setAdvantagedAge(createCampaignDto.getAdvantagedAge());
            campaign.setProfessionStatus(createCampaignDto.getProfessionStatus());
            campaignRepository.save(campaign);
            return new Result(true, "Campaign created");
        } catch (Exception e) {
            return new ErrorResult("Campaign did not create.");
        }
    }

    public Page<Campaign> getAllCampaign(Pageable pageable) {
        return campaignRepository.findAll(pageable);
    }

    public Result updateCampaign(Integer campaignId, Campaign newCampaign) {
        Optional<Campaign> campaign = campaignRepository.findById(campaignId);
        if (campaign.isPresent()) {
            Campaign campaignUpdate = campaign.get();
            campaignUpdate.setCampaign(newCampaign.getCampaign());
            campaignUpdate.setProfessionStatus(newCampaign.getProfessionStatus());
            campaignUpdate.setAdvantagedAge(newCampaign.getAdvantagedAge());
            campaignRepository.save(campaignUpdate);
            return new Result(true, "Campaign updated.");
        }
        return new ErrorResult("Campaign did not update.");
    }

    public void deleteCampaign(int campaignId) {
        campaignRepository.deleteById(campaignId);
    }
}
