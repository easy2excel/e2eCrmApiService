package com.easy2excel.crm.dto;

import com.esay2excel.crm.domain.Organization;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class OrganizationDTO {

	
	@JsonProperty("orgName")
	private String orgName;
	
	@JsonProperty("country")
	private String country;

	@JsonProperty("url")
	private String url;

	@JsonProperty("companySize")
	private String companySize;
	
	@JsonProperty("phoneNo")
	private String phoneNo;
	
	@JsonProperty("dialCode")
	private String dialCode;

	public OrganizationDTO(String orgName, String country, String url, String companySize, String phoneNo, String dialCode) {

		this.orgName = orgName;
		this.country = country;
		this.url = url;
		this.companySize = companySize;
		this.phoneNo = phoneNo;
		this.dialCode = dialCode;
	}

	public static OrganizationDTO from(Organization dbOrg) {
		OrganizationDTO organizationDTO ;
		if(null==dbOrg){
			organizationDTO = null;
		}else{
			organizationDTO = new OrganizationDTO(dbOrg.getOrgName(),dbOrg.getCountry(),dbOrg.getUrl(),dbOrg.getCompanySize(),dbOrg.getPhoneNo(),dbOrg.getDialCode());
		}
		return organizationDTO;
    }
}
