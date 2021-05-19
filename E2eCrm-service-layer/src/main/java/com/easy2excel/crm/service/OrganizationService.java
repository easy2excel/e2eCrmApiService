package com.easy2excel.crm.service;


import com.easy2excel.crm.dto.OrganizationDTO;

public interface OrganizationService {

	public OrganizationDTO saveOrganization(OrganizationDTO organizationDTO);
	
	public OrganizationDTO updateOrganization(String organizationId ,OrganizationDTO organizationDTO);
	
	public OrganizationDTO getOrganization(String organizationId);

}
