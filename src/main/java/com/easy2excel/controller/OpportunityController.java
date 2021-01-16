package com.easy2excel.controller;

import com.easy2excel.dto.OpportunityDTO;
import com.easy2excel.dto.OpportunityViewDTO;
import com.easy2excel.entity.Opportunity;
import com.easy2excel.repository.OpportunityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.CrudRepository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@Validated
@RequestMapping("/opportunity")
public class OpportunityController extends BaseController<Opportunity, OpportunityDTO, OpportunityViewDTO> {

    public OpportunityController(OpportunityRepository repository) {
        super(repository, "opportunity");
    }

    @Override
    Opportunity createBaseEntity() {
        return new Opportunity();
    }

    @Override
    void setPropertiesOnInput(OpportunityDTO opportunityDTO, Opportunity opportunity) {
        opportunity.setOpportunity_name(opportunityDTO.getName());
    }

    @Override
    OpportunityViewDTO setPropertiesOnViewEntityDTO(Opportunity opportunity, boolean setExtendedProperties) {
        return OpportunityViewDTO.from(opportunity, setExtendedProperties);
    }
}
