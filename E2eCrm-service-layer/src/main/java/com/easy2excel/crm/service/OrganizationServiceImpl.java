package com.easy2excel.crm.service;


import com.easy2excel.crm.dto.OrganizationDTO;
import com.esay2excel.crm.domain.Organization;
import com.esay2excel.crm.repository.OrganizationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	OrganizationRepository organizationRepository;
	@Override
	public OrganizationDTO saveOrganization(OrganizationDTO organizationDTO) {

		Organization organization = new Organization();
		setPropertyOnInput(organizationDTO, organization);
		Organization dbOrganization = organizationRepository.save(organization);
		return OrganizationDTO.from(dbOrganization);
	}

	private void setPropertyOnInput(OrganizationDTO organizationDTO, Organization organization) {
		organization.setOrgName(organizationDTO.getOrgName());
		organization.setCountry(organizationDTO.getCountry());
		organization.setUrl(organizationDTO.getUrl());
		organization.setCompanySize(organizationDTO.getCompanySize());
		organization.setPhoneNo(organizationDTO.getPhoneNo());
		organization.setDialCode(organizationDTO.getDialCode());
	}

	@Override
	public OrganizationDTO updateOrganization(String organizationId,OrganizationDTO organizationDTO) {
		Organization organization = organizationRepository.findById(organizationId).orElseThrow((() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Organization not found " + organizationId)));
		setPropertyOnInput(organizationDTO,organization);
		Organization updatedOrganization = organizationRepository.save(organization);
		return OrganizationDTO.from(updatedOrganization);
	}

	@Override
	public OrganizationDTO getOrganization(String organizationId) {
		Organization organization = organizationRepository.findById(organizationId).orElseThrow((() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Organization not found " + organizationId)));
		return OrganizationDTO.from(organization);
	}

}
