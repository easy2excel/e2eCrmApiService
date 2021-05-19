package com.easy2excel.crm.dto.view;


import com.esay2excel.crm.domain.Organization;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RegistrationViewDTO {

    private UserViewDTO user;

    private OrganizationViewDTO organization;

    public RegistrationViewDTO() {
    }

    public static RegistrationViewDTO from(Organization organization) {
        RegistrationViewDTO registrationViewDTO;
        if (organization == null) {
            registrationViewDTO = null;
        } else {
            registrationViewDTO = new RegistrationViewDTO();
            //registrationViewDTO.setUser(UserViewDTO.from(user));
            registrationViewDTO.setOrganization(OrganizationViewDTO.from(organization));
        }
        return registrationViewDTO;
    }
}
