package com.project.isilProductProject.controllers;

import com.project.isilProductProject.configuration.CurrentUser;
import com.project.isilProductProject.dtos.CampaignListDto;
import com.project.isilProductProject.dtos.CreateCampaignDto;
import com.project.isilProductProject.entities.Campaign;
import com.project.isilProductProject.entities.User;
import com.project.isilProductProject.exceptions.NotFoundException;
import com.project.isilProductProject.results.GenericResponse;
import com.project.isilProductProject.results.Result;
import com.project.isilProductProject.services.CampaignService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campaigns")
public class CampaignController {
    private CampaignService campaignService;

    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    @GetMapping("/getCampaignListByUser")
    public List<CampaignListDto> getCampaignListByUser(@CurrentUser User user) throws Exception {
        return campaignService.getAllByAdvantagesProfessionStatusAndAdvantagedAge(user.getId());
    }

    @GetMapping("/getAll")
    public Page<CampaignListDto> getAllCampaigns(Pageable page) {
        return campaignService.getAllCampaign(page).map(CampaignListDto::new);
    }

    @PutMapping("/{campaignId}")
    public Result updateCampaign(@PathVariable Integer campaignId, @RequestBody Campaign campaign) throws NotFoundException {
        return campaignService.updateCampaign(campaignId, campaign);
    }

    @PostMapping("/create")
    public Result createNewCampaign(@RequestBody CreateCampaignDto createCampaignDto) {
        return campaignService.createCampaign(createCampaignDto);
    }

    @DeleteMapping("/{campaignId}")
    public void deleteCampaign(@PathVariable int campaignId) {
        campaignService.deleteCampaign(campaignId);
    }
}
