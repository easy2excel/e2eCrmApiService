package com.easy2excel.crm.dto.view;

import com.esay2excel.crm.domain.Organization;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class OrganizationViewDTO {

    private String orgId;

    private String orgName;

    private String country;

    private String url;

    private String companySize;

    private String phoneNo;

    private String dialCode;

    private List<UserViewDTO> user = new ArrayList<>();

    public OrganizationViewDTO(String orgId, String orgName, String country, String url, String companySize, String phoneNo, String dialCode) {
        this.orgId = orgId;
        this.orgName = orgName;
        this.country = country;
        this.url = url;
        this.companySize = companySize;
        this.phoneNo = phoneNo;
        this.dialCode = dialCode;
    }

    public static OrganizationViewDTO from(Organization org) {
        OrganizationViewDTO organizationViewDTO;
        if (org == null) {
            organizationViewDTO = null;
        } else {
            organizationViewDTO = new OrganizationViewDTO(org.getId(), org.getOrgName(), org.getCountry(), org.getUrl(), org.getCompanySize(), org.getPhoneNo(), org.getDialCode());
        }
        return organizationViewDTO;
    }
    /*private String orgId;
    private String orgName;
    private String country;
    private String url;
    private String companySize;
    private String phoneNo;
    private String dialCode;*/
}
